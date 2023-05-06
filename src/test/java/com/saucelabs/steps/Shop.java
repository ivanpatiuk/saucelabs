package com.saucelabs.steps;

import com.google.common.collect.Ordering;
import com.saucelabs.entities.OrderingTestData;
import com.saucelabs.models.ItemDTO;
import com.saucelabs.pages.ItemPage;
import com.saucelabs.pages.ShopPage;
import io.netty.util.internal.StringUtil;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static com.saucelabs.entities.TestVariables.HOME_PAGE_URL;
import static com.saucelabs.entities.TestVariables.ONE_SECOND;

@Getter
public class Shop extends ShopPage {

    public Shop(WebDriver driver) {
        super(driver);
    }

    private void assertSorting(final String orderingName, final List<String> items) {
        if (orderingName.contains("Name")) {
            Assert.assertTrue(Ordering.natural().isOrdered(items));
        } else {
            items.forEach(item -> Assert.assertTrue(item.contains("$")));
            Assert.assertTrue(Ordering.natural().isOrdered(items.stream()
                    .map(item -> Double.parseDouble(item.substring(1))).toList()));
        }
    }

    private List<String> getElementsText(final Shop shop, final By by) {
        return shop
                .findElementsBy(by, ONE_SECOND)
                .stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

    private void verifyCartBadge() {
        final String counter = getCartBadgeCounter().getText();
        Assert.assertEquals(counter, "1");
    }

    private void verifyRemoveButton(final String string) {
        final String buttonText = findElementBy(By.xpath(BY_ITEM.replace("<item_title>", string)), ONE_SECOND).getText();
        Assert.assertEquals("Remove", buttonText);
    }

    public void verifySorting(final List<OrderingTestData> orderingTestDataList) {
        orderingTestDataList.forEach(orderingTestData -> {
            selectOrdering(orderingTestData.getOrderingName());
            final List<String> items = getElementsText(this, orderingTestData.getBy());
            if (orderingTestData.isReversed()) {
                Collections.reverse(items);
            }
            assertSorting(orderingTestData.getOrderingName(), items);
        });
    }

    public void verifyItemsOpening() {
        final List<String> itemTitles = findElementsBy(By.xpath("//div[@class='inventory_list']//div[@class='inventory_item_name']"), ONE_SECOND).stream().map(WebElement::getText).toList();
        itemTitles.forEach(itemTitle -> {
            // CREATE ITEM BEFORE CLICKING
            final WebElement itemFromShopPage = findElementBy(By.xpath("//div[@class='inventory_item_label']//div[contains(text(), '" + itemTitle + "')]/ancestor::div[@class='inventory_item']"), ONE_SECOND);
            final ItemDTO itemBeforeClicking = ItemDTO.getItemDTO(itemFromShopPage);
            final WebElement titleButton = findElementBy(By.xpath("//div[@class='inventory_item_label']/a[contains(@id,'link')]"), ONE_SECOND);

            waitUntilClickable(titleButton, ONE_SECOND);
            titleButton.click();

            // CREATE ITEM AFTER CLICKING
            final ItemPage itemPage = new ItemPage(driver);
            final WebElement itemFromItemPage = itemPage.getItem();
            final ItemDTO itemAfterClicking = ItemDTO.getItemDTO(
                    itemFromItemPage,
                    By.xpath("//div[@class='inventory_details_desc_container']//div[contains(@class, 'inventory_details_name')]"),
                    By.xpath("//div[@class='inventory_details_desc_container']//div[contains(@class, 'inventory_details_desc')]"),
                    By.xpath("//div[@class='inventory_details_desc_container']//div[contains(@class, 'inventory_details_price')]"));

            // MOVE TO THE SHOP PAGE AND ASSERT
            itemPage.clickOnBackToProductsButton();
            Assert.assertEquals(itemAfterClicking, itemBeforeClicking);
        });
    }

    public void verifyDescription() {
        final List<String> itemsDescription = getElementsText(this, getInventoryItemsDescription());
        itemsDescription.forEach(description -> Assert.assertFalse(StringUtil.isNullOrEmpty(description)));
    }

    public void verifyOneItemOrdering() {
        final WebElement firstInventoryItem = getItems().get(0);
        final ItemDTO shopPageItem = ItemDTO.getItemDTO(firstInventoryItem);

        addToCart(shopPageItem.getName());
        verifyCartBadge();
        verifyRemoveButton(shopPageItem.getName());
        clickOnCart();

        final Cart cart = new Cart(driver);
        cart.verifyCartPageWithItems(List.of(shopPageItem));


    }

    public void logout() {
        clickOnSideBar();
        clickOnLogout();
        verifyUrl(HOME_PAGE_URL);
    }
}

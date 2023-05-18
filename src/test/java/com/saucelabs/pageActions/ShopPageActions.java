package com.saucelabs.pageActions;

import com.google.common.collect.Ordering;
import com.saucelabs.entities.OrderingTestData;
import com.saucelabs.models.ItemDTO;
import com.saucelabs.pages.ItemPage;
import com.saucelabs.pages.ShopPage;
import com.saucelabs.verifiers.IBadgeCounterVerify;
import io.netty.util.internal.StringUtil;
import lombok.Getter;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static com.saucelabs.entities.TestVariables.*;

@Getter
@Log4j2
public class ShopPageActions extends ShopPage implements IBadgeCounterVerify {

    public ShopPageActions(WebDriver driver) {
        super(driver);
    }

    private void assertSorting(final String orderingName, final List<String> items) {
        log.debug("Asserting sorting for ordering: '{}'.", orderingName);
        if (orderingName.contains("Name")) {
            Assert.assertTrue(Ordering.natural().isOrdered(items));
        } else {
            items.forEach(item -> Assert.assertTrue(item.contains("$")));
            Assert.assertTrue(Ordering.natural().isOrdered(items.stream()
                    .map(item -> Double.parseDouble(item.substring(1))).toList()));
        }
    }

    private List<String> getElementsText(final ShopPageActions shopPageActions, final By by) {
        log.debug("Getting elements text.");
        return shopPageActions
                .findElementsBy(by, ONE_SECOND)
                .stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

    private void verifyRemoveButton(final String itemName, final String expected) {
        log.debug("Verifying remove button for item: '{}'", itemName);
        final String buttonText = findElementBy(By.xpath(BY_ITEM.replace("<item_title>", itemName)), ONE_SECOND).getText();
        Assert.assertEquals(buttonText, expected);
    }

    private void verifyItemAdding(final int expectedCounter, final WebElement webElementItem, final List<ItemDTO> itemDTOS) {
        final ItemDTO itemDTO = ItemDTO.getItemDTO(webElementItem, INVENTORY_ITEM_XPATHS);
        log.debug("Verifying adding the item: '{}'.", itemDTO.getName());
        itemDTOS.add(itemDTO);
        addItemToCartByName(itemDTO.getName());
        verifyCartBadge(getCartBadgeCounter(), String.valueOf(expectedCounter));
    }

    private void verifyItemRemoving(final int expectedCounter, final ItemDTO itemDTO) {
        log.debug("Verifying removing the item: '{}'.", itemDTO.getName());
        removeItem(itemDTO.getName());
        if (expectedCounter != 0) {
            verifyCartBadge(getCartBadgeCounter(), String.valueOf(expectedCounter));
        }
    }

    public void verifyItemsRemoving() {
        log.debug("Verifying items removing.");
        int expectedCounter = 0;
        final List<ItemDTO> itemDTOS = new ArrayList<>();

        for (WebElement webElementItem : getInventoryItems()) {
            verifyItemAdding(++expectedCounter, webElementItem, itemDTOS);
        }
        for (ItemDTO itemDTO : itemDTOS) {
            verifyItemRemoving(--expectedCounter, itemDTO);
        }

        Assert.assertThrows(NoSuchElementException.class, () -> verifyCartBadge(getCartBadgeCounter(), "6"));
    }

    public void verifySorting(final List<OrderingTestData> orderingTestDataList) {
        log.debug("Verifying sorting.");
        orderingTestDataList.forEach(orderingTestData -> {
            selectOrdering(orderingTestData.getOrderingName());
            final List<String> items = getElementsText(this, orderingTestData.getBy());
            if (orderingTestData.isReversed()) {
                Collections.reverse(items);
            }
            assertSorting(orderingTestData.getOrderingName(), items);
        });
    }

    public ItemDTO clickOnItemByName(final String itemName) {
        log.debug("Clicking on item by item name: '{}'", itemName);
        final WebElement itemFromShopPage = findElementBy(By.xpath("//div[@class='inventory_item_label']//div[contains(text(), '" + itemName + "')]/ancestor::div[@class='inventory_item']"), ONE_SECOND);
        final ItemDTO itemBeforeClicking = ItemDTO.getItemDTO(itemFromShopPage, INVENTORY_ITEM_XPATHS);
        final WebElement titleButton = itemFromShopPage.findElement(By.xpath(".//div[@class='inventory_item_label']/a[contains(@id,'link')]"));

        waitUntilClickable(titleButton, ONE_SECOND);
        titleButton.click();

        return itemBeforeClicking;
    }

    public void verifyItemsOpening() {
        log.debug("Verifying items opening.");
        final List<String> itemNames = findElementsBy(By.xpath("//div[@class='inventory_list']//div[@class='inventory_item_name']"), ONE_SECOND).stream().map(WebElement::getText).toList();
        itemNames.forEach(itemName -> {
            // CREATE ITEM BEFORE CLICKING
            final ItemDTO itemBeforeClicking = clickOnItemByName(itemName);

            // CREATE ITEM AFTER CLICKING
            final ItemPage itemPage = new ItemPage(driver);
            final WebElement itemFromItemPage = itemPage.getItem();
            final ItemDTO itemAfterClicking = ItemDTO.getItemDTO(itemFromItemPage, INVENTORY_DETAILS_XPATHS);

            // MOVE TO THE SHOP PAGE AND ASSERT
            itemPage.clickOnBackToProductsButton();
            Assert.assertEquals(itemAfterClicking, itemBeforeClicking);
        });
    }

    public void verifyDescription() {
        log.debug("Verifying description.");
        final List<ItemDTO> itemDTOS = getInventoryItems().stream().map(webElement -> ItemDTO.getItemDTO(webElement, INVENTORY_ITEM_XPATHS)).toList();
        itemDTOS.forEach(description -> Assert.assertFalse(StringUtil.isNullOrEmpty(description.getDescription())));
    }

    public void verifyItemIsNotInCart(final ItemDTO itemDTO) {
        log.debug("Verifying that item is not in the cart: '{}'", itemDTO.getName());
        verifyCartBadge(getCartBadgeCounter(), null);
        verifyRemoveButton(itemDTO.getName(), "Add to cart");
    }

    public List<ItemDTO> addItemsToCartByIndices(final List<Integer> itemIndicesList) {
        log.debug("Adding items to the cart with indices: {}", itemIndicesList);
        final List<ItemDTO> itemDTOS = new ArrayList<>();

        itemIndicesList.forEach(index -> {
            ItemDTO itemDTO = ItemDTO.getItemDTO(getInventoryItems().get(index), INVENTORY_ITEM_XPATHS);
            itemDTOS.add(itemDTO);
            addItemToCartByName(itemDTO.getName());
            verifyCartBadge(getCartBadgeCounter(), String.valueOf(itemDTOS.size()));
            verifyRemoveButton(itemDTO.getName(), "Remove");
        });

        return itemDTOS;
    }

    public ItemDTO addItemToCartAndClickOnItem(final Integer index) {
        final ItemDTO addedItem = addItemsToCartByIndices(List.of(index)).get(0);
        clickOnItemByName(addedItem.getName());
        return addedItem;
    }

    public void logout() {
        log.debug("Logout");
        clickOnSideBar();
        clickOnLogout();
        verifyUrl(HOME_PAGE_URL);
    }
}

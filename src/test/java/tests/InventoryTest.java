package tests;

import com.google.common.collect.Ordering;
import entities.OrderingTestData;
import io.netty.util.internal.StringUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import steps.Home;
import steps.Shop;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static entities.TestVariables.*;

public class InventoryTest extends BaseTest {

    private void assertOrdering(final String orderingName, final List<String> items) {
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

    private List<OrderingTestData> getOrderingTestDataList() {
        return List.of(
                new OrderingTestData("Name (A to Z)", false, By.xpath("//div[@class=\"inventory_list\"]//div[@class=\"inventory_item_name\"]")),
                new OrderingTestData("Name (Z to A)", true, By.xpath("//div[@class=\"inventory_list\"]//div[@class=\"inventory_item_name\"]")),
                new OrderingTestData("Price (low to high)", false, By.xpath("//div[@class=\"inventory_list\"]//div[@class=\"inventory_item_price\"]")),
                new OrderingTestData("Price (high to low)", true, By.xpath("//div[@class=\"inventory_list\"]//div[@class=\"inventory_item_price\"]")));
    }

    private void verifyOrdering(final Shop shop, final List<OrderingTestData> orderingTestDataList) {
        orderingTestDataList.forEach(orderingTestData -> {
            shop.selectOrdering(orderingTestData.getOrderingName());
            List<String> items = getElementsText(shop, orderingTestData.getBy());
            if (orderingTestData.isReversed()){
                Collections.reverse(items);
            }
            // ASSERT
            assertOrdering(orderingTestData.getOrderingName(), items);
        });
    }

    @Test
    void orderingTestShouldSuccess() {
        // GIVEN
        List<OrderingTestData> orderingTestDataList = getOrderingTestDataList();
        // THEN
        Home home = new Home(driver);
        home.successfulLogin(STANDARD_USERNAME, VALID_PASSWORD);

        Shop shop = new Shop(driver);
        verifyOrdering(shop, orderingTestDataList);

    }

    @Test
    void descriptionTestShouldSuccess() {
        // GIVEN
        Home home = new Home(driver);
        home.successfulLogin(STANDARD_USERNAME, VALID_PASSWORD);
        Shop shop = new Shop(driver);
        // THEN
        List<String> itemsDescription = getElementsText(shop, By.xpath("//div[@class=\"inventory_list\"]//div[@class=\"inventory_item_desc\"]"));
        // ASSERT
        itemsDescription.forEach(description -> Assert.assertFalse(StringUtil.isNullOrEmpty(description)));
    }
}

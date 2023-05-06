package com.saucelabs.tests.invenoryTests;

import com.saucelabs.entities.OrderingTestData;
import com.saucelabs.steps.Shop;
import com.saucelabs.tests.LoggedUserBaseTest;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.util.List;

public class InventoryTest extends LoggedUserBaseTest {

    private List<OrderingTestData> getOrderingTestDataList() {
        return List.of(
                new OrderingTestData("Name (A to Z)", false, By.xpath("//div[@class=\"inventory_list\"]//div[@class=\"inventory_item_name\"]")),
                new OrderingTestData("Name (Z to A)", true, By.xpath("//div[@class=\"inventory_list\"]//div[@class=\"inventory_item_name\"]")),
                new OrderingTestData("Price (low to high)", false, By.xpath("//div[@class=\"inventory_list\"]//div[@class=\"inventory_item_price\"]")),
                new OrderingTestData("Price (high to low)", true, By.xpath("//div[@class=\"inventory_list\"]//div[@class=\"inventory_item_price\"]")));
    }

    @Test(dependsOnGroups = "login")
    void orderingTestShouldSuccess() {
        Shop shop = new Shop(driver);
        shop.verifySorting(getOrderingTestDataList());
    }

    @Test(dependsOnGroups = "login")
    void descriptionTestShouldSuccess() {
        Shop shop = new Shop(driver);
        shop.verifyDescription();
    }

    @Test
    void openingItemTestShouldSuccess() {
        Shop shop = new Shop(driver);
        shop.verifyItemsOpening();
    }
}

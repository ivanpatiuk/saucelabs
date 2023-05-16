package com.saucelabs.tests.invenoryTests;

import com.saucelabs.entities.OrderingTestData;
import com.saucelabs.pageActions.ShopPageActions;
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
    void removingItemsTestShouldSuccess() {
        final ShopPageActions shopPageActions = new ShopPageActions(driver);
        shopPageActions.verifyItemsRemoving();
    }

    @Test(dependsOnGroups = "login")
    void sortingTestShouldSuccess() {
        final ShopPageActions shopPageActions = new ShopPageActions(driver);
        shopPageActions.verifySorting(getOrderingTestDataList());
    }

    @Test(dependsOnGroups = "login")
    void descriptionTestShouldSuccess() {
        final ShopPageActions shopPageActions = new ShopPageActions(driver);
        shopPageActions.verifyDescription();
    }

    @Test(dependsOnGroups = "login")
    void openingItemTestShouldSuccess() {
        final ShopPageActions shopPageActions = new ShopPageActions(driver);
        shopPageActions.verifyItemsOpening();
    }
}

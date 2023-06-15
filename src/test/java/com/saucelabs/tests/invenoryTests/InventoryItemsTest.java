package com.saucelabs.tests.invenoryTests;

import com.saucelabs.models.ItemDTO;
import com.saucelabs.pageActions.ItemPageActions;
import com.saucelabs.pageActions.ShopPageActions;
import com.saucelabs.tests.TestDataProvider;
import com.saucelabs.tests.baseTests.LoggedUserBaseTest;
import org.testng.annotations.Test;

public class InventoryItemsTest extends LoggedUserBaseTest {

    @Test(dependsOnGroups = "login")
    void removingItemsTest() {
        shopPageActions.verifyItemsRemoving();
    }

    @Test(dependsOnGroups = "login")
    void sortingItemsTest() {
        shopPageActions.verifySorting(TestDataProvider.getOrderingTestDataList());
    }

    @Test(dependsOnGroups = "login")
    void itemsDescriptionTest() {
        shopPageActions.verifyDescription();
    }

    @Test(dependsOnGroups = "login")
    void openingItemTest() {
        shopPageActions.verifyItemsOpening();
    }

    @Test(dependsOnGroups = "login")
    void removingItemFromItemPageTest() {
        TestDataProvider.getFirstAndLastItemIndices().forEach(index -> {
            final ItemDTO addedItem = shopPageActions.addItemToCartAndClickOnItem(index);

            final ItemPageActions itemPageActions = new ItemPageActions(driver);
            itemPageActions.removeItemAndClickOnBackToProducts(addedItem);

            shopPageActions = new ShopPageActions(driver);
            shopPageActions.verifyItemIsNotInCart(addedItem);
        });
    }

    @Test(dependsOnGroups = "login")
    void addingItemFromItemPageTest() {
        int expectedBadgeCounter = 0;
        for (Integer index : TestDataProvider.getFirstAndLastItemIndices()) {
            final ItemDTO itemToAdd = shopPageActions.clickOnItemByIndex(index + 1);

            final ItemPageActions itemPageActions = new ItemPageActions(driver);
            itemPageActions.addItemAndClickOnBackToProducts(itemToAdd, expectedBadgeCounter);
            ++expectedBadgeCounter;

            shopPageActions = new ShopPageActions(driver);
            shopPageActions.verifyItemIsInCart(itemToAdd, expectedBadgeCounter);
        }
    }
}

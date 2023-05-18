package com.saucelabs.tests.invenoryTests;

import com.saucelabs.models.ItemDTO;
import com.saucelabs.pageActions.ItemPageActions;
import com.saucelabs.pageActions.ShopPageActions;
import com.saucelabs.tests.LoggedUserBaseTest;
import com.saucelabs.tests.TestDataProvider;
import org.testng.annotations.Test;

public class InventoryItemsTest extends LoggedUserBaseTest {

    @Test(dependsOnGroups = "login")
    void removingItemsTestShouldSuccess() {
        final ShopPageActions shopPageActions = new ShopPageActions(driver);
        shopPageActions.verifyItemsRemoving();
    }

    @Test(dependsOnGroups = "login")
    void sortingTestShouldSuccess() {
        final ShopPageActions shopPageActions = new ShopPageActions(driver);
        shopPageActions.verifySorting(TestDataProvider.getOrderingTestDataList());
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

    @Test(dependsOnGroups = "login")
    void removingItemFromItemPageTest() {
        TestDataProvider.getFirstAndLastItemIndices().forEach(index -> {
            ShopPageActions shopPageActions = new ShopPageActions(driver);
            final ItemDTO addedItem = shopPageActions.addItemToCartAndClickOnItem(index);

            final ItemPageActions itemPageActions = new ItemPageActions(driver);
            itemPageActions.removeItemAndClickOnBackToProducts(addedItem);

            shopPageActions = new ShopPageActions(driver);
            shopPageActions.verifyItemIsNotInCart(addedItem);
        });
    }

    // TODO
    @Test(dependsOnGroups = "login")
    void addingItemFromItemPageTest() {
    }
}

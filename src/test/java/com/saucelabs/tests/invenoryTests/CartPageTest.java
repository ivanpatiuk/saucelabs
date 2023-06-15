package com.saucelabs.tests.invenoryTests;

import com.saucelabs.models.ItemDTO;
import com.saucelabs.pageActions.CartPageActions;
import com.saucelabs.pageActions.ShopPageActions;
import com.saucelabs.tests.TestDataProvider;
import com.saucelabs.tests.baseTests.LoggedUserBaseTest;
import org.testng.annotations.Test;

import java.util.List;

public class CartPageTest extends LoggedUserBaseTest {
    @Test(dependsOnGroups = "login")
    void emptyCartTest() {
        shopPageActions.clickOnShoppingCartButton();

        final CartPageActions cartPageActions = new CartPageActions(driver);
        cartPageActions.verifyPageWithEmptyCart();
    }

    @Test(dependsOnGroups = "login")
    void continueShippingWithEmptyCartTest() {
        shopPageActions.clickOnShoppingCartButton();

        final CartPageActions cartPageActions = new CartPageActions(driver);
        cartPageActions.verifyContinuingShoppingWithEmptyCart();

        shopPageActions = new ShopPageActions(driver);
        shopPageActions.verifyNoItemIsInCart();
    }

    @Test(dependsOnGroups = "login")
    void continueShippingWithItemsInCartTest() {
        final List<ItemDTO> addedItems = shopPageActions.addItemsToCartByIndices(TestDataProvider.getFirstAndLastItemIndices());
        shopPageActions.clickOnShoppingCartButton();

        final CartPageActions cartPageActions = new CartPageActions(driver);
        cartPageActions.verifyContinuingShoppingWithItemsInCart(addedItems);

        shopPageActions = new ShopPageActions(driver);
        shopPageActions.verifyItemsIsInCart(addedItems);
    }
}

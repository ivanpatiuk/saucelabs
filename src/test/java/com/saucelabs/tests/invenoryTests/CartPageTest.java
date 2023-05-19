package com.saucelabs.tests.invenoryTests;

import com.saucelabs.pageActions.CartPageActions;
import com.saucelabs.pageActions.ShopPageActions;
import com.saucelabs.tests.baseTests.LoggedUserBaseTest;
import org.testng.annotations.Test;

public class CartPageTest extends LoggedUserBaseTest {
    @Test(dependsOnGroups = "login")
    void emptyCartTest() {
        shopPageActions.clickOnShoppingCartButton();

        final CartPageActions cartPageActions = new CartPageActions(driver);
        cartPageActions.verifyPageWithEmptyCart();
    }

    @Test(dependsOnGroups = "login")
    void continueShoppingWithEmptyCartTest() {
        shopPageActions.clickOnShoppingCartButton();

        final CartPageActions cartPageActions = new CartPageActions(driver);
        cartPageActions.verifyContinuingShoppingWithEmptyCart();

        shopPageActions = new ShopPageActions(driver);
        shopPageActions.verifyNoItemIsInCart();
    }
}

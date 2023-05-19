package com.saucelabs.tests.invenoryTests;

import com.saucelabs.pageActions.CartPageActions;
import com.saucelabs.pageActions.ShopPageActions;
import com.saucelabs.tests.LoggedUserBaseTest;
import org.testng.annotations.Test;

public class CartPageTest extends LoggedUserBaseTest {
    @Test
    void emptyCartTest() {
        final ShopPageActions shopPageActions = new ShopPageActions(driver);
        shopPageActions.clickOnShoppingCartButton();

        final CartPageActions cartPageActions = new CartPageActions(driver);
        cartPageActions.verifyPageWithEmptyCart();
    }


}

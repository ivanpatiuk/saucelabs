package com.saucelabs.tests.itemOrderingTests;

import com.saucelabs.models.ItemDTO;
import com.saucelabs.pageActions.CartPageActions;
import com.saucelabs.pageActions.CheckoutPageOneActions;
import com.saucelabs.pageActions.ShopPageActions;
import com.saucelabs.tests.LoggedUserBaseTest;
import org.testng.annotations.Test;

public class ItemOrderingTest extends LoggedUserBaseTest {

    @Test(dependsOnGroups = "login")
    void orderItemTestShouldSuccess() {
        final ShopPageActions shopPageActions = new ShopPageActions(driver);
        final ItemDTO itemDTO = shopPageActions.addToCartOneItem();

        final CartPageActions cartPageActions = new CartPageActions(driver);
        cartPageActions.checkoutItem(itemDTO);

        final CheckoutPageOneActions checkoutPageOneActionsPage = new CheckoutPageOneActions(driver);
        checkoutPageOneActionsPage.checkoutItems();
    }

//    @Test (dependsOnGroups = "login")
//    void removingItemTestShouldSuccess(){
//        final Cart cart = new Cart(driver);
//        ca shop = new Shop(driver);
//        shop.verifyItemsRemovingFromShopPage();
//    }
}

package com.saucelabs.tests.itemOrderingTests;

import com.saucelabs.models.ItemDTO;
import com.saucelabs.steps.Cart;
import com.saucelabs.steps.CheckoutStepOne;
import com.saucelabs.steps.Shop;
import com.saucelabs.tests.LoggedUserBaseTest;
import org.testng.annotations.Test;

public class ItemOrderingTest extends LoggedUserBaseTest {

    @Test(dependsOnGroups = "login")
    void orderItemTestShouldSuccess() {
        final Shop shop = new Shop(driver);
        final ItemDTO itemDTO = shop.addToCartOneItem();

        final Cart cart = new Cart(driver);
        cart.checkoutItem(itemDTO);

        final CheckoutStepOne checkoutStepOnePage = new CheckoutStepOne(driver);
        checkoutStepOnePage.checkoutItems();
    }

//    @Test (dependsOnGroups = "login")
//    void removingItemTestShouldSuccess(){
//        final Cart cart = new Cart(driver);
//        ca shop = new Shop(driver);
//        shop.verifyItemsRemovingFromShopPage();
//    }
}

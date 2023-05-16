package com.saucelabs.tests.itemOrderingTests;

import com.saucelabs.models.ItemDTO;
import com.saucelabs.pageActions.CartPageActions;
import com.saucelabs.pageActions.CheckoutPageOneActions;
import com.saucelabs.pageActions.CheckoutPageTwoActions;
import com.saucelabs.pageActions.ShopPageActions;
import com.saucelabs.tests.LoggedUserBaseTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

public class ItemOrderingTest extends LoggedUserBaseTest {

    @DataProvider
    Object[][] itemsDataProvider() {
        return new Object[][]{
                {List.of(0)},
                {List.of(5)},
                {List.of(0, 1, 2, 3, 4, 5)}
        };
    }

    @Test(dataProvider = "itemsDataProvider")
    void orderItemsTestShouldSuccess(final List<Integer> itemIndicesList) {
        final ShopPageActions shopPageActions = new ShopPageActions(driver);
        final List<ItemDTO> itemDTOS = shopPageActions.addItemsToCart(itemIndicesList);

        final CartPageActions cartPageActions = new CartPageActions(driver);
        cartPageActions.checkoutItems(itemDTOS);

        final CheckoutPageOneActions checkoutPageOneActionsPage = new CheckoutPageOneActions(driver);
        checkoutPageOneActionsPage.checkoutItems();

        final CheckoutPageTwoActions checkoutPageTwoActions = new CheckoutPageTwoActions(driver);
        checkoutPageTwoActions.finishCheckout(itemDTOS);
    }

//    @Test (dependsOnGroups = "login")
//    void removingItemTestShouldSuccess(){
//        final Cart cart = new Cart(driver);
//        ca shop = new Shop(driver);
//        shop.verifyItemsRemovingFromShopPage();
//    }
}

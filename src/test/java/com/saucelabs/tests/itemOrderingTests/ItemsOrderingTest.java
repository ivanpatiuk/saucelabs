package com.saucelabs.tests.itemOrderingTests;

import com.saucelabs.models.ItemDTO;
import com.saucelabs.pageActions.CartPageActions;
import com.saucelabs.pageActions.CheckoutPageOneActions;
import com.saucelabs.pageActions.CheckoutPageTwoActions;
import com.saucelabs.tests.TestDataProvider;
import com.saucelabs.tests.baseTests.LoggedUserBaseTest;
import org.testng.annotations.Test;

import java.util.List;

public class ItemsOrderingTest extends LoggedUserBaseTest {

    @Test(dependsOnGroups = "login", dataProviderClass = TestDataProvider.class, dataProvider = "itemIndicesDataProvider")
    void itemsCheckoutTest(final List<Integer> itemIndicesList) {
        final List<ItemDTO> itemDTOS = shopPageActions.addItemsToCartByIndices(itemIndicesList);
        shopPageActions.verifyClickingOnShoppingCart();

        final CartPageActions cartPageActions = new CartPageActions(driver);
        cartPageActions.checkoutItems(itemDTOS);

        final CheckoutPageOneActions checkoutPageOneActionsPage = new CheckoutPageOneActions(driver);
        checkoutPageOneActionsPage.checkoutItems();

        final CheckoutPageTwoActions checkoutPageTwoActions = new CheckoutPageTwoActions(driver);
        checkoutPageTwoActions.finishCheckout(itemDTOS);
    }
}

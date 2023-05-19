package com.saucelabs.pageActions;

import com.saucelabs.models.ItemDTO;
import com.saucelabs.pages.CartPage;
import com.saucelabs.verifiers.IBaseItemVerify;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

import static com.saucelabs.entities.TestVariables.*;

@Log4j2
public class CartPageActions extends CartPage implements IBaseItemVerify {

    public CartPageActions(WebDriver driver) {
        super(driver);
    }

    private void baseCartPageVerify() {
        log.debug("Verifying cart page URL, 'Continue shopping' and 'Checkout' buttons.");
        verifyUrl(CART_PAGE_URL);
        waitUntilClickable(getCheckoutButton(), ONE_SECOND);
        waitUntilClickable(getContinueShippingButton(), ONE_SECOND);
    }

    @Override
    public void verifyCartPageWithItems(final List<ItemDTO> itemDTOS) {
        log.debug("Verifying cart page item with items count: {}.", itemDTOS.size());
        Assert.assertEquals(getCartBadgeCounterText(), String.valueOf(itemDTOS.size()));
        verifyCartPage();
        itemDTOS.forEach(itemDTO -> {
            log.debug("Verifying cart page item: {}.", itemDTO.getName());
            final WebElement item = getCartItemByName(itemDTO.getName());
            verifyItemQTY(item);
            verifyItemDescription(item, itemDTO, INVENTORY_ITEM_XPATHS);
        });
    }

    @Override
    public void verifyCartPage() {
        log.debug("Verifying cart page elements.");
        baseCartPageVerify();
        waitUntilClickable(getRemoveButton(), ONE_SECOND);
        waitUntilVisible(getCartBadgeCounter(), ONE_SECOND);
    }

    public void verifyPageWithEmptyCart() {
        log.debug("Verifying cart page with empty cart.");
        baseCartPageVerify();
        Assert.assertEquals(getCartItems().size(), 0);
    }

    public void verifyContinuingShoppingWithEmptyCart() {
        log.debug("Verifying clicking on 'Continue shopping' on cart page with empty cart.");
        baseCartPageVerify();
        clickOnShoppingCartButton();
    }

    public void checkoutItems(final List<ItemDTO> itemDTOS) {
        log.debug("Checkout items.");
        baseCartPageVerify();
        verifyCartPageWithItems(itemDTOS);
        clickOnCheckoutButton();
    }

    // TODO
    public void clickOnRemoveButton() {
        log.debug("Clicking on 'Remove' button.");
    }
}

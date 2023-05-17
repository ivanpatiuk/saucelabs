package com.saucelabs.pageActions;

import com.saucelabs.entities.TestVariables;
import com.saucelabs.models.ItemDTO;
import com.saucelabs.pages.CartPage;
import com.saucelabs.verifiers.IBaseItemVerify;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

import static com.saucelabs.entities.TestVariables.ONE_SECOND;

@Log4j2
public class CartPageActions extends CartPage implements IBaseItemVerify {

    public CartPageActions(WebDriver driver) {
        super(driver);
    }

    @Override
    public void verifyCartPageWithItems(final List<ItemDTO> itemDTOS) {
        log.debug("Verifying cart page item with items count: {}.", itemDTOS.size());
        Assert.assertEquals(getCartBadgeCounter().getText(), String.valueOf(itemDTOS.size()));
        verifyUIElements();
        itemDTOS.forEach(itemDTO -> {
            log.debug("Verifying cart page item: {}.", itemDTO.getName());
            final WebElement item = getCartItemByName(itemDTO.getName());
            verifyItemQTY(item);
            verifyItemDescription(item);
        });
    }

    @Override
    public void verifyUIElements() {
        log.debug("Verifying UI elements.");
        waitUntilClickable(getCheckoutButton(), ONE_SECOND);
        waitUntilClickable(getRemoveButton(), ONE_SECOND);
        waitUntilClickable(getContinueShippingButton(), ONE_SECOND);
        waitUntilVisible(getCartBadgeCounter(), ONE_SECOND);
    }

    public void checkoutItems(final List<ItemDTO> itemDTOS) {
        log.debug("Checkout items.");
        verifyLogoAndUrl(TestVariables.CART_PAGE_URL);
        verifyCartPageWithItems(itemDTOS);
        clickOnCheckoutButton();
    }
}

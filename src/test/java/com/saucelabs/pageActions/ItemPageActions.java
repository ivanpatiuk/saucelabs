package com.saucelabs.pageActions;

import com.saucelabs.models.ItemDTO;
import com.saucelabs.pages.ItemPage;
import com.saucelabs.verifiers.IBadgeCounterVerify;
import com.saucelabs.verifiers.IBaseItemVerify;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;

import static com.saucelabs.entities.TestVariables.INVENTORY_DETAILS_XPATHS;

@Log4j2
public class ItemPageActions extends ItemPage implements IBadgeCounterVerify, IBaseItemVerify {
    public ItemPageActions(WebDriver driver) {
        super(driver);
    }

    public void removeItemAndClickOnBackToProducts(final ItemDTO addedItem) {
        log.debug("Removing item from item page.");
        clickOnAddOrRemoveButton();
        verifyCartBadge(getCartBadgeCounter(), null);
        verifyTextContains(getAddOrRemoveButton(), "Add to cart");
        verifyItemDescription(getItem(), addedItem, INVENTORY_DETAILS_XPATHS);
        clickOnBackToProductsButton();
    }
}

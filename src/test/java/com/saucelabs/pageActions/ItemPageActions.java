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

    private void verifyAddOrRemoveItemAndBackToProducts(final ItemDTO itemDTO, final String expectedBadgeCounter, final String expectedButtonText) {
        log.debug("Verifying item adding or removing from item page for: '{}'.", itemDTO.getName());
        clickOnAddOrRemoveButton();
        verifyCartBadge(getCartBadgeCounter(), expectedBadgeCounter);
        verifyTextContains(getAddOrRemoveButton(), expectedButtonText);
        verifyItemDescription(getItem(), itemDTO, INVENTORY_DETAILS_XPATHS);
        clickOnBackToProductsButton();
    }

    public void removeItemAndClickOnBackToProducts(final ItemDTO addedItem) {
        log.debug("Removing item from item page.");
        verifyAddOrRemoveItemAndBackToProducts(addedItem, null, "Add to cart");
    }

    public void addItemAndClickOnBackToProducts(final ItemDTO clickedItem, final Integer expectedBadgeCounter) {
        log.debug("Adding item from item page.");
        verifyAddOrRemoveItemAndBackToProducts(clickedItem, String.valueOf(expectedBadgeCounter + 1), "Remove");
    }
}

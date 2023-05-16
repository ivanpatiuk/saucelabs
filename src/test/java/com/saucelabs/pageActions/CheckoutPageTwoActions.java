package com.saucelabs.pageActions;

import com.saucelabs.models.ItemDTO;
import com.saucelabs.pages.CheckoutPageTwo;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

import static com.saucelabs.entities.TestVariables.ONE_SECOND;

@Log4j2
public class CheckoutPageTwoActions extends CheckoutPageTwo implements IBaseItemVerify {

    public CheckoutPageTwoActions(WebDriver driver) {
        super(driver);
    }

    private Double accumulatePrice(final List<ItemDTO> itemDTOS) {
        return itemDTOS
                .stream()
                .map(itemDTO -> Double.parseDouble(itemDTO.getPrice().substring(1)))
                .reduce(Double::sum)
                .orElse(null);
    }

    private void verifyPrices(final List<ItemDTO> itemDTOS) {
        final Double expectedDoubleItemTotalPrice = accumulatePrice(itemDTOS);
        final String actualItemTotalPrice = getItemTotalPrice().getText();
        final double actualDoubleItemTotalPrice = Double.parseDouble(actualItemTotalPrice.substring(actualItemTotalPrice.lastIndexOf("Item total: $") + 13));
        Assert.assertEquals(actualDoubleItemTotalPrice, expectedDoubleItemTotalPrice);

        final String actualSummaryTaxPrice = getSummaryTaxPrice().getText();
        final double actualDoubleSummaryTaxPrice = Double.parseDouble(getSummaryTaxPrice().getText().substring(actualSummaryTaxPrice.indexOf("Tax: $") + 6));

        Assert.assertTrue(0.08 <= actualDoubleSummaryTaxPrice / actualDoubleItemTotalPrice && actualDoubleSummaryTaxPrice / actualDoubleItemTotalPrice <= 0.0805);

        final String actualTotalPrice = getTotalPrice().getText();
        final double actualDoubleTotalPrice = Double.parseDouble(actualTotalPrice.substring(actualTotalPrice.indexOf("Total: $") + 8));
        Assert.assertEquals(actualDoubleTotalPrice, expectedDoubleItemTotalPrice + actualDoubleSummaryTaxPrice);
    }

    public void finishCheckout(final List<ItemDTO> expectedItemDTOList) {
        verifyCartPageWithItems(expectedItemDTOList);
        verifyPrices(expectedItemDTOList);
        clickOnFinishButton();
    }

    @Override
    public void verifyUIElements() {
        log.debug("Verifying checkout page UI elements.");
        waitUntilClickable(getFinishButton(), ONE_SECOND);
        waitUntilClickable(getCancelButton(), ONE_SECOND);
        waitUntilVisible(getCartBadgeCounter(), ONE_SECOND);
    }

    @Override
    public void verifyCartPageWithItems(List<ItemDTO> itemDTOS) {
        log.debug("Verifying checkout page item with items count: {}.", itemDTOS.size());
        Assert.assertEquals(getCartBadgeCounter().getText(), String.valueOf(itemDTOS.size()));
        verifyUIElements();
        itemDTOS.forEach(itemDTO -> {
            log.debug("Verifying checkout page item: {}.", itemDTO.getName());
            final WebElement item = getCartItemByName(itemDTO.getName());
            verifyItemQTY(item);
            verifyItemDescription(item);
        });
    }
}

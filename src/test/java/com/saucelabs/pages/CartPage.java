package com.saucelabs.pages;

import com.saucelabs.entities.TestVariables;
import com.saucelabs.pages.base.CartItemsBasePage;
import lombok.Getter;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Getter
@Log4j2
public class CartPage extends CartItemsBasePage {
    @FindBy(xpath = "//button[@id='checkout']")
    private WebElement checkoutButton;
    @FindBy(xpath = "//button[contains(@id, \"remove\")]")
    private WebElement removeButton;
    @FindBy(xpath = "//button[@id='continue-shopping']")
    private WebElement continueShippingButton;

    public CartPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void clickOnCheckoutButton() {
        log.debug("Clicking on 'Checkout' button.");
        waitUntilClickable(checkoutButton, TestVariables.ONE_SECOND);
        checkoutButton.click();
    }

    public void clickOnRemoveButton() {
        log.debug("Clicking on 'Remove' button.");
        waitUntilClickable(removeButton, TestVariables.ONE_SECOND);
        removeButton.click();
    }

    public void clickOnContinueShippingButton() {
        log.debug("Clicking on 'Continue shipping' button.");
        waitUntilClickable(continueShippingButton, TestVariables.ONE_SECOND);
        continueShippingButton.click();
    }
}

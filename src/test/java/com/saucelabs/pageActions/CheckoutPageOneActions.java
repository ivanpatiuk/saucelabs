package com.saucelabs.pageActions;

import com.saucelabs.pages.CheckoutPageOne;
import org.openqa.selenium.WebDriver;

import static com.saucelabs.entities.TestVariables.CHECKOUT_STEP_ONE_PAGE_URL;

public class CheckoutPageOneActions extends CheckoutPageOne {

    public CheckoutPageOneActions(WebDriver driver) {
        super(driver);
    }

    public void checkoutItems() {
        verifyLogoAndUrl(CHECKOUT_STEP_ONE_PAGE_URL);
        enterFirstName("Firstname");
        enterLastName("Lastname");
        enterPostalCode("81000");
        clickOnContinueButton();
    }
}

package com.saucelabs.steps;

import com.saucelabs.pages.CheckoutPage;
import org.openqa.selenium.WebDriver;

import static com.saucelabs.entities.TestVariables.CHECKOUT_STEP_ONE_PAGE_URL;

public class CheckoutStepOne extends CheckoutPage {

    public CheckoutStepOne(WebDriver driver) {
        super(driver);
    }

    public void checkoutItems() {
        verifyLogoAndUrl(CHECKOUT_STEP_ONE_PAGE_URL);
        enterFirstName("Firstname");
        enterLastName("Lastname");
        enterPostalCode("81000");
    }
}

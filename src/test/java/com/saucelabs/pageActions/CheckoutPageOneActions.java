package com.saucelabs.pageActions;

import com.saucelabs.pages.CheckoutPageOne;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;

import static com.saucelabs.entities.TestVariables.CHECKOUT_STEP_ONE_PAGE_URL;

@Log4j2
public class CheckoutPageOneActions extends CheckoutPageOne {

    public CheckoutPageOneActions(WebDriver driver) {
        super(driver);
    }

    public void checkoutItems() {
        log.debug("Checkout items.");
        verifyLogoAndUrl(CHECKOUT_STEP_ONE_PAGE_URL);
        enterFirstName("Firstname");
        enterLastName("Lastname");
        enterPostalCode("81000");
        clickOnContinueButton();
    }
}

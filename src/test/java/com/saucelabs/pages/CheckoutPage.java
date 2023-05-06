package com.saucelabs.pages;

import lombok.Getter;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.saucelabs.entities.TestVariables.ONE_SECOND;

@Getter
@Log4j2
public class CheckoutPage extends BaseDriver {
    @FindBy(xpath = "//*[@class='shopping_cart_container']//span[@class='shopping_cart_badge']")
    private WebElement cartBadgeCounter;
    @FindBy(xpath = "//input[@id='continue']")
    private WebElement continueInputButton;
    @FindBy(xpath = "//input[@id='cancel']")
    private WebElement cancelButton;
    @FindBy(xpath = "//input[@id='first-name']")
    private WebElement firstNameInput;
    @FindBy(xpath = "//input[@id='last-name']")
    private WebElement lastNameInput;
    @FindBy(xpath = "//input[@id='postal-code']")
    private WebElement postalCodeInput;

    public CheckoutPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void clickOnContinueButton() {
        log.debug("Clicking on 'Continue' button.");
        waitUntilClickable(continueInputButton, ONE_SECOND);
        continueInputButton.submit();
    }

    public void clickOnCancelButton() {
        log.debug("Clicking on 'Cancel' button.");
        waitUntilClickable(cancelButton, ONE_SECOND);
        cancelButton.click();
    }

    public void enterFirstName(final String firstName) {
        log.debug("Entering first name: '{}'.", firstName);
        waitUntilClickable(firstNameInput, ONE_SECOND);
        firstNameInput.sendKeys(firstName);
    }

    public void enterLastName(final String lastName) {
        log.debug("Entering last name: '{}'.", lastName);
        waitUntilClickable(lastNameInput, ONE_SECOND);
        lastNameInput.sendKeys(lastName);
    }

    public void enterPostalCode(final String postalCode) {
        log.debug("Entering postal code: '{}'.", postalCode);
        waitUntilClickable(postalCodeInput, ONE_SECOND);
        postalCodeInput.sendKeys(postalCode);
    }
}

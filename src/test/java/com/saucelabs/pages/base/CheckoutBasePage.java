package com.saucelabs.pages.base;

import lombok.Getter;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.saucelabs.entities.TestVariables.ONE_SECOND;

@Getter
@Log4j2
public abstract class CheckoutBasePage extends CartBasePage {
    @FindBy(xpath = "//input[@id='cancel']")
    private WebElement cancelButton;

    public CheckoutBasePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void clickOnCancelButton() {
        log.debug("Clicking on 'Cancel' button.");
        waitUntilClickable(cancelButton, ONE_SECOND);
        cancelButton.click();
    }
}

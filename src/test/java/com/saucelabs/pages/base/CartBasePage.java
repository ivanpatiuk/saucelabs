package com.saucelabs.pages.base;

import com.saucelabs.entities.TestVariables;
import lombok.Getter;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


@Getter
@Log4j2
public abstract class CartBasePage extends BaseDriver {

    @FindBy(xpath = "//div[@id='shopping_cart_container']/a")
    protected WebElement shoppingCartButton;
    @FindBy(xpath = "//*[@class='shopping_cart_container']//span[@class='shopping_cart_badge']")
    protected WebElement cartBadgeCounter;

    public CartBasePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void clickOnShoppingCartButton() {
        log.debug("Clicking on shopping cart button.");
        waitUntilClickable(shoppingCartButton, TestVariables.ONE_SECOND);
        shoppingCartButton.click();
    }

    public String getCartBadgeCounterText() {
        return cartBadgeCounter.getText();
    }
}

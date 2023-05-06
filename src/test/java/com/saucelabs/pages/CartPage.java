package com.saucelabs.pages;

import com.saucelabs.entities.TestVariables;
import lombok.Getter;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

@Getter
@Log4j2
public class CartPage extends BaseDriver {
    @FindBy(xpath = "//div[@id='shopping_cart_container']/a")
    private WebElement shoppingCartButton;
    @FindBy(xpath = "//*[@class='shopping_cart_container']//span[@class='shopping_cart_badge']")
    private WebElement cartBadgeCounter;
    @FindBy(xpath = "//button[@id='checkout']")
    private WebElement checkoutButton;
    @FindBy(xpath = "//button[contains(@id, \"remove\")]")
    private WebElement removeButton;
    @FindBy(xpath = "//button[@id='continue-shopping']")
    private WebElement continueShippingButton;
    @FindBy(xpath = "//div[@class='cart_item']")
    private List<WebElement> cartItems;

    public CartPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void clickOnShoppingCartButton() {
        waitUntilClickable(shoppingCartButton, TestVariables.ONE_SECOND);
        shoppingCartButton.click();
    }

    public void clickOnCheckoutButton() {
        waitUntilClickable(shoppingCartButton, TestVariables.ONE_SECOND);
        checkoutButton.click();
    }

    public void clickOnRemoveButton() {
        waitUntilClickable(removeButton, TestVariables.ONE_SECOND);
        removeButton.click();
    }

    public void clickOnContinueShippingButton() {
        waitUntilClickable(continueShippingButton, TestVariables.ONE_SECOND);
        continueShippingButton.click();
    }

    public WebElement getCartItemByName(final String name) {
        log.debug("Getting cart item by name: {}", name);
        return cartItems.stream().filter(cartItem -> cartItem
                        .findElement(By.xpath("//div[@class='inventory_item_name']"))
                        .getText()
                        .equals(name))
                .findFirst()
                .orElse(null);
    }
}

package com.saucelabs.pages.base;

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
public abstract class CartItemsBasePage extends CartBasePage {
    @FindBy(xpath = "//div[@class='cart_item']")
    protected List<WebElement> cartItems;

    public CartItemsBasePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public WebElement getCartItemByName(final String itemName) {
        log.debug("Getting cart item by name: '{}'.", itemName);
        return cartItems.stream().filter(cartItem -> cartItem
                        .findElement(By.xpath(".//div[@class='inventory_item_name']"))
                        .getText()
                        .equals(itemName))
                .findFirst()
                .orElse(null);
    }
}

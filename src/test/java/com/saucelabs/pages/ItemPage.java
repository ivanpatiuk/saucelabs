package com.saucelabs.pages;

import com.saucelabs.entities.TestVariables;
import com.saucelabs.pages.base.BaseDriver;
import lombok.Getter;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Getter
@Log4j2
public class ItemPage extends BaseDriver {
    @FindBy(xpath = "//div[@class='inventory_details_container']")
    private WebElement item;
    @FindBy(xpath = "//div[@class='inventory_details_desc_container']//button[contains(@id, 'add-to-cart')]")
    private WebElement addToCartButton;
    @FindBy(xpath = "//div[@class='left_component']/button[contains(@id, 'back-to-products')]")
    private WebElement backToProductsButton;

    public ItemPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void clickOnAddToCartButton(){
        log.debug("Clicking on 'Add to cart' button");
        waitUntilClickable(addToCartButton, TestVariables.ONE_SECOND);
        addToCartButton.click();
    }

    public void clickOnBackToProductsButton(){
        log.debug("Clicking on 'Back to products' button.");
        waitUntilClickable(backToProductsButton, TestVariables.ONE_SECOND);
        backToProductsButton.click();
    }
}

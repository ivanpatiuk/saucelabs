package com.saucelabs.pages;

import com.saucelabs.entities.TestVariables;
import com.saucelabs.pages.base.CartBasePage;
import lombok.Getter;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Getter
@Log4j2
public class ItemPage extends CartBasePage {
    @FindBy(xpath = "//div[@class='inventory_details_container']")
    private WebElement item;
    @FindBy(xpath = "//button[contains(@class, 'btn_inventory')]")
    private WebElement addOrRemoveButton;
    @FindBy(xpath = "//div[@class='left_component']/button[contains(@id, 'back-to-products')]")
    private WebElement backToProductsButton;

    public ItemPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void clickOnAddOrRemoveButton() {
        log.debug("Clicking on 'Add to cart' or 'Remove' button");
        waitUntilClickable(addOrRemoveButton, TestVariables.ONE_SECOND);
        addOrRemoveButton.click();
    }

    public void clickOnBackToProductsButton() {
        log.debug("Clicking on 'Back to products' button.");
        waitUntilClickable(backToProductsButton, TestVariables.ONE_SECOND);
        backToProductsButton.click();
    }
}

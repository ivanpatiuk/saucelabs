package com.saucelabs.pages;

import com.saucelabs.pages.base.CartBasePage;
import lombok.Getter;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static com.saucelabs.entities.TestVariables.ONE_SECOND;

@Getter
@Log4j2
public class ShopPage extends CartBasePage {

    public static final String BY_ITEM = "//div[@class='inventory_item_name' and text()='<item_title>']/ancestor::div[@class='inventory_item']//button[contains(@class, 'btn_inventory')]";

    @FindBy(xpath = "//button[@id='react-burger-menu-btn']")
    private WebElement sidebar;
    @FindBy(xpath = "//a[@id='logout_sidebar_link']")
    private WebElement logout;
    @FindBy(xpath = "//div[@class='inventory_item']")
    private List<WebElement> inventoryItems;

    private final By selectOrderingButton = By.xpath("//*[@id='header_container']//select");

    public ShopPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    private void clickOnAddOrRemove(final String itemName) {
        log.debug("Click on 'Add to cart' or 'Remove from cart' button for: '{}'.", itemName);
        final WebElement button = findElementBy(By.xpath(BY_ITEM.replace("<item_title>", itemName)), ONE_SECOND);
        waitUntilClickable(button, ONE_SECOND);
        button.click();
    }

    public void selectOrdering(final String itemName) {
        log.debug("Selecting ordering: '{}'.", itemName);
        final Select select = new Select(findElementBy(selectOrderingButton, ONE_SECOND));
        select.selectByVisibleText(itemName);
    }


    public void addItemToCartByName(final String itemName) {
        log.debug("Adding to cart: '{}'.", itemName);
        clickOnAddOrRemove(itemName);
    }

    public void removeItem(final String itemName) {
        log.debug("Removing from cart: '{}'.", itemName);
        clickOnAddOrRemove(itemName);
    }

    public void verifyClickingOnShoppingCart() {
        log.debug("Clicking on cart.");
        waitUntilClickable(shoppingCartButton, ONE_SECOND);
        shoppingCartButton.click();
        verifyUrl("https://www.saucedemo.com/cart.html");
    }

    public void clickOnSideBar() {
        log.debug("Clicking on side bar.");
        waitUntilClickable(sidebar, ONE_SECOND);
        sidebar.click();
    }

    public void clickOnLogout(){
        log.debug("Clicking on logout.");
        waitUntilClickable(logout, ONE_SECOND);
        logout.click();
    }
}
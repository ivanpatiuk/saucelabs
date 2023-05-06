package pages;

import lombok.Getter;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import utils.BaseDriver;

import java.util.List;

import static entities.TestVariables.ONE_SECOND;

@Getter
@Log4j2
public class ShopPage extends BaseDriver {

    @FindBy(xpath = "//div[@id='shopping_cart_container']/a")
    private WebElement shoppingCartButton;
    public static final String BY_ITEM = "//div[@class='inventory_item_name' and text()='<item_title>']/ancestor::div[@class='inventory_item']//button[contains(@class, 'btn_inventory')]";
    @FindBy(xpath = "//button[@id='react-burger-menu-btn']")
    private WebElement sidebar;
    @FindBy(xpath = "//a[@id='logout_sidebar_link']")
    private WebElement logout;
    @FindBy(xpath = "//div[@class='inventory_list']//div[@class='inventory_item']")
    private List<WebElement> items;
    @FindBy(xpath = "//*[@class='shopping_cart_container']//span[@class='shopping_cart_badge']")
    private WebElement cartBadgeCounter;

    private final By inventoryItemsDescription = By.xpath("//div[@class='inventory_list']//div[@class='inventory_item_desc']");
    private final By selectOrderingButton = By.xpath("//*[@id=\"header_container\"]//select");

    private void clickOnAddOrRemove(final String string) {
        WebElement button = findElementBy(By.xpath(BY_ITEM.replace("<item_title>", string)), ONE_SECOND);
        waitUntilClickable(button, ONE_SECOND);
        button.click();
    }

    public ShopPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void selectOrdering(final String string) {
        log.debug("Selecting ordering: {}", string);
        Select select = new Select(findElementBy(selectOrderingButton, ONE_SECOND));
        select.selectByVisibleText(string);
    }


    public void addToCart(final String string) {
        log.debug("Adding to cart: {}", string);
        clickOnAddOrRemove(string);
    }

    public void removeItem(final String string) {
        log.debug("Removing from cart: {}", string);
        clickOnAddOrRemove(string);
    }

    public void clickOnCart() {
        log.debug("Clicking on cart");
        waitUntilClickable(shoppingCartButton, ONE_SECOND);
        shoppingCartButton.click();
        verifyUrl("https://www.saucedemo.com/cart.html");
    }

    public void clickOnSideBar() {
        log.debug("Clicking on side bar");
        waitUntilClickable(sidebar, ONE_SECOND);
        sidebar.click();
    }

    public void clickOnLogout(){
        log.debug("Clicking on logout");
        waitUntilClickable(logout, ONE_SECOND);
        logout.click();
    }
}
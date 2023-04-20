package pages;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import utils.BaseDriver;

import static entities.TestVariables.ONE_SECOND;

@Getter
public class ShopPage extends BaseDriver {

    @FindBy(xpath = "//div[@id='shopping_cart_container']/a")
    private WebElement shoppingCartButton;
    @FindBy(xpath = "//button[@id='react-burger-menu-btn']")
    private WebElement sidebar;
    @FindBy(xpath = "//a[@id='logout_sidebar_link']")
    private WebElement logout;

    private final By inventoryItemsDescription = By.xpath("//div[@class='inventory_list']//div[@class='inventory_item_desc']");
    private final By selectOrderingButton = By.xpath("//*[@id=\"header_container\"]//select");

    public ShopPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void selectOrdering(final String string) {
        Select select = new Select(findElementBy(selectOrderingButton, ONE_SECOND));
        select.selectByVisibleText(string);
    }

    public void addToCart(final String string) {
        WebElement addToCartButton = findElementBy(By.xpath("//div[@class='inventory_item_name' and text()='" + string + "']/ancestor::div[@class='inventory_item']//button[contains(@class, 'btn_inventory')]"), ONE_SECOND);
        waitUntilClickable(addToCartButton, ONE_SECOND);
        addToCartButton.click();
    }

    public void clickOnCart(){
        waitUntilClickable(shoppingCartButton, ONE_SECOND);
        shoppingCartButton.click();
    }

    public void clickOnSideBar(){
        waitUntilClickable(sidebar, ONE_SECOND);
        sidebar.click();
    }

    public void clickOnLogout(){
        waitUntilClickable(logout, ONE_SECOND);
        logout.click();
    }
}
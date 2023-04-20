package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.BaseDriver;

public class CartPage extends BaseDriver {
    @FindBy(xpath = "//*[@id=\"shopping_cart_container\"]/a")
    private WebElement shoppingCartButton;
    private WebElement checkoutButton;
    private WebElement removeButton;
    private WebElement continueShippingButton;
}

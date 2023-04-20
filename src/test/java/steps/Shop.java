package steps;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import pages.ShopPage;

@Getter
public class Shop extends ShopPage {

    public Shop(WebDriver driver) {
        super(driver);
    }

    public void orderItem(final String string) {
        addToCart(string);
        clickOnCart();
    }
}

package pages;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import utils.BaseDriver;

@Getter
public class ShopPage extends BaseDriver {
    public ShopPage(WebDriver driver) {
        super(driver);
    }
}
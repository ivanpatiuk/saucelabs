package pages;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

@Getter
public class ShopPage extends Page{
    public ShopPage(WebDriver driver) {
        super(driver);
    }
}
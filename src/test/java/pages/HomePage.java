package pages;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class HomePage extends Page{

    @FindBy(id = "user-name")
    private WebElement username;
    @FindBy(id = "password")
    private WebElement password;
    @FindBy(id = "login-button")
    private WebElement loginButton;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public HomePage enterUsername(final String username) {
        this.username.sendKeys(username);
        return this;
    }

    public HomePage enterPassword(final String password) {
        this.password.sendKeys(password);
        return this;
    }

    public ShopPage clickOnLoginButton() {
        loginButton.click();
        return new ShopPage(driver);
    }
}

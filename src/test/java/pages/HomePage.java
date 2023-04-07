package pages;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BaseDriver;

import static entities.TestVariables.ONE_SECOND;

@Getter
public class HomePage extends BaseDriver {

    @FindBy(xpath = "//*[@id=\"user-name\"]")
    private WebElement username;
    @FindBy(xpath = "//*[@id=\"password\"]")
    private WebElement password;
    @FindBy(xpath = "//*[@id=\"login-button\"]")
    private WebElement loginButton;

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void enterUsername(final String string) {
        waitUntilClickable(username, ONE_SECOND);
        username.sendKeys(string);
    }

    public void enterPassword(final String string) {
        waitUntilClickable(username, ONE_SECOND);
        password.sendKeys(string);
    }

    public void clickOnLoginButton() {
        waitUntilClickable(username, ONE_SECOND);
        loginButton.click();
    }
}

package pages;

import lombok.Getter;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static entities.TestVariables.ONE_SECOND;

@Getter
@Log4j2
public class HomePage extends BaseDriver {

    @FindBy(xpath = "//*[@id=\"user-name\"]")
    private WebElement username;
    @FindBy(xpath = "//*[@id=\"password\"]")
    private WebElement password;
    @FindBy(xpath = "//*[@id=\"login-button\"]")
    private WebElement loginButton;

    private final By errorMessage = By.xpath("//div[contains(@class, 'error')]//h3[@data-test='error']");

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void enterUsername(final String string) {
        log.debug("Entering username: {}", string);
        waitUntilClickable(username, ONE_SECOND);
        username.sendKeys(string);
    }

    public void enterPassword(final String string) {
        log.debug("Entering password");
        waitUntilClickable(username, ONE_SECOND);
        password.sendKeys(string);
    }

    public void clickOnLoginButton() {
        waitUntilClickable(username, ONE_SECOND);
        loginButton.click();
    }
}

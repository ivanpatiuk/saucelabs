package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage {

    WebDriver driver;

    @FindBy(xpath = "//*[@class='ng-tns-c94-1']")
    WebElement dropDownMenuButton;
    @FindBy(xpath = "//div[@class='cdk-overlay-pane']//div[contains(@class, 'side-menu__auth-content')]//button[text()=' Вхід ']")
    WebElement loginDropDownMenuButton;
    @FindBy(xpath = "//*[@id='auth_email']")
    WebElement authEmailTextBox;
    @FindBy(xpath = "//*[@id='auth_pass']")
    WebElement authPassTextBox;
    @FindBy(xpath = "//button[contains(@class,'auth-modal__submit')]")
    WebElement loginButton;


    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOnDropDownMenu(){
        dropDownMenuButton.click();
    }

    public void clickOnLoginDropDownMenuButton(){
        loginDropDownMenuButton.click();
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
//        loginDropDownMenuButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("/html/body/div[4]/div[2]/div/nav/div/div[2]/div/div/div[2]/div/button[1]")));
    }

    public void enterEmail(final String email){
        authEmailTextBox.sendKeys(email);
    }

    public void enterPassword(final String password){
        authPassTextBox.sendKeys(password);
    }

    public void clickOnLoginButton(){
        loginButton.click();
    }
}

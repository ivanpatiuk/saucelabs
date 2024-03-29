package com.saucelabs.pages;

import com.saucelabs.entities.TestVariables;
import com.saucelabs.pages.base.BaseDriver;
import lombok.Getter;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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

    public void enterUsername(final String username) {
        log.debug("Entering username: '{}'.", username);
        waitUntilClickable(this.username, TestVariables.ONE_SECOND);
        this.username.sendKeys(username);
    }

    public void enterPassword(final String password) {
        log.debug("Entering password.");
        waitUntilClickable(this.password, TestVariables.ONE_SECOND);
        this.password.sendKeys(password);
    }

    public void clickOnLoginButton() {
        log.debug("Clicking on 'Login' button.");
        waitUntilClickable(username, TestVariables.ONE_SECOND);
        loginButton.click();
    }
}

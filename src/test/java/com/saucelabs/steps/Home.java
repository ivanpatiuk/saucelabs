package com.saucelabs.steps;

import com.saucelabs.entities.TestVariables;
import com.saucelabs.pages.HomePage;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


@Log4j2
public class Home extends HomePage {

    public Home(WebDriver driver) {
        super(driver);
    }

    public void login(final String username, final String password) {
        try {
            log.debug("Logging in for user: '{}'", username);
            enterUsername(username);
            enterPassword(password);
            clickOnLoginButton();
        } catch (Exception e) {
            log.fatal("Logging in for user: '{}' failed.", username);
            throw e;
        }
    }

    @Step
    public void unsuccessfulLogin(final String username, final String password) {
        log.debug("Called unsuccessful login");
        login(username, password);
        verifyUrl(TestVariables.HOME_PAGE_URL);
        verifyTextContains(getErrorMessage(), "Epic sadface");
    }

    @Step
    public void successfulLogin(final String username, final String password) {
        log.debug("Called successful login");
        login(username, password);
        waitUntilInvisible(By.xpath("//div[@class='login_container']"), TestVariables.ONE_SECOND);
        verifyLogoAndUrl(TestVariables.SHOP_PAGE_URL);
        verifyTextContains(By.xpath("//footer//div[@class='footer_copy']"), "© 2023 Sauce Labs. All Rights Reserved. Terms of Service | Privacy Policy");
        verifyTextContains(By.xpath("//span[@class='title']"), "Products");
    }
}

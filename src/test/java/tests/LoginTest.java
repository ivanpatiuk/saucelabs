package tests;

import org.testng.annotations.Test;
import utils.Verify;

import static entities.TestVariables.*;
import static steps.Home.login;
import static utils.Verify.*;

public class LoginTest extends BaseTest {

    @Test(groups = "login")
    void loginStandardUserShouldSuccessTest() {
        login(driver, STANDARD_USERNAME, VALID_PASSWORD);
        verifyUrl(driver, SHOP_PAGE_URL);
    }

    @Test(groups = "login")
    void loginStandardUserShouldFailTest() {
        login(driver, STANDARD_USERNAME, NOT_VALID_PASSWORD);
        verifyUrl(driver, HOME_PAGE_URL);
        verifyTextContains(driver,
                "//*[@id=\"login_button_container\"]//*[@data-test=\"error\"]",
                "Epic sadface: Username and password do not match any user in this service");
    }

    @Test(groups = "login")
    void loginLockedOutUserShouldReturnErrorTest() {
        login(driver, LOCKED_OUT_USERNAME, VALID_PASSWORD);
        verifyUrl(driver, HOME_PAGE_URL);
        verifyTextContains(driver,
                "//*[@id=\"login_button_container\"]//div[@class=\"error-message-container error\"]//h3",
                "Epic sadface: Sorry, this user has been locked out.");
    }

    @Test(groups = "login")
    void loginProblemUserShouldSuccessTest() {
        login(driver, PROBLEM_USERNAME, VALID_PASSWORD);
        verifyUrl(driver, SHOP_PAGE_URL);
    }

    @Test(groups = {"login", "performance"})
    void loginPerformanceGlitchUserShouldFailTest() {
        verifyTime(() -> login(driver, PERFORMANCE_GLITCH_USERNAME, VALID_PASSWORD), ONE_SECOND);
        verifyUrl(driver, SHOP_PAGE_URL);
    }
}

package com.saucelabs.tests.loginTests;

import com.saucelabs.entities.TestVariables;
import com.saucelabs.steps.Home;
import com.saucelabs.steps.Shop;
import com.saucelabs.tests.BaseTest;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test(groups = "login")
    void loginStandardUserTestShouldSuccess() {
        Home home = new Home(driver);
        home.successfulLogin(TestVariables.STANDARD_USERNAME, TestVariables.VALID_PASSWORD);
    }

    @Test(groups = "login")
    void logoutStandardUserTestShouldSuccess() {
        Home home = new Home(driver);
        home.successfulLogin(TestVariables.STANDARD_USERNAME, TestVariables.VALID_PASSWORD);

        Shop shop = new Shop(driver);
        shop.logout();
    }

    @Test(groups = "login")
    void loginStandardUserTestShouldFail() {
        Home home = new Home(driver);
        home.unsuccessfulLogin(TestVariables.STANDARD_USERNAME, TestVariables.NOT_VALID_PASSWORD);
    }

    @Test(groups = "login")
    void loginLockedOutUserTestShouldReturnError() {
        Home home = new Home(driver);
        home.unsuccessfulLogin(TestVariables.LOCKED_OUT_USERNAME, TestVariables.VALID_PASSWORD);
    }

    @Test(groups = "login")
    void loginProblemUserTestShouldSuccess() {
        Home home = new Home(driver);
        home.successfulLogin(TestVariables.PROBLEM_USERNAME, TestVariables.VALID_PASSWORD);
    }
//    @Test(groups = {"login", "performance"})
//    void loginPerformanceGlitchUserShouldFailTest() {
//        login(driver, PERFORMANCE_GLITCH_USERNAME, VALID_PASSWORD);
//        verifyUrl(driver, SHOP_PAGE_URL);
//    }
}

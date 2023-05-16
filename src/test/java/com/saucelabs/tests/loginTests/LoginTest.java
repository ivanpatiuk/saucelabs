package com.saucelabs.tests.loginTests;

import com.saucelabs.entities.TestVariables;
import com.saucelabs.pageActions.HomePageActions;
import com.saucelabs.pageActions.ShopPageActions;
import com.saucelabs.tests.BaseTest;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test(groups = "login")
    void loginStandardUserTestShouldSuccess() {
        final HomePageActions homePageActions = new HomePageActions(driver);
        homePageActions.successfulLogin(TestVariables.STANDARD_USERNAME, TestVariables.VALID_PASSWORD);
    }

    @Test(groups = "login")
    void logoutStandardUserTestShouldSuccess() {
        final HomePageActions homePageActions = new HomePageActions(driver);
        homePageActions.successfulLogin(TestVariables.STANDARD_USERNAME, TestVariables.VALID_PASSWORD);

        final ShopPageActions shopPageActions = new ShopPageActions(driver);
        shopPageActions.logout();
    }

    @Test(groups = "login")
    void loginStandardUserTestShouldFail() {
        final HomePageActions homePageActions = new HomePageActions(driver);
        homePageActions.unsuccessfulLogin(TestVariables.STANDARD_USERNAME, TestVariables.NOT_VALID_PASSWORD);
    }

    @Test(groups = "login")
    void loginLockedOutUserTestShouldReturnError() {
        final HomePageActions homePageActions = new HomePageActions(driver);
        homePageActions.unsuccessfulLogin(TestVariables.LOCKED_OUT_USERNAME, TestVariables.VALID_PASSWORD);
    }

    @Test(groups = "login")
    void loginProblemUserTestShouldSuccess() {
        HomePageActions homePageActions = new HomePageActions(driver);
        homePageActions.successfulLogin(TestVariables.PROBLEM_USERNAME, TestVariables.VALID_PASSWORD);
    }
//    @Test(groups = {"login", "performance"})
//    void loginPerformanceGlitchUserShouldFailTest() {
//        login(driver, PERFORMANCE_GLITCH_USERNAME, VALID_PASSWORD);
//        verifyUrl(driver, SHOP_PAGE_URL);
//    }
}

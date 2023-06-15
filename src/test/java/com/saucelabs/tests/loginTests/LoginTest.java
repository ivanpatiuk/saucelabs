package com.saucelabs.tests.loginTests;

import com.saucelabs.entities.TestVariables;
import com.saucelabs.pageActions.HomePageActions;
import com.saucelabs.pageActions.ShopPageActions;
import com.saucelabs.tests.baseTests.BaseTest;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test(groups = "login")
    void successfulLoginStandardUserTest() {
        final HomePageActions homePageActions = new HomePageActions(driver);
        homePageActions.successfulLogin(TestVariables.STANDARD_USERNAME, TestVariables.VALID_PASSWORD);
    }

    @Test(groups = "login")
    void logoutStandardUserTest() {
        final HomePageActions homePageActions = new HomePageActions(driver);
        homePageActions.successfulLogin(TestVariables.STANDARD_USERNAME, TestVariables.VALID_PASSWORD);

        final ShopPageActions shopPageActions = new ShopPageActions(driver);
        shopPageActions.logout();
    }

    @Test(groups = "login")
    void unsuccessfulLoginStandardUserTest() {
        final HomePageActions homePageActions = new HomePageActions(driver);
        homePageActions.unsuccessfulLogin(TestVariables.STANDARD_USERNAME, TestVariables.NOT_VALID_PASSWORD);
    }

    @Test(groups = "login")
    void loginLockedOutUserTestShouldReturnError() {
        final HomePageActions homePageActions = new HomePageActions(driver);
        homePageActions.unsuccessfulLogin(TestVariables.LOCKED_OUT_USERNAME, TestVariables.VALID_PASSWORD);
    }

    @Test(groups = "login")
    void successfulLoginProblemUserTest() {
        HomePageActions homePageActions = new HomePageActions(driver);
        homePageActions.successfulLogin(TestVariables.PROBLEM_USERNAME, TestVariables.VALID_PASSWORD);
    }
}

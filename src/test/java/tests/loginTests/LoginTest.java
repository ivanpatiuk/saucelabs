package tests.loginTests;

import org.testng.annotations.Test;
import steps.Home;
import steps.Shop;
import tests.BaseTest;

import static entities.TestVariables.*;

public class LoginTest extends BaseTest {

    @Test(groups = "login")
    void loginStandardUserTestShouldSuccess() {
        Home home = new Home(driver);
        home.successfulLogin(STANDARD_USERNAME, VALID_PASSWORD);
    }

    @Test(groups = "login")
    void logoutStandardUserTestShouldSuccess() {
        Home home = new Home(driver);
        home.successfulLogin(STANDARD_USERNAME, VALID_PASSWORD);

        Shop shop = new Shop(driver);
        shop.logout();
    }

    @Test(groups = "login")
    void loginStandardUserTestShouldFail() {
        Home home = new Home(driver);
        home.unsuccessfulLogin(STANDARD_USERNAME, NOT_VALID_PASSWORD);
    }

    @Test(groups = "login")
    void loginLockedOutUserTestShouldReturnError() {
        Home home = new Home(driver);
        home.unsuccessfulLogin(LOCKED_OUT_USERNAME, VALID_PASSWORD);
    }

    @Test(groups = "login")
    void loginProblemUserTestShouldSuccess() {
        Home home = new Home(driver);
        home.successfulLogin(PROBLEM_USERNAME, VALID_PASSWORD);
    }
//    @Test(groups = {"login", "performance"})
//    void loginPerformanceGlitchUserShouldFailTest() {
//        login(driver, PERFORMANCE_GLITCH_USERNAME, VALID_PASSWORD);
//        verifyUrl(driver, SHOP_PAGE_URL);
//    }
}

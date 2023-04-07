package tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static entities.TestVariables.*;
import static steps.Home.login;

public class LoginTest extends BaseTest {

    @Test(groups = "login")
    void loginStandardUserShouldSuccessTest() {
        login(driver, STANDARD_USERNAME, VALID_PASSWORD);
        verifyUrl(SHOP_PAGE_URL);
        waitUntilInvisible(By.xpath("//div[@class=\"login_container\"]"), ONE_SECOND);
    }

    @Test(groups = "login")
    void loginStandardUserShouldFailTest() {
        login(driver, STANDARD_USERNAME, NOT_VALID_PASSWORD);
        verifyUrl(HOME_PAGE_URL);
        verifyTextContains(
                By.xpath("//*[@id=\"login_button_container\"]//*[@data-test=\"error\"]"),
                "Epic sadface: Username and password do not match any user in this service");
    }

    @Test(groups = "login")
    void loginLockedOutUserShouldReturnErrorTest() {
        login(driver, LOCKED_OUT_USERNAME, VALID_PASSWORD);
        verifyUrl(HOME_PAGE_URL);
        verifyTextContains(
                By.xpath("//*[@id=\"login_button_container\"]//div[@class=\"error-message-container error\"]//h3"),
                "Epic sadface: Sorry, this user has been locked out.");
    }

    @Test(groups = "login")
    void loginProblemUserShouldSuccessTest() {
        login(driver, PROBLEM_USERNAME, VALID_PASSWORD);
        verifyUrl(SHOP_PAGE_URL);
        waitUntilInvisible(By.xpath("//div[@class=\"login_container\"]"), 1000);
    }

//    @Test(groups = {"login", "performance"})
//    void loginPerformanceGlitchUserShouldFailTest() {
//        login(driver, PERFORMANCE_GLITCH_USERNAME, VALID_PASSWORD);
//        verifyUrl(driver, SHOP_PAGE_URL);
//    }

}

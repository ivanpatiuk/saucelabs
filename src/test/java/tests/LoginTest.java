package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.HomePage;
import pages.ShopPage;
import ymlconfig.TestConfiguration;

public class LoginTest extends BaseTest {

    @Test
    void loginStandardUserShouldSuccessTest()  {
        HomePage homePage = new HomePage(driver);
        homePage.enterUsername(TestConfiguration.getProperties().getUsersCredentials().getStandardUserName());
        homePage.enterPassword(TestConfiguration.getProperties().getUsersCredentials().getPassword());

        long startTime = System.currentTimeMillis();
        ShopPage shopPage = homePage.clickOnLoginButton();
        long endTime = System.currentTimeMillis();

        String url = shopPage.getDriver().getCurrentUrl();
        Assert.assertTrue(endTime-startTime < 500);
        Assert.assertEquals(url, "https://www.saucedemo.com/inventory.html");
    }

    @Test
    void loginLockedOutUserShouldFailTest()  {
        HomePage homePage = new HomePage(driver);
        homePage.enterUsername(TestConfiguration.getProperties().getUsersCredentials().getLockedOutUserName());
        homePage.enterPassword(TestConfiguration.getProperties().getUsersCredentials().getPassword());

        long startTime = System.currentTimeMillis();
        ShopPage shopPage = homePage.clickOnLoginButton();
        long endTime = System.currentTimeMillis();

        String errorMessage = shopPage.getDriver().findElement(By.xpath("//*[@id=\"login_button_container\"]//div[@class=\"error-message-container error\"]//h3")).getText();
        Assert.assertTrue(endTime-startTime < 100);
        Assert.assertEquals(errorMessage, "Epic sadface: Sorry, this user has been locked out.");
    }
}

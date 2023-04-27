package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.HomePage;

import static entities.TestVariables.*;


public class Home extends HomePage {

    public Home(WebDriver driver) {
        super(driver);
    }

    public void login(final String username, final String password) {
        try {
            enterUsername(username);
            enterPassword(password);
            clickOnLoginButton();
        } catch (Exception e) {
            System.out.printf("login as %s failed", username);
            throw e;
        }
    }

    @Step
    public void unsuccessfulLogin(final String username, final String password){
        login(username, password);
        verifyUrl(HOME_PAGE_URL);
        verifyTextContains(getErrorMessage(), "Epic sadface");
    }

    @Step
    public void successfulLogin(final String username, final String password) {
            login(username, password);
            waitUntilInvisible(By.xpath("//div[@class=\"login_container\"]"), ONE_SECOND);
            verifyUrl(SHOP_PAGE_URL);
            verifyTextContains(By.xpath("//div[@id=\"header_container\"]//div[@class=\"app_logo\"]"), "Swag Labs");
            verifyTextContains(By.xpath("//footer//div[@class=\"footer_copy\"]"), "© 2023 Sauce Labs. All Rights Reserved. Terms of Service | Privacy Policy");
            verifyTextContains(By.xpath("//div[@class=\"header_secondary_container\"]//span[@class=\"title\"]"), "Products");
    }
}

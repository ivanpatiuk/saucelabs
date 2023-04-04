package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.HomePage;


public class Home {
    private final HomePage homePage;

    public Home(WebDriver webDriver) {
        homePage = new HomePage(webDriver);
    }

    public static void login(final WebDriver driver, final String username, final String password) {
        Home home = new Home(driver);
        home.login(username, password);
    }

    @Step
    private void login(final String username, final String password) {
        try {
            homePage.enterUsername(username);
            homePage.enterPassword(password);
            homePage.clickOnLoginButton();
        } catch (Exception e) {
            System.out.printf("login as %s failed", username);
            throw e;
        }
    }
}

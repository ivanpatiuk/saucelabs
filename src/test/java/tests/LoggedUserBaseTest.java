package tests;

import entities.TestVariables;
import org.testng.annotations.BeforeMethod;
import steps.Home;

import static testconfig.WebManager.getChromeDriver;

public abstract class LoggedUserBaseTest extends BaseTest {
    @Override
    @BeforeMethod
    public void before() {
        driver = getChromeDriver();
        Home home = new Home(driver);
        home.login(TestVariables.TESTED_USER_NAME, TestVariables.VALID_PASSWORD);
    }
}

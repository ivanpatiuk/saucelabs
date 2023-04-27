package tests;

import entities.TestVariables;
import lombok.extern.log4j.Log4j2;
import org.testng.annotations.BeforeMethod;
import steps.Home;

import static testconfig.WebManager.getChromeDriver;

@Log4j2
public abstract class LoggedUserBaseTest extends BaseTest {
    @Override
    @BeforeMethod
    public void before() {
        try {
            driver = getChromeDriver();
            Home home = new Home(driver);
            home.successfulLogin(TestVariables.TESTED_USER_NAME, TestVariables.VALID_PASSWORD);
        } catch (Exception e){
            driver.quit();
            throw e;
        }
    }
}

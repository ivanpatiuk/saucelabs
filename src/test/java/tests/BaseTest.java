package tests;

import lombok.extern.log4j.Log4j2;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import testconfig.WebManager;
import utils.BaseDriver;

import static testconfig.WebManager.getChromeDriver;

@Log4j2
public abstract class BaseTest extends BaseDriver {

    @BeforeSuite
    public void setup() {
        WebManager.setupChromeDriver();
    }

    @BeforeMethod
    public void before() {
        driver = getChromeDriver();
    }

    @AfterMethod
    public void close() {
        log.debug("Closing driver");
        driver.quit();
    }
}

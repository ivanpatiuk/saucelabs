package tests;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import testconfig.WebManager;
import utils.BaseDriver;

import static testconfig.WebManager.getChromeDriver;

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
        driver.quit();
    }
}

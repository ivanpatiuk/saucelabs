package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import testconfig.WebManager;

import static testconfig.WebManager.getChromeDriver;

public abstract class BaseTest {

    protected WebDriver driver;

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

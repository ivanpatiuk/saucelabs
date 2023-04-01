package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import testconfig.WebManager;

import static testconfig.WebManager.getChromeDriver;

public abstract class Base {

    protected WebDriver driver;

    @BeforeSuite
    public void setup()  {
        WebManager.setupChromeDriver();
    }

    @BeforeMethod
    public void before(){
        driver = getChromeDriver();
    }

    @AfterMethod
    public void close()  {
        driver.quit();
    }
}

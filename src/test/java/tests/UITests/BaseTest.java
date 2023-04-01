package tests.UITests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;

public class BaseTest {

    protected WebDriver driver;

    @AfterClass
    public void close(){
        driver.quit();
    }
}

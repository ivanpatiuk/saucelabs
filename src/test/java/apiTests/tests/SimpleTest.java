package apiTests.tests;

import config.WebManager;
import io.restassured.path.json.JsonPath;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class SimpleTest {
    private WebDriver driver;

    @BeforeClass
    public void setup(){
        driver = WebManager.setupChromeDriver("https://www.demoblaze.com/");;
    }

    @AfterClass
    public void close(){
        driver.quit();
    }

    @Test
    public void test1()  {
        WebElement webElement = driver.findElement(By.xpath("//*[@id=\"cat\"]"));
        Assert.assertEquals(webElement.getText(), "CATEGORIES");
    }

}

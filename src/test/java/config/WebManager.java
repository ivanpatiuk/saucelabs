package config;

import enums.DriverEnum;
import enums.WebDriverEnum;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebManager {
    public static WebDriver setupChromeDriver(final String site){
        System.setProperty(WebDriverEnum.WebDriverChrome.getDriver(), DriverEnum.ChromeDriver.getDriver());
        WebDriver webDriver = new ChromeDriver();
        webDriver.get(site);
        return webDriver;
    }
}

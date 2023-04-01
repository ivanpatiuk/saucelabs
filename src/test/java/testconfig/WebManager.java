package testconfig;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeSuite;
import ymlconfig.TestConfiguration;

import java.time.Duration;

@Data
@NoArgsConstructor
public class WebManager {

    public static WebDriver getDriver(final WebDriver webDriver, final String site){
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        webDriver.get(site);
        return webDriver;
    }

    public static WebDriver setupChromeDriver(final String site) {
        System.setProperty(TestConfiguration
                        .getProperties()
                        .getWebDriver()
                        .getChromeWebDriver(),
                TestConfiguration
                        .getProperties()
                        .getDriver()
                        .getChromeDriver());
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        return getDriver(new ChromeDriver(options), site);
    }
}

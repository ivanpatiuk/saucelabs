package testconfig;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ymlconfig.TestConfiguration;

@Data
@NoArgsConstructor
public class WebManager {

    public static WebDriver setupChromeDriver(final String site) {
        System.setProperty(TestConfiguration
                        .getProperties()
                        .getWebDriver()
                        .getChromeWebDriver(),
                TestConfiguration
                        .getProperties()
                        .getDriver()
                        .getChromeDriver());

        WebDriver webDriver = new ChromeDriver();
        webDriver.get(site);
        return webDriver;
    }
}

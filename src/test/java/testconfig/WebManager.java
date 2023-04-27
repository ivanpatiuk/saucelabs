package testconfig;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import ymlconfig.TestConfiguration;

import java.time.Duration;

@Data
@NoArgsConstructor
public class WebManager {

    public static WebDriver getDriver(final WebDriver webDriver, final String site) {
        webDriver.get(site);
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(2));
        return webDriver;
    }

    public static WebDriver getChromeDriver() {
        final ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        return getDriver(new ChromeDriver(options), TestConfiguration.getProperties().getTestSiteAddress());
    }

    public static void setupChromeDriver() {
        WebDriverManager.chromedriver().setup();
    }
}

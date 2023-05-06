package com.saucelabs.testconfig;

import com.saucelabs.ymlconfig.TestConfiguration;
import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

@Data
@NoArgsConstructor
@Log4j2
public class WebManager {

    public static WebDriver getDriver(final WebDriver webDriver, final String site) {
        log.debug("Getting driver");
        webDriver.get(site);
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(2));
        return webDriver;
    }

    public static WebDriver getChromeDriver() {
        log.debug("Getting chrome driver");
        final ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        return getDriver(new ChromeDriver(options), TestConfiguration.getProperties().getTestSiteAddress());
    }

    public static void setupChromeDriver() {
        log.debug("Setting up chrome driver");
        WebDriverManager.chromedriver().setup();
    }
}

package com.saucelabs.tests;

import com.saucelabs.pages.base.BaseDriver;
import com.saucelabs.testconfig.WebManager;
import lombok.extern.log4j.Log4j2;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

@Log4j2
public abstract class BaseTest extends BaseDriver {

    @BeforeSuite
    public void setup() {

        WebManager.setupChromeDriver();
    }

    @BeforeMethod
    public void before() {
        driver = WebManager.getChromeDriver();
    }

    @AfterMethod
    public void close() {
        log.debug("Closing driver");
        driver.quit();
    }
}

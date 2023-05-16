package com.saucelabs.tests;

import com.saucelabs.entities.TestVariables;
import com.saucelabs.pageActions.HomePageActions;
import com.saucelabs.testconfig.WebManager;
import lombok.extern.log4j.Log4j2;
import org.testng.annotations.BeforeMethod;

@Log4j2
public abstract class LoggedUserBaseTest extends BaseTest {
    @Override
    @BeforeMethod
    public void before() {
        try {
            log.debug("Before method setup");
            driver = WebManager.getChromeDriver();
            final HomePageActions homePageActions = new HomePageActions(driver);
            homePageActions.successfulLogin(TestVariables.TESTED_USER_NAME, TestVariables.VALID_PASSWORD);
        } catch (Exception e){
            log.error("Running test was interrupted.");
            driver.quit();
            throw e;
        }
    }
}

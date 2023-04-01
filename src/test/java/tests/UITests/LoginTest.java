package tests.UITests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import testconfig.WebManager;
import ymlconfig.TestConfiguration;

public class LoginTest extends BaseTest {
    @BeforeClass
    void init() {
        driver = WebManager.setupChromeDriver(TestConfiguration.getProperties().getTestSiteAddress());
    }

    @Test
    void loginStandardUserShouldSuccessTest() throws InterruptedException {
        Thread.sleep(5000);
    }
}

package apiTests;

import io.qameta.allure.*;
import org.asynchttpclient.util.Assertions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

@Epic("Epic1")
@Feature("Feature1")
public class SimpleTest {

    @Issue("1")
    @Story("Story2")
    @Test(priority = 1, groups = {"firstgroup"})
    @Description("Description")
    public void setup(){
        System.out.println("This is setup test");
        setupStep("Ivan");
        Assert.assertEquals(1,1);
    }
    @Test(priority = 1, groups = {"firstgroup2"})
    public void setup2(){
        System.out.println("This is setup test");
        setupStep("Ivan");
        Assert.assertEquals(1,1);
    }

    @Step("step with arg {0}")
    public void setupStep(final String arg){}
    @Test(priority = 2, dependsOnMethods = "setup")
    public void login(){
        System.out.println("Logging");
    }

    @Test(priority = 3, dependsOnMethods = "login")
    public void closeBrowser(){
        System.out.println("Closing browser");
    }
}

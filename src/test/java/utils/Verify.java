package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import support.Action;

import java.util.List;

public class Verify {

    public static void verifyUrl(final WebDriver driver, final String expected) {
        String actual = driver.getCurrentUrl();
        Assert.assertEquals(actual, expected);
    }

    public static void verifyTextContains(final WebDriver driver, final String xpath, final String expected) {
        String actual = driver.findElement(By.xpath(xpath)).getText();
        Assert.assertTrue(actual.contains(expected));
    }

    public static void verifyTime(final Action action, final long expected) {
        long before = System.currentTimeMillis();
        action.execute();
        long actual = System.currentTimeMillis() - before;
        Assert.assertTrue(actual < expected, "Expected time: " + expected + " <, but was: " + actual);
    }

    public static void verifyTime(final List<Action> actions, final long expected) {
        long before = System.currentTimeMillis();
        actions.forEach(Action::execute);
        long actual = System.currentTimeMillis() - before;
        Assert.assertTrue(actual < expected, "Expected time: " + expected + " <, but was: " + actual);
    }
}

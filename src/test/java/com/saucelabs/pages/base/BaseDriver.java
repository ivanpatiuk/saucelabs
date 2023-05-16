package com.saucelabs.pages.base;

import com.saucelabs.entities.TestVariables;
import com.saucelabs.support.Action;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
public abstract class BaseDriver {
    protected WebDriver driver;

    public WebDriverWait getWait(final long millis) {
        return new WebDriverWait(driver, Duration.ofMillis(millis));
    }

    public WebElement findElementBy(final By by, long millis) {
        return getWait(millis).until(d -> d.findElement(by));
    }


    public List<WebElement> findElementsBy(final By by, long millis) {
        return getWait(millis).until(d -> d.findElements(by));
    }

    public void waitUntilVisible(final WebElement webElement, final long millis) {
        getWait(millis).until(ExpectedConditions.visibilityOf(webElement));
    }

    public void waitUntilVisible(final By by, final long millis) {
        getWait(millis).until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public void waitUntilInvisible(final WebElement webElement, final long millis) {
        getWait(millis).until(ExpectedConditions.invisibilityOf(webElement));
    }

    public void waitUntilInvisible(final By by, final long millis) {
        getWait(millis).until(ExpectedConditions.invisibilityOfElementLocated(by));
    }

    public void waitUntilClickable(final WebElement webElement, final long millis) {
        getWait(millis).until(ExpectedConditions.elementToBeClickable(webElement));
    }

    public void waitUntilClickable(final By by, final long millis) {
        getWait(millis).until(ExpectedConditions.elementToBeClickable(by));
    }

    public void waitUntilSelected(final WebElement webElement, final long millis) {
        getWait(millis).until(ExpectedConditions.elementToBeSelected(webElement));
    }

    public void waitUntilSelected(final By by, final long millis) {
        getWait(millis).until(ExpectedConditions.elementToBeSelected(by));
    }

    public void verifyUrl(final String expected) {
        String actual = driver.getCurrentUrl();
        Assert.assertEquals(actual, expected);
    }

    public void verifyTextContains(final By by, final String expected) {
        String actual = findElementBy(by, TestVariables.ONE_SECOND).getText();
        Assert.assertTrue(actual.contains(expected));
    }

    public void verifyLogoAndUrl(final String url) {
        verifyUrl(url);
        verifyTextContains(By.xpath("//div[@id=\"header_container\"]//div[@class=\"app_logo\"]"), "Swag Labs");
    }


    public void verifyTime(final Action action, final long expected) {
        long before = System.currentTimeMillis();
        action.execute();
        long actual = System.currentTimeMillis() - before;
        Assert.assertTrue(actual < expected, "Expected time: " + expected + " <, but was: " + actual);
    }

    public void verifyTime(final List<Action> actions, final long expected) {
        long before = System.currentTimeMillis();
        actions.forEach(Action::execute);
        long actual = System.currentTimeMillis() - before;
        Assert.assertTrue(actual < expected, "Expected time: " + expected + " <, but was: " + actual);
    }
}

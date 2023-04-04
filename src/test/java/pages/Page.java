package pages;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

@Getter
public abstract class Page {
    protected WebDriver driver;

    public Page(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    private WebDriverWait getWait(final long millis) {
        return new WebDriverWait(driver, Duration.ofMillis(millis));
    }

    protected WebElement findBy(final By by){
        return new WebDriverWait(driver, Duration.ofMillis(1000)).until(driver -> driver.findElement(by));
    }

    protected void waitUntilVisible(final WebElement webElement, final long millis) {
        getWait(millis).until(ExpectedConditions.visibilityOf(webElement));
    }


    protected void waitUntilVisible(final By by, final long millis) {
        getWait(millis).until(ExpectedConditions.visibilityOfElementLocated(by));
    }


    protected void waitUntilInvisible(final WebElement webElement, final long millis) {
        getWait(millis).until(ExpectedConditions.invisibilityOf(webElement));
    }

    protected void waitUntilInvisible(final By by, final long millis) {
        getWait(millis).until(ExpectedConditions.invisibilityOfElementLocated(by));
    }

    protected void waitUntilClickable(final WebElement webElement, final long millis) {
        getWait(millis).until(ExpectedConditions.elementToBeClickable(webElement));
    }

    protected void waitUntilClickable(final By by, final long millis) {
        getWait(millis).until(ExpectedConditions.elementToBeClickable(by));
    }

    protected void waitUntilSelected(final WebElement webElement, final long millis) {
        getWait(millis).until(ExpectedConditions.elementToBeSelected(webElement));
    }

    protected void waitUntilSelected(final By by, final long millis) {
        getWait(millis).until(ExpectedConditions.elementToBeSelected(by));
    }
}

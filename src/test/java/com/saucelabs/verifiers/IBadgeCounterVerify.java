package com.saucelabs.verifiers;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public interface IBadgeCounterVerify {
    default void verifyCartBadge(final WebElement cartBadgeCounter, final String expected) {
        if (expected != null && !expected.equals("0")) {
            final String actual = cartBadgeCounter.getText();
            Assert.assertEquals(actual, expected);
        } else {
            Assert.assertThrows(NoSuchElementException.class, cartBadgeCounter::getText);
        }
    }
}

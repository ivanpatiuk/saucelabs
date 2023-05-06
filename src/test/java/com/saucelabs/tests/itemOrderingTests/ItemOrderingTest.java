package com.saucelabs.tests.itemOrderingTests;

import com.saucelabs.steps.Shop;
import com.saucelabs.tests.LoggedUserBaseTest;
import org.testng.annotations.Test;

public class ItemOrderingTest extends LoggedUserBaseTest {

    @Test
    void orderItemTestShouldSuccess() {
        final Shop shop = new Shop(driver);
        shop.verifyOneItemOrdering();
    }
}

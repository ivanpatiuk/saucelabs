package tests.itemOrderingTests;

import org.testng.annotations.Test;
import steps.Shop;
import tests.LoggedUserBaseTest;

public class ItemOrderingTest extends LoggedUserBaseTest {

    @Test
    void orderItemTestShouldSuccess() {
        Shop shop = new Shop(driver);
        shop.verifyOneItemOrdering();
    }
}

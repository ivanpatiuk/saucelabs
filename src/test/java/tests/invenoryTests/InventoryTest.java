package tests.invenoryTests;

import entities.OrderingTestData;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import steps.Home;
import steps.Shop;
import tests.LoggedUserBaseTest;

import java.util.List;

import static entities.TestVariables.STANDARD_USERNAME;
import static entities.TestVariables.VALID_PASSWORD;

public class InventoryTest extends LoggedUserBaseTest {

    private List<OrderingTestData> getOrderingTestDataList() {
        return List.of(
                new OrderingTestData("Name (A to Z)", false, By.xpath("//div[@class=\"inventory_list\"]//div[@class=\"inventory_item_name\"]")),
                new OrderingTestData("Name (Z to A)", true, By.xpath("//div[@class=\"inventory_list\"]//div[@class=\"inventory_item_name\"]")),
                new OrderingTestData("Price (low to high)", false, By.xpath("//div[@class=\"inventory_list\"]//div[@class=\"inventory_item_price\"]")),
                new OrderingTestData("Price (high to low)", true, By.xpath("//div[@class=\"inventory_list\"]//div[@class=\"inventory_item_price\"]")));
    }

    @Test(dependsOnGroups = "login")
    void orderingTestShouldSuccess() {
        Shop shop = new Shop(driver);
        shop.verifyOrdering(getOrderingTestDataList());
    }

    @Test(dependsOnGroups = "login")
    void descriptionTestShouldSuccess() {
        Shop shop = new Shop(driver);
        shop.verifyDescription();
    }
}

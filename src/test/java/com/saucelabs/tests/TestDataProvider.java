package com.saucelabs.tests;

import com.saucelabs.entities.OrderingTestData;
import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;

import java.util.List;

public class TestDataProvider {
    @DataProvider(name = "itemIndicesDataProvider")
    public static Object[][] itemIndicesDataProvider() {
        return new Object[][]{
                {List.of(0)},
                {List.of(5)},
                {List.of(0, 1, 2, 3, 4, 5)}
        };
    }

    public static List<OrderingTestData> getOrderingTestDataList() {
        return List.of(
                new OrderingTestData("Name (A to Z)", false, By.xpath("//div[@class=\"inventory_list\"]//div[@class=\"inventory_item_name\"]")),
                new OrderingTestData("Name (Z to A)", true, By.xpath("//div[@class=\"inventory_list\"]//div[@class=\"inventory_item_name\"]")),
                new OrderingTestData("Price (low to high)", false, By.xpath("//div[@class=\"inventory_list\"]//div[@class=\"inventory_item_price\"]")),
                new OrderingTestData("Price (high to low)", true, By.xpath("//div[@class=\"inventory_list\"]//div[@class=\"inventory_item_price\"]")));
    }

    public static List<Integer> getFirstAndLastItemIndices() {
        return List.of(0, 5);
    }
}

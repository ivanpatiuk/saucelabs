package com.saucelabs.entities;

import com.saucelabs.ymlconfig.TestConfiguration;
import org.openqa.selenium.By;

import java.util.List;

public class TestVariables {
    public static final String TESTED_USER_NAME = TestConfiguration.getProperties().getUsersCredentials().getTestedUserName();
    public static final String STANDARD_USERNAME = TestConfiguration.getProperties().getUsersCredentials().getStandardUserName();
    public static final String LOCKED_OUT_USERNAME = TestConfiguration.getProperties().getUsersCredentials().getLockedOutUserName();
    public static final String PROBLEM_USERNAME = TestConfiguration.getProperties().getUsersCredentials().getProblemUserName();
    public static final String PERFORMANCE_GLITCH_USERNAME = TestConfiguration.getProperties().getUsersCredentials().getPerformanceGlitchUserName();

    public static final String VALID_PASSWORD = TestConfiguration.getProperties().getUsersCredentials().getPassword();
    public static final String NOT_VALID_PASSWORD = "NOT_VALID_PASSWORD";

    public static final String HOME_PAGE_URL = TestConfiguration.getProperties().getTestSiteAddress();
    public static final String SHOP_PAGE_URL = HOME_PAGE_URL + "inventory.html";
    public static final String CHECKOUT_STEP_ONE_PAGE_URL = HOME_PAGE_URL + "checkout-step-one.html";
    public static final String CART_PAGE_URL = HOME_PAGE_URL + "cart.html";

    public static final long ONE_SECOND = 1000;

    public static final List<By> INVENTORY_ITEM_XPATHS = List.of(By.xpath(".//div[@class='inventory_item_name']"), By.xpath(".//div[@class='inventory_item_desc']"), By.xpath(".//div[@class='inventory_item_price']"));
    public static final List<By> INVENTORY_DETAILS_XPATHS = List.of(By.xpath(".//div[contains(@class,'inventory_details_name')]"), By.xpath(".//div[contains(@class,'inventory_details_desc large_size')]"), By.xpath(".//div[contains(@class,'inventory_details_price')]"));
}


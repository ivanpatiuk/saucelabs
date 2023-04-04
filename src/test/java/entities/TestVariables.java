package entities;

import ymlconfig.TestConfiguration;

import java.util.Scanner;

public class TestVariables {
    public static final String STANDARD_USERNAME = TestConfiguration.getProperties().getUsersCredentials().getStandardUserName();
    public static final String LOCKED_OUT_USERNAME = TestConfiguration.getProperties().getUsersCredentials().getLockedOutUserName();
    public static final String PROBLEM_USERNAME = TestConfiguration.getProperties().getUsersCredentials().getProblemUserName();
    public static final String PERFORMANCE_GLITCH_USERNAME = TestConfiguration.getProperties().getUsersCredentials().getPerformanceGlitchUserName();

    public static final String VALID_PASSWORD = TestConfiguration.getProperties().getUsersCredentials().getPassword();
    public static final String NOT_VALID_PASSWORD = "NOT_VALID_PASSWORD";

    public static final String HOME_PAGE_URL = TestConfiguration.getProperties().getTestSiteAddress();
    public static final String SHOP_PAGE_URL = HOME_PAGE_URL + "inventory.html";

    public static final long ONE_SECOND = 1000;
}


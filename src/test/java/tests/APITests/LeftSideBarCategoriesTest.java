package tests.APITests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.JSONPath;

import static io.restassured.RestAssured.given;


@Log4j
public class LeftSideBarCategoriesTest {

    private Response response;

    @BeforeClass
    public void getResponse(){
        response = RestAssured
                .get("https://common-api.rozetka.com.ua/v2/fat-menu/full?front-type=xl&country=UA&lang=ua&r=0.5034050049240193");
    }

    @Test(description = "leftSideBarCategoriesTest[{0}]", dataProviderClass = TestDataProvider.class, dataProvider = "getLeftSideBarCategoriesTestData")
    public void leftSideBarCategoriesTest(final String id, final String expectedTitle, final String expectedUrl) {
        String actualTitle = JSONPath.getByJsonPath(response, "data."+id+".title");
        String actualUrl = JSONPath.getByJsonPath(response, "data."+id+".manual_url");

        Assert.assertEquals(expectedTitle, actualTitle);
        Assert.assertEquals(expectedUrl, actualUrl);
    }
    @Test(testName = "hello")
    public void test(){

    }
}

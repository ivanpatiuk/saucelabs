package steps;

import com.google.common.collect.Ordering;
import entities.OrderingTestData;
import io.netty.util.internal.StringUtil;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.ShopPage;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static entities.TestVariables.HOME_PAGE_URL;
import static entities.TestVariables.ONE_SECOND;

@Getter
public class Shop extends ShopPage {

    public Shop(WebDriver driver) {
        super(driver);
    }

    private void assertOrdering(final String orderingName, final List<String> items) {
        if (orderingName.contains("Name")) {
            Assert.assertTrue(Ordering.natural().isOrdered(items));
        } else {
            items.forEach(item -> Assert.assertTrue(item.contains("$")));
            Assert.assertTrue(Ordering.natural().isOrdered(items.stream()
                    .map(item -> Double.parseDouble(item.substring(1))).toList()));
        }
    }

    private List<String> getElementsText(final Shop shop, final By by) {
        return shop
                .findElementsBy(by, ONE_SECOND)
                .stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

    public void verifyOrdering(final List<OrderingTestData> orderingTestDataList) {
        orderingTestDataList.forEach(orderingTestData -> {
            this.selectOrdering(orderingTestData.getOrderingName());
            List<String> items = getElementsText(this, orderingTestData.getBy());
            if (orderingTestData.isReversed()) {
                Collections.reverse(items);
            }
            assertOrdering(orderingTestData.getOrderingName(), items);
        });
    }

    public void orderItem(final String string) {
        addToCart(string);
        clickOnCart();
    }

    public void logout() {
        clickOnSideBar();
        clickOnLogout();
        verifyUrl(HOME_PAGE_URL);
    }

    public void verifyDescription() {
        final List<String> itemsDescription = getElementsText(this, getInventoryItemsDescription());
        itemsDescription.forEach(description -> Assert.assertFalse(StringUtil.isNullOrEmpty(description)));
    }
}

package com.saucelabs.steps;

import com.saucelabs.models.ItemDTO;
import com.saucelabs.pages.CartPage;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

import static com.saucelabs.entities.TestVariables.ONE_SECOND;

@Log4j2
public class Cart extends CartPage {

    public Cart(WebDriver driver) {
        super(driver);
    }

    private void verifyItemQTY(final WebElement item) {
        log.debug("Verifying item QTY.");
        final String QTY = item.findElement(By.xpath("//div[@class='cart_quantity']")).getText();
        Assert.assertEquals(QTY, "1");
    }

    private void verifyItemDescription(final WebElement item) {
        log.debug("Verifying item description.");
        final ItemDTO cartPageItemDTO = ItemDTO.getItemDTO(item);
        Assert.assertEquals(cartPageItemDTO, cartPageItemDTO);
    }

    private void verifyUIElements() {
        log.debug("Verifying UI elements.");
        waitUntilClickable(getCheckoutButton(), ONE_SECOND);
        waitUntilClickable(getRemoveButton(), ONE_SECOND);
        waitUntilClickable(getContinueShippingButton(), ONE_SECOND);
        waitUntilVisible(getCartBadgeCounter(), ONE_SECOND);
    }

    public void verifyCartPageWithItems(final List<ItemDTO> itemDTOS) {
        log.debug("Verifying cart page item with items count: {}", itemDTOS.size());
        Assert.assertEquals(getCartBadgeCounter().getText(), String.valueOf(itemDTOS.size()));
        verifyUIElements();
        itemDTOS.forEach(itemDTO -> {
            log.debug("Verifying cart page item: {}", itemDTO.getName());
            WebElement item = getCartItemByName(itemDTO.getName());
            verifyItemQTY(item);
            verifyItemDescription(item);
        });
    }
}

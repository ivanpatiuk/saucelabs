package com.saucelabs.pageActions;

import com.saucelabs.models.ItemDTO;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public interface IBaseItemVerify {
    default void verifyItemQTY(final WebElement item) {
        final String QTY = item.findElement(By.xpath("./div[@class='cart_quantity']")).getText();
        Assert.assertEquals(QTY, "1");
    }

    default void verifyItemDescription(final WebElement item) {
        final ItemDTO cartPageItemDTO = ItemDTO.getItemDTO(item);
        Assert.assertEquals(cartPageItemDTO, cartPageItemDTO);
    }

    void verifyUIElements();

    void verifyCartPageWithItems(final List<ItemDTO> itemDTOS);
}

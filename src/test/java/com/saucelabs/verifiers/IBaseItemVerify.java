package com.saucelabs.verifiers;

import com.saucelabs.models.ItemDTO;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import javax.naming.OperationNotSupportedException;
import java.util.List;

public interface IBaseItemVerify {
    default void verifyItemQTY(final WebElement item) {
        final String QTY = item.findElement(By.xpath("./div[@class='cart_quantity']")).getText();
        Assert.assertEquals(QTY, "1");
    }

    default void verifyItemDescription(final WebElement webElement, final ItemDTO expected, final List<By> xpaths) {
        final ItemDTO actual = ItemDTO.getItemDTO(webElement, xpaths);
        Assert.assertEquals(actual, expected);
    }

    default void verifyUIElements() throws OperationNotSupportedException {
        throw new OperationNotSupportedException("The method is not overridden.");
    }

    default void verifyCartPageWithItems(final List<ItemDTO> itemDTOS) throws OperationNotSupportedException {
        throw new OperationNotSupportedException("The method is not overridden.");
    }
}

package com.saucelabs.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

@Data
@AllArgsConstructor
@EqualsAndHashCode
@Log4j2
public class ItemDTO {
    private String name;
    private String description;
    private String price;

    public static ItemDTO getItemDTO(final WebElement item, final By name, final By description, final By price) {
        log.debug("Creating ItemDTO.");
        return new ItemDTO(
                item.findElement(name).getText(),
                item.findElement(description).getText(),
                item.findElement(price).getText());
    }

    public static ItemDTO getItemDTO(final WebElement webElement) {
        return ItemDTO.getItemDTO(
                webElement,
                By.xpath(".//div[@class='inventory_item_name']"),
                By.xpath(".//div[@class='inventory_item_desc']"),
                By.xpath(".//div[@class='inventory_item_price']"));
    }
}

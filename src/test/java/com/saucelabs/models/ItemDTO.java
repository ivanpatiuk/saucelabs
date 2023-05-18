package com.saucelabs.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

@Data
@AllArgsConstructor
@EqualsAndHashCode
@Log4j2
public class ItemDTO {
    private String name;
    private String description;
    private String price;

    public static ItemDTO getItemDTO(final WebElement item, final List<By> xpaths) {
        log.debug("Creating ItemDTO.");
        return new ItemDTO(
                item.findElement(xpaths.get(0)).getText(),
                item.findElement(xpaths.get(1)).getText(),
                item.findElement(xpaths.get(2)).getText());
    }
}

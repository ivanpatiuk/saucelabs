package models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

@Data
@AllArgsConstructor
@EqualsAndHashCode
public class ItemDTO {
    private String name;
    private String description;
    private String price;

    public static ItemDTO getItemDTO(final WebElement item, final By name, final By description, final By price){
        return new ItemDTO(
                item.findElement(name).getText(),
                item.findElement(description).getText(),
                item.findElement(price).getText());
    }
}
package pages;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BaseDriver;

import static entities.TestVariables.ONE_SECOND;

@Getter
public class ItemPage extends BaseDriver {
    @FindBy(xpath = "//div[@class='inventory_details_container']")
    private WebElement item;
    @FindBy(xpath = "//div[@class='inventory_details_desc_container']//button[contains(@id, 'add-to-cart')]")
    private WebElement addToCartButton;
    @FindBy(xpath = "//div[@class='left_component']/button[contains(@id, 'back-to-products')]")
    private WebElement backToProductsButton;

    public ItemPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void clickOnAddToCartButton(){
        waitUntilClickable(addToCartButton, ONE_SECOND);
        addToCartButton.click();
    }

    public void clickOnBackToProductsButton(){
        waitUntilClickable(backToProductsButton, ONE_SECOND);
        backToProductsButton.click();
    }
}
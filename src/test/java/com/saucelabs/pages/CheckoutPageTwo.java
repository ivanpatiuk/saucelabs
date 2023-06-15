package com.saucelabs.pages;

import com.saucelabs.pages.base.CheckoutBasePage;
import lombok.Getter;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.saucelabs.entities.TestVariables.ONE_SECOND;

@Getter
@Log4j2
public class CheckoutPageTwo extends CheckoutBasePage {
    @FindBy(xpath = "//button[@id='finish']")
    private WebElement finishButton;
    @FindBy(xpath = "//div[@class='summary_subtotal_label']")
    private WebElement itemTotalPrice;
    @FindBy(xpath = "//div[@class='summary_tax_label']")
    private WebElement summaryTaxPrice;
    @FindBy(xpath = "//div[contains(@class, 'summary_total_label')]")
    private WebElement totalPrice;


    public CheckoutPageTwo(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void clickOnFinishButton() {
        log.debug("Clicking on 'Finish' button.");
        waitUntilClickable(finishButton, ONE_SECOND);
        finishButton.click();
    }
}

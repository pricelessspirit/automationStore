package com.github.automatedowl.examples.pages;

import com.github.automatedowl.examples.selenium.Wait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SuccessfulOrderCompletionDlg {
    private final WebDriver driver;

    @FindBy(css = "div#layer_cart span.btn[title='Continue shopping']")
    private WebElement continueShoppingBtn;

    @FindBy(css = "div#layer_cart a.btn[title='Proceed to checkout")
    private WebElement proceedToCheckoutBtn;

    public SuccessfulOrderCompletionDlg(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void waitUntilDisplays() {
        Wait.forElementVisible(driver, By.xpath("//div[@id='layer_cart']//h2"));
    }

    public void clickContinueShopping() {
        continueShoppingBtn.click();
    }
}

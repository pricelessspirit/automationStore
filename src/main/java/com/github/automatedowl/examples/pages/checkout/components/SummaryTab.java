package com.github.automatedowl.examples.pages.checkout.components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SummaryTab {

    @FindBy(css = "a[title='Proceed to checkout'].standard-checkout")
    private WebElement proceedToCheckoutBtn;
    private final WebDriver driver;

    public SummaryTab(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickProceedToCheckoutBtn() {
        proceedToCheckoutBtn.click();
    }
}

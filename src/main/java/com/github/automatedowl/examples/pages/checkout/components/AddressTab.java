package com.github.automatedowl.examples.pages.checkout.components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddressTab {
    private final WebDriver driver;

    @FindBy(xpath = "//button[starts-with(@name, 'process')]")
    private WebElement proceedToCheckoutBtn;

    public AddressTab(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickProceedToCheckoutBtn() {
        proceedToCheckoutBtn.click();
    }
}

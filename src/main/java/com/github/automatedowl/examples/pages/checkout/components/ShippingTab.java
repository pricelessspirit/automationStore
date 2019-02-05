package com.github.automatedowl.examples.pages.checkout.components;

import com.github.automatedowl.examples.selenium.Perform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShippingTab {
    private final WebDriver driver;

    @FindBy(css = "input[type=checkbox]")
    private WebElement agreeChb;

    @FindBy(xpath = "//button[starts-with(@name, 'process')]")
    private WebElement proceedToCheckoutBtn;

    public ShippingTab(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void agreeWithTermsOfService(boolean b) {
        Perform.setToggle(agreeChb, b);
    }

    public void clickProceedToCheckoutBtn() {
        proceedToCheckoutBtn.click();
    }
}

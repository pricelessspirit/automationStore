package com.github.automatedowl.examples.pages.checkout;

import com.github.automatedowl.examples.models.Customer;
import com.github.automatedowl.examples.pages.checkout.components.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOutWizardPage {

    private final WebDriver driver;
    @FindBy(xpath = "//a[@title='Previous']")
    private WebElement continueShoppingBtn;

    @FindBy(xpath = "//button[starts-with(@name, 'process')]")
    private WebElement proceedToCheckoutBtn;

    private SummaryTab summaryTab;
    private SignInTab signInTab;
    private AddressTab addressTab;
    private ShippingTab shippingTab;
    private PaymentTab paymentTab;


    public CheckOutWizardPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        summaryTab = new SummaryTab(driver);
        signInTab = new SignInTab(driver);
        addressTab = new AddressTab(driver);
        shippingTab = new ShippingTab(driver);
        paymentTab = new PaymentTab(driver);
    }



    public SummaryTab getSummaryTab() {
        return summaryTab;
    }

    public SignInTab getSignInTab() {
        return signInTab;
    }

    public AddressTab getAddressTab() {
        return addressTab;
    }

    public ShippingTab getShippingTab() {
        return shippingTab;
    }

    public PaymentTab getPaymentTab() {
        return paymentTab;
    }

    public String getActiveTabName() {
        return driver.findElement(By.cssSelector("ul#order_step>li.step_current")).getText().trim();
    }

    public void registerNewCustomer(Customer customer) {
        signInTab = new SignInTab(driver);
        signInTab.registerCustomer(customer);
    }

    public void agreeWithTermsOfService(boolean b) {
        shippingTab.agreeWithTermsOfService(b);
    }
}

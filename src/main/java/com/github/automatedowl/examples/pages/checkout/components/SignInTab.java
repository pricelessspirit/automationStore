package com.github.automatedowl.examples.pages.checkout.components;

import com.github.automatedowl.examples.models.Customer;
import com.github.automatedowl.examples.selenium.Perform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SignInTab {

    private final Logger log = LoggerFactory.getLogger(getClass());


    @FindBy(css = "input#email_create")
    private WebElement createAccountEmailFld;
    @FindBy(css = "button#SubmitCreate")
    private WebElement createAccountBtn;

    private final WebDriver driver;
    public RegistryForm registryForm;

    public SignInTab(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void registerCustomer(Customer customer) {
        Perform.setTextField(createAccountEmailFld, customer.getEmail());
        createAccountBtn.click();

        registryForm = new RegistryForm(driver);
        registryForm.fill(customer);
        registryForm.clickSave();

        log.info("Registering a customer with following email:" + customer.getEmail());
    }
}

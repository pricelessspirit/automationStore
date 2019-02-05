package com.github.automatedowl.examples.pages.checkout.components;

import com.github.automatedowl.examples.models.Customer;
import com.github.automatedowl.examples.selenium.Perform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistryForm {

    @FindBy(css = "input#customer_firstname")
    private WebElement personalFirstNameFld;

    @FindBy(css = "input#customer_lastname")
    private WebElement personalLastNameFld;

    @FindBy(css = "input#email")
    private WebElement personalEmailFld;

    @FindBy(css = "input#passwd")
    private WebElement personalPassFld;

    @FindBy(css = "input#address1")
    private WebElement addressFld;

    @FindBy(css = "input#city")
    private WebElement cityFld;

    @FindBy(css = "select#id_state")
    private WebElement stateDD;

    @FindBy(css = "input#postcode")
    private WebElement zipFld;

    @FindBy(css = "select#id_country")
    private WebElement countryDD;

    @FindBy(css = "input#phone_mobile")
    private WebElement mobilePhoneFld;

    @FindBy(css = "input#alias")
    private WebElement aliasRefFld;

    @FindBy(css = "button#submitAccount")
    private WebElement registerBtn;

    private final WebDriver driver;

    public RegistryForm(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void fill(Customer customer) {

        if (customer.getFirstName() != null) {
            Perform.setTextField(personalFirstNameFld, customer.getFirstName());
        }

        if (customer.getLastName() != null) {
            Perform.setTextField(personalLastNameFld, customer.getLastName());
        }

        if (customer.getEmail() != null) {
            Perform.setTextField(personalEmailFld, customer.getEmail());
        }

        if (customer.getPassword() != null) {
            Perform.setTextField(personalPassFld, customer.getPassword());
        }

        if (customer.getAddress() != null) {
            Perform.setTextField(addressFld, customer.getAddress());
        }

        if (customer.getCity() != null) {
            Perform.setTextField(cityFld, customer.getCity());
        }

        if (customer.getState() != null) {
            Perform.setSelectDropdownField(stateDD, customer.getState());
        }

        if (customer.getZip() != null) {
            Perform.setTextField(zipFld, customer.getZip());
        }

        if (customer.getCountry() != null) {
            Perform.setSelectDropdownField(countryDD, customer.getCountry());
        }

        if (customer.getMobilePhone() != null) {
            Perform.setTextField(mobilePhoneFld, customer.getMobilePhone());
        }

        if (customer.getAliasRef() != null) {
            Perform.setTextField(aliasRefFld, customer.getAliasRef());
        }

    }

    public void clickSave() {
        registerBtn.click();
    }

}

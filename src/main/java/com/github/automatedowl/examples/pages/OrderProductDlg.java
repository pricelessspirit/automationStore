package com.github.automatedowl.examples.pages;

import com.github.automatedowl.examples.models.OrderItem;
import com.github.automatedowl.examples.selenium.Perform;
import com.github.automatedowl.examples.selenium.Wait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderProductDlg {


    @FindBy(css = "p.our_price_display>span")
    private WebElement priceLbl;

    @FindBy(css = "input#quantity_wanted")
    private WebElement quantityFld;
    @FindBy(css = ".primary_block #attributes>fieldset:nth-of-type(1) select")
    private WebElement sizeDD;
    @FindBy(css = ".primary_block p#add_to_cart>button")
    private WebElement addToCartBtn;

    private final WebDriver driver;

    public OrderProductDlg(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void fill(OrderItem orderItem) {
        setQuantity(orderItem.getQuantity());
        setSize(orderItem.getSize());

    }

    public Double getPriceValue() {
        return Double.valueOf(priceLbl.getText().replaceAll("[$,]", ""));
    }

    public WebElement getQuantityFld() {
        return quantityFld;

    }

    public WebElement getSizeDD() {
        return sizeDD;
    }

    public void setQuantity(int quantity) {

        Wait.forElementClickable(driver,quantityFld);
        Perform.setTextField(quantityFld, String.valueOf(quantity));

    }

    public void setSize(String size) {
        Perform.setSelectDropdownField(getSizeDD(), size);
    }

    public void clickAddToCart() {
        addToCartBtn.click();
    }
}

package com.github.automatedowl.examples.pages;

import com.github.automatedowl.examples.selenium.Perform;
import com.github.automatedowl.examples.selenium.Wait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    private final WebDriver driver;



    @FindBy(css = "div.shopping_cart>a[title='View my shopping cart']")
    private WebElement shoppingCartBtn;

    private String menuItemXpathLocator="//div[@id='block_top_menu']//li/a[contains(text(),'%s')]";

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebElement getShoppingCartBtn() {
        return shoppingCartBtn;
    }

    public void navigateViaMenu(String s) {
        String[] navigationRoute= s.split(" -> ");

        for (int i = 0 ; i<navigationRoute.length; i++){
            By menuItemBy = By.xpath(String.format(menuItemXpathLocator,navigationRoute[i].trim()));

            Wait.forElementVisible(driver, menuItemBy);

            if (i == (navigationRoute.length-1)){
                driver.findElement(menuItemBy).click();
            } else{
                Perform.hoverOver(driver,menuItemBy);
            }

        }

    }

    public void startCheckOutViaHoverOver() {
        Perform.hoverOver(driver,getShoppingCartBtn());
        driver.findElement(By.cssSelector("div.shopping_cart a#button_order_cart")).click();
    }
}

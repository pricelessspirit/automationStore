package com.github.automatedowl.examples.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Perform {

    public static void setToggle(WebElement element, boolean b) {
        boolean chbStatus = element.isSelected();

        if (chbStatus ^ b) {
            element.click();
        }
    }

    public static void hoverOver(WebDriver driver, By elementBy) {
        Actions actions = new Actions(driver);
        WebElement element = driver.findElement(elementBy);
        actions.moveToElement(element).build().perform();
    }

    public static void hoverOver(WebDriver driver, WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).build().perform();
    }

    public static int getIndex(WebDriver driver, By productItemBy, String productName) {
        List<WebElement> elements = driver.findElements(productItemBy);

        for (int i = 0; i < elements.size(); i++) {
            String elementText = elements.get(i).getText().trim();
            if (elementText.equals(productName)) {
                return i;
            }
        }

        return -1;
    }

    public static void setTextField(WebElement field, String value) {
        field.clear();
        field.sendKeys(value);
    }

    public static void setSelectDropdownField(WebElement itemDD, String value) {
        Select selectFld = new Select(itemDD);
        selectFld.selectByVisibleText(value);
    }
}

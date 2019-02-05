package com.github.automatedowl.examples.pages;

import com.github.automatedowl.examples.models.Order;
import com.github.automatedowl.examples.models.OrderItem;
import com.github.automatedowl.examples.selenium.Perform;
import com.github.automatedowl.examples.selenium.Wait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.NoSuchElementException;

public class CatalogPage {

    private final WebDriver driver;

    private final String productItemLocator = "//ul[contains(@class,'product_list')]//a[@class='product-name']";  ///[contains(text(),'%s') ]
    private final String productItemCSSLocator = "ul.product_list a.product-name";  ///[contains(text(),'%s') ]

    private final String productQuickViewLocator = "//ul[contains(@class,'product_list')]/li[%s]//a[@class='quick-view']";  //starts-with(@class,'quick-view')
    //private final String productQuickViewLocator = "//ul[contains(@class,'product_list')]/li[%s]//a[starts-with(@class,'quick-view')]";  //

    private final String productItemImageLocator = "a.product_img_link[title='%s']";
    //private final String productQuickViewLocator = "a.product_img_link[title='%s']+a.quick-view";

    public CatalogPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openQuickView(String productName) {

        int index = Perform.getIndex(driver, By.cssSelector(productItemCSSLocator), productName);

        if (index == -1) {
            throw new NoSuchElementException("Could not find an element product with specified text \"" + productName + "\"");
        }


        Perform.hoverOver(driver,By.cssSelector(String.format(productItemImageLocator,productName)));
        By quickViewBy = By.xpath(String.format(productQuickViewLocator, index + 1));
        driver.findElement(quickViewBy).click();

    }

    public Order orderProductViaQuickView(OrderItem orderItem) {
        openQuickView(orderItem.getDescription());


        OrderProductDlg orderProductDlg = new OrderProductDlg(driver);
        driver.switchTo().frame(0);
        orderProductDlg.fill(orderItem);

        //Retrieve the current price
        orderItem.setPrice(orderProductDlg.getPriceValue());

        orderProductDlg.clickAddToCart();

        SuccessfulOrderCompletionDlg orderCompletionDlg = new SuccessfulOrderCompletionDlg(driver);


        orderCompletionDlg.waitUntilDisplays();
        orderCompletionDlg.clickContinueShopping();
        Order createdOrder = new Order();
        createdOrder.addOrderItem(orderItem);

        return createdOrder;
    }
}

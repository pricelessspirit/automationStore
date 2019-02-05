package com.github.automatedowl.examples.pages.checkout.components;

import com.github.automatedowl.examples.models.Order;
import com.github.automatedowl.examples.models.OrderItem;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class PaymentTab {
    private final WebDriver driver;

    @FindBy(css ="#cart_summary tbody")
    private WebElement orderItemList;


    public PaymentTab(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public Order getOrderDetails() {
        Order parseOrder = new Order();

        List<WebElement> orderItems = orderItemList.findElements(By.xpath("./tr"));

        orderItems.forEach( orderItemElement -> {
            OrderItem orderItem = parseOrderItem(orderItemElement);
            if (orderItem!=null)
                parseOrder.addOrderItem(orderItem);
        });

        return parseOrder;
    }



    private OrderItem parseOrderItem(WebElement element) {
        OrderItem orderItem = new OrderItem();

        try {
            String description = element.findElement(By.xpath("./td[contains(@class,'cart_description')]/p[@class='product-name']/a"))
                    .getText();

            String line2 = element.findElement(By.xpath("./td[contains(@class,'cart_description')]/small[2]/a"))
                    .getText();
            String size = line2.substring(line2.lastIndexOf(":") + 1).trim();

            double price = Double.valueOf(element.findElement(By.xpath("./td[contains(@class,'cart_unit')]/span/span"))
                    .getText().replaceAll("[$,]", ""));

            int quantity = Integer.valueOf(element.findElement(By.xpath("./td[contains(@class,'cart_quantity')]"))
                    .getText());

            double total = Double.valueOf(element.findElement(By.xpath("./td[contains(@class,'cart_total')]"))
                    .getText().replaceAll("[$,]", ""));

            orderItem.setDescription(description);
            orderItem.setSize(size);
            orderItem.setPrice(price);
            orderItem.setQuantity(quantity);
            orderItem.setTotal(total);
        } catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }

        return orderItem;
    }
}

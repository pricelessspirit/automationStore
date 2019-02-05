package com.github.automatedowl.examples.models;

import java.util.ArrayList;
import java.util.List;

public class Order {

    private List<OrderItem> orderItems;

    public Order() {
        orderItems = new ArrayList<OrderItem>();
    }

    public void addOrderItem(OrderItem orderItem) {
        orderItems.add(orderItem);
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

}

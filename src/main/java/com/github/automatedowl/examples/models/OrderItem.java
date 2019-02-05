package com.github.automatedowl.examples.models;

public class OrderItem {

    private String description;
    private int quantity;
    private String size;
    private Double price;
    private Double total;

    public void setDescription(String description) {
        this.description = description;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public String getDescription() {
        return description;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getSize() {
        return size;
    }

    public Double getPrice() {
        return price;
    }

    public Double getTotal() {
        return total;
    }
}

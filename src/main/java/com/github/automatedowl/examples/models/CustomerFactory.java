package com.github.automatedowl.examples.models;

public class CustomerFactory {

    public static Customer getRandomCustomer() {
        int random = (int)(Math.random() * 10000 + 1);

        Customer customer = new Customer();

        customer
                .setFirstName("Mike")
                .setLastName("Wizard")
                .setEmail("Mike"+random+"@gmail.com")
                .setPassword("password")
                .setAddress("123 King St West")
                .setCity("New York")
                .setState("New York")
                .setCountry("United States")
                .setZip("12345")
                .setMobilePhone("123-1233")
                .setAliasRef("MOL-232");

        return customer;
    }

}

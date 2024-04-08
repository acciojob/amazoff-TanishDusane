package com.driver;

// Class representing a delivery partner.
public class DeliveryPartner {

    // Unique identifier for the delivery partner.
    private String id;

    // Number of orders delivered by the partner.
    private int numberOfOrders;

    // Constructor to initialize a delivery partner with an ID and number of orders.
    public DeliveryPartner(String id, int numberOfOrders) {
        this.id = id;
        this.numberOfOrders = numberOfOrders;
    }

    // Getter method to retrieve the ID of the delivery partner.
    public String getId() {
        return id;
    }

    // Setter method to set the ID of the delivery partner.
    public void setId(String id) {
        this.id = id;
    }

    // Getter method to retrieve the number of orders delivered by the partner.
    public int getNumberOfOrders() {
        return numberOfOrders;
    }

    // Setter method to set the number of orders delivered by the partner.
    public void setNumberOfOrders(int numberOfOrders) {
        this.numberOfOrders = numberOfOrders;
    }
}
package com.driver;

public class Order {

    private String id;
    private int deliveryTime;
    private String partnerId;

    public Order(String id, String deliveryTime, String partnerId) {
        this.id = id;
       // this.deliveryTime = deliveryTime;
        this.partnerId = partnerId;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(int deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public String getPartnerId() {
        return partnerId;
    }

    public void setPartnerId(String partnerId) {
        this.partnerId = partnerId;
    }
}

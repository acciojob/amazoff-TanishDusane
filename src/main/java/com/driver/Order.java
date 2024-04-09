package com.driver;

public class Order {

    private String id;
    private int deliveryTime;
    private String partnerId;


    public Order(String id, String deliveryTime) {
<<<<<<< HEAD

        // The deliveryTime has to converted from string to int and then stored in the attribute
        //deliveryTime  = HH*60 + MM
        this.id = id;

        String[] parts = deliveryTime.split(":");

        // Parse hours and minutes from string to integers
        int hours = Integer.parseInt(parts[0]);
        int minutes = Integer.parseInt(parts[1]);

        // Calculate delivery time in minutes
        this.deliveryTime = hours * 60 + minutes;
=======
        this.id = id;
       // this.deliveryTime = deliveryTime;
>>>>>>> 78fce4f81010609f9eec4f9c6660774f7231c323
    }


    public String getId() {
        return id;
    }

<<<<<<< HEAD
    public int getDeliveryTime() {return deliveryTime;}
}
=======
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
>>>>>>> 78fce4f81010609f9eec4f9c6660774f7231c323

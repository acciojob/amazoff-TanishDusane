
package com.driver;

import java.util.*;
import org.springframework.stereotype.Repository;

@Repository
public class OrderRepository {

    private HashMap<String, Order> orderMap;
    private HashMap<String, DeliveryPartner> partnerMap;
    private HashMap<String, HashSet<String>> partnerToOrderMap;
    private HashMap<String, String> orderToPartnerMap;

    public OrderRepository(){
        this.orderMap = new HashMap<String, Order>();
        this.partnerMap = new HashMap<String, DeliveryPartner>();
        this.partnerToOrderMap = new HashMap<String, HashSet<String>>();
        this.orderToPartnerMap = new HashMap<String, String>();
    }


    public void saveOrder(Order order){
        // your code here
<<<<<<< HEAD
        if (order != null && order.getId() != null) {
            orderMap.put(order.getId(), order);
        }
=======
        orderMap.put(order.getId(), order);
>>>>>>> 78fce4f81010609f9eec4f9c6660774f7231c323
    }

    public void savePartner(String partnerId){
        // your code here
        // create a new partner with given partnerId and save it
<<<<<<< HEAD
        if (partnerId != null) {
            DeliveryPartner deliveryPartner = new DeliveryPartner(partnerId);
            partnerMap.put(partnerId, deliveryPartner);
=======

        if(!partnerMap.containsKey(partnerId)){
            partnerMap.put(partnerId,null);
>>>>>>> 78fce4f81010609f9eec4f9c6660774f7231c323
        }
    }

    public void saveOrderPartnerMap(String orderId, String partnerId){
        if(orderMap.containsKey(orderId) && partnerMap.containsKey(partnerId)){
            // your code here
            //add order to given partner's order list
            //increase order count of partner
            //assign partner to this order
<<<<<<< HEAD
            if (orderId != null && partnerId != null) {
                orderToPartnerMap.put(orderId, partnerId);

                DeliveryPartner partner = partnerMap.get(partnerId);
                partnerToOrderMap.computeIfAbsent(partnerId, k -> new HashSet<>()).add(orderId);

                partner.setNumberOfOrders(partner.getNumberOfOrders() + 1);
=======

            if(orderMap.containsKey(partnerId) && partnerMap.containsKey(partnerId)) {
                HashSet<String> orders = partnerToOrderMap.getOrDefault(partnerId, new HashSet<>());
                orders.add(orderId);
                orderToPartnerMap.put(orderId, partnerId);
>>>>>>> 78fce4f81010609f9eec4f9c6660774f7231c323
            }
        }
    }

    public Order findOrderById(String orderId){
        // your code here
<<<<<<< HEAD
        return orderId != null ? orderMap.get(orderId) : null;
=======
        return orderMap.get(orderId);
>>>>>>> 78fce4f81010609f9eec4f9c6660774f7231c323
    }

    public DeliveryPartner findPartnerById(String partnerId){
        // your code here
<<<<<<< HEAD
        return partnerId != null ? partnerMap.get(partnerId) : null;
=======
        return partnerMap.get(partnerId);
>>>>>>> 78fce4f81010609f9eec4f9c6660774f7231c323
    }

    public Integer findOrderCountByPartnerId(String partnerId){
        // your code here
<<<<<<< HEAD
//        if (partnerToOrderMap.containsKey(partnerId)) {
//            return partnerToOrderMap.get(partnerId).size();
//        }
//        return 0;
        if (partnerId != null && partnerToOrderMap.containsKey(partnerId)) {
            DeliveryPartner deliveryPartner = partnerMap.get(partnerId);
            return deliveryPartner.getNumberOfOrders();
        }
        return 0;
=======

        HashSet<String> orders = partnerToOrderMap.getOrDefault(partnerId, new HashSet<>());
        return orders.size();
>>>>>>> 78fce4f81010609f9eec4f9c6660774f7231c323
    }

    public List<String> findOrdersByPartnerId(String partnerId){
        // your code here
<<<<<<< HEAD
        if (partnerId != null) {
            Set<String> orders = partnerToOrderMap.getOrDefault(partnerId, new HashSet<>());
            return new ArrayList<>(orders);
        }
        return Collections.emptyList();
=======
        HashSet<String> orders = partnerToOrderMap.getOrDefault(partnerId, new HashSet<>());
        return new ArrayList<>(orders);
>>>>>>> 78fce4f81010609f9eec4f9c6660774f7231c323
    }

    public List<String> findAllOrders(){
        // your code here
        // return list of all orders
<<<<<<< HEAD
        List<String> ordersList = new ArrayList<>();
        for (Order order : orderMap.values()) {
            ordersList.add(order.getId());
        }
        return ordersList;
=======
        List<String> allOrders = new ArrayList<>();
        for (Order order : orderMap.values()) {
            allOrders.add(order.getId());
        }
        return allOrders;
>>>>>>> 78fce4f81010609f9eec4f9c6660774f7231c323
    }

//    public void deletePartner(String partnerId){
//        // your code here
//        // delete partner by ID
//
//        if(partnerId != null){
//            partnerMap.remove(partnerId);
//
//            orderToPartnerMap.values().removeIf(id -> id.equals(partnerId));
//
//            partnerToOrderMap.remove(partnerId);
//        }
//    }

    public void deletePartner(String partnerId){
        // your code here
        // delete partner by ID
        if (partnerId != null && partnerMap.containsKey(partnerId)) {
            partnerMap.remove(partnerId);
            Set<String> assignedOrders = partnerToOrderMap.remove(partnerId);
            if (assignedOrders != null) {
                for (String orderId : assignedOrders) {
                    orderToPartnerMap.remove(orderId);
                }
            }
        }
    }

    public void deleteOrder(String orderId){
        // your code here
        // delete order by ID
<<<<<<< HEAD
        if (orderId != null && orderMap.containsKey(orderId)) {
            String partnerId = orderToPartnerMap.remove(orderId);
            if (partnerId != null && partnerToOrderMap.containsKey(partnerId)) {
                partnerToOrderMap.get(partnerId).remove(orderId);
                DeliveryPartner partner = partnerMap.get(partnerId);
                if (partner != null) {
                    partner.setNumberOfOrders(partner.getNumberOfOrders() - 1);
                }
            }
            orderMap.remove(orderId);
        }
=======

        orderMap.remove(orderId);

        orderToPartnerMap.remove(orderId);

        partnerToOrderMap.forEach((partnerId,orderIds) -> orderIds.remove(orderId));
>>>>>>> 78fce4f81010609f9eec4f9c6660774f7231c323
    }

    public Integer findCountOfUnassignedOrders(){
        // your code here
<<<<<<< HEAD
        int unassignedCount = 0;
        for (String orderId : orderMap.keySet()) {
            if (orderToPartnerMap.get(orderId) == null) {
                unassignedCount++;
            }
        }
        return unassignedCount;
=======
        int unassignedOrderCount = 0;

        for(Order order : orderMap.values()){
            if(order.getPartnerId() == null || order.getPartnerId().isEmpty()) {
                unassignedOrderCount++;
            }
        }
        return unassignedOrderCount;
>>>>>>> 78fce4f81010609f9eec4f9c6660774f7231c323
    }

    public Integer findOrdersLeftAfterGivenTimeByPartnerId(String timeString, String partnerId){
        // your code here
<<<<<<< HEAD
        int ordersLeft = 0;
        String[] timeParts = timeString.split(":");
        if (timeParts.length == 2) {
            int givenTime = Integer.parseInt(timeParts[0]) * 60 + Integer.parseInt(timeParts[1]);
            Set<String> partnerOrders = partnerToOrderMap.getOrDefault(partnerId, new HashSet<>());
            for (String orderId : partnerOrders) {
                Order order = orderMap.get(orderId);
                if (order != null && order.getDeliveryTime() > givenTime) {
                    ordersLeft++;
                }
            }
        }
        return ordersLeft;
=======
        String[] timeparts = timeString.split(":");
        int givenHours = Integer.parseInt(timeparts[0]);
        int givenMinutes = Integer.parseInt(timeparts[1]);

        int count = 0;

        for(String orderId : partnerToOrderMap.getOrDefault(partnerId, new HashSet<>())){
            Order order = orderMap.get(orderId);
            if(order != null && order.getDeliveryTime() > (givenHours * 60 + givenMinutes)){
                count++;
            }
        }
        return count;
>>>>>>> 78fce4f81010609f9eec4f9c6660774f7231c323
    }

    public String findLastDeliveryTimeByPartnerId(String partnerId){
        // your code here
        // code should return string in format HH:MM
<<<<<<< HEAD
        int latestTime = Integer.MIN_VALUE;
        String lastDeliveryTime = "";
        int time = 0;
        Set<String> partnerOrders = partnerToOrderMap.getOrDefault(partnerId, new HashSet<>());
        for (String orderId : partnerOrders) {
            Order order = orderMap.get(orderId);
            if (order != null && order.getDeliveryTime() > latestTime) {
                latestTime = order.getDeliveryTime();
                time = order.getDeliveryTime();
            }
        }
        int hours = time / 60;
        int minutes = time % 60;
        lastDeliveryTime = String.format("%02d:%02d", hours, minutes);
=======
        String lastDeliveryTime = null;

        for (String orderId : partnerToOrderMap.getOrDefault(partnerId, new HashSet<>())) {
            Order order = orderMap.get(orderId);
            if (order != null && (lastDeliveryTime == null || order.getDeliveryTime() > Integer.parseInt(lastDeliveryTime))) {
                lastDeliveryTime = String.valueOf(order.getDeliveryTime());
            }
        }
>>>>>>> 78fce4f81010609f9eec4f9c6660774f7231c323
        return lastDeliveryTime;
    }
}
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
        orderMap.put(order.getId(), order);
    }

    public void savePartner(String partnerId){
        // your code here
        // create a new partner with given partnerId and save it

        if(!partnerMap.containsKey(partnerId)){
            partnerMap.put(partnerId,null);
        }
    }

    public void saveOrderPartnerMap(String orderId, String partnerId){
        if(orderMap.containsKey(orderId) && partnerMap.containsKey(partnerId)){
            // your code here
            //add order to given partner's order list
            //increase order count of partner
            //assign partner to this order

            if(orderMap.containsKey(partnerId) && partnerMap.containsKey(partnerId)) {
                HashSet<String> orders = partnerToOrderMap.getOrDefault(partnerId, new HashSet<>());
                orders.add(orderId);
                orderToPartnerMap.put(orderId, partnerId);
            }
        }
    }

    public Order findOrderById(String orderId){
        // your code here
        return orderMap.get(orderId);
    }

    public DeliveryPartner findPartnerById(String partnerId){
        // your code here
        return partnerMap.get(partnerId);
    }

    public Integer findOrderCountByPartnerId(String partnerId){
        // your code here

        HashSet<String> orders = partnerToOrderMap.getOrDefault(partnerId, new HashSet<>());
        return orders.size();
    }

    public List<String> findOrdersByPartnerId(String partnerId){
        // your code here
        HashSet<String> orders = partnerToOrderMap.getOrDefault(partnerId, new HashSet<>());
        return new ArrayList<>(orders);
    }

    public List<String> findAllOrders(){
        // your code here
        // return list of all orders
        List<String> allOrders = new ArrayList<>();
        for (Order order : orderMap.values()) {
            allOrders.add(order.getId());
        }
        return allOrders;
    }

    public void deletePartner(String partnerId){
        // your code here
        // delete partner by ID

        if(partnerId != null){
            partnerMap.remove(partnerId);

            orderToPartnerMap.values().removeIf(id -> id.equals(partnerId));

            partnerToOrderMap.remove(partnerId);
        }
    }

    public void deleteOrder(String orderId){
        // your code here
        // delete order by ID

        orderMap.remove(orderId);

        orderToPartnerMap.remove(orderId);

        partnerToOrderMap.forEach((partnerId,orderIds) -> orderIds.remove(orderId));
    }

    public Integer findCountOfUnassignedOrders(){
        // your code here
        int unassignedOrderCount = 0;

        for(Order order : orderMap.values()){
            if(order.getPartnerId() == null || order.getPartnerId().isEmpty()) {
                unassignedOrderCount++;
            }
        }
        return unassignedOrderCount;
    }

    public Integer findOrdersLeftAfterGivenTimeByPartnerId(String timeString, String partnerId){
        // your code here
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
    }

    public String findLastDeliveryTimeByPartnerId(String partnerId){
        // your code here
        // code should return string in format HH:MM
        String lastDeliveryTime = null;

        for (String orderId : partnerToOrderMap.getOrDefault(partnerId, new HashSet<>())) {
            Order order = orderMap.get(orderId);
            if (order != null && (lastDeliveryTime == null || order.getDeliveryTime() > Integer.parseInt(lastDeliveryTime))) {
                lastDeliveryTime = String.valueOf(order.getDeliveryTime());
            }
        }
        return lastDeliveryTime;
    }
}
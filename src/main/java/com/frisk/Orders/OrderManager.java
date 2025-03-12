package com.frisk.Orders;

import com.frisk.Observer.OrderObserver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderManager {

    private static final Map<Integer, Order> orders = new HashMap<>();
    private static final List<OrderObserver> observers = new ArrayList<>();

    public static void addObserver(OrderObserver observer) {
        observers.add(observer);
    }

    public static void addOrder(Order order) {
        orders.put(order.getOrderId(), order);
        notifyOrderPlaced(order);
    }

    public static Order getOrderById(int orderId) {
        return orders.get(orderId);
    }

    public static void removeOrderById(int orderId) {
        orders.remove(orderId);
    }

    private static void notifyOrderPlaced(Order order) {
        System.out.println(order.getOrderId());
        for (OrderObserver observer : observers) {
            observer.onOrderPlaced(order);
        }
    }

    public static void notifyOrderCompleted(Order order) {
        for (OrderObserver observer : observers) {
            observer.onOrderCompleted(order);
        }
    }

    public static Receipt getReceiptForOrder(Order order) {
        return new Receipt(order);
    }

    public static List<OrderObserver> getObservers() {
        return new ArrayList<>(observers);
    }
}
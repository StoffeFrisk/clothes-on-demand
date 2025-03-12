package com.frisk.Orders;

public class OrderId {

    private static final OrderId instance = new OrderId();
    private static int nextId = 10011001;

    private OrderId() {}

    public static OrderId getInstance() {
        return instance;
    }

    public int generateId() {
        return nextId++;
    }
}

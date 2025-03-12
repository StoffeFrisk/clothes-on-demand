package com.frisk.Orders;

import com.frisk.Observer.OrderObserver;

public class TestObserver implements OrderObserver {
    private boolean notified = false;

    @Override
    public void onOrderPlaced(Order order) {
        System.out.println("✅ TestObserver: onOrderPlaced() anropades för order " + order.getOrderId());
        notified = true;
    }

    @Override
    public void onOrderCompleted(Order order) {
        notified = true;
    }

    public boolean wasNotified() {
        return notified;
    }
}
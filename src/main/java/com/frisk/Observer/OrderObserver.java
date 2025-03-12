package com.frisk.Observer;

import com.frisk.Orders.Order;

public interface OrderObserver {
    void onOrderPlaced(Order order);
    void onOrderCompleted(Order order);
}

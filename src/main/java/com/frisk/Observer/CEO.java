package com.frisk.Observer;

import com.frisk.Orders.Order;
import com.frisk.Orders.OrderManager;
import com.frisk.Orders.Receipt;

public class CEO implements OrderObserver {

    @Override
    public void onOrderPlaced(Order order) {
        System.out.println("CEO: En ny order har lagts! Order-ID: " + order.getOrderId());
        printReceipt(order);
    }

    @Override
    public void onOrderCompleted(Order order) {
        System.out.println("CEO: Order " + order.getOrderId() + " är nu färdigbyggd och klar för leverans!");
    }

    private void printReceipt(Order order) {
        System.out.println("\n===== KVITTO (Kopia till CEO) =====");
        Receipt receipt = OrderManager.getReceiptForOrder(order);
        receipt.printReceipt();
    }
}
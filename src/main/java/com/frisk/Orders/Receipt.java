package com.frisk.Orders;

import com.frisk.BusinessObjects.ClothingItem;

import java.util.List;

public class Receipt {

    private Order order;
    private final double totalPrice;

     Receipt(Order order) {
         this.order = order;
         this.totalPrice = calculateTotalPrice();

    }

    private double calculateTotalPrice() {
         double total = 0;
        List<ClothingItem> items = order.getItems();
        for (ClothingItem item : items) {
            total += item.getPrice();
        }
        return total;
    }

    public void printReceipt() {
        System.out.println("\n===== KVITTO =====");
        System.out.println("Order-ID: " + order.getOrderId());
        System.out.println("Kund: " + order.getCustomer().getName());
        System.out.println("Adress: " + order.getCustomer().getAddress());
        System.out.println("E-post: " + order.getCustomer().getEmail());
        System.out.println("Telefon: " + order.getCustomer().getPhone());
        System.out.println("\nProdukter:");
        for (ClothingItem item : order.getItems()) {
            System.out.println("- " + item.getName() + " (" + item.getSize() + ", " + item.getColour() + ") - " + item.getPrice() + " SEK");
        }
        System.out.println("\nTotalpris: " + totalPrice + " SEK");
        System.out.println("=================\n");
    }
}

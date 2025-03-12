package com.frisk.Orders;

import com.frisk.BusinessObjects.ClothingItem;
import com.frisk.Users.Customer;

import java.util.ArrayList;
import java.util.List;

public class Order {

    private final int orderId;
    private final Customer customer;
    private final List<ClothingItem> items;
    private boolean isPlaced;

    public Order(Customer customer){
        this.orderId = OrderId.getInstance().generateId();
        this.customer = customer;
        this.items = new ArrayList<>();
        this.isPlaced = false;
    }

    public int getOrderId() {
        return orderId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public List<ClothingItem> getItems() {
        return items;
    }

    public void addItem(ClothingItem item){
        items.add(item);
    }

    public void removeItem(ClothingItem item){
        items.remove(item);
    }

    public void placeOrder(){
        if(items.isEmpty()){
            System.out.println("Inga varor i varukorgen!");
            return;
        }
        isPlaced = true;
        System.out.println("Order lagd. Ordernummer är: " + orderId);
    }

    public boolean isPlaced() {
        return isPlaced;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", customer=" + customer +
                ", items=" + items +
                ", isPlaced=" + isPlaced +
                '}';
    }
}

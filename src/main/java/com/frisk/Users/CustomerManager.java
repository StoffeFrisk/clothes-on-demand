package com.frisk.Users;

import java.util.HashMap;
import java.util.Map;

public class CustomerManager {

    private static final Map<Integer, Customer> customers = new HashMap<>();

    public static void addCustomer(Customer customer) {
        customers.put(customer.getCustomerId(),customer);
    }

    public static Customer getCustomerById(int customerId) {
        return customers.get(customerId);
    }

    public static void removeCustomerById(int customerId) {
        customers.remove(customerId);
    }

}

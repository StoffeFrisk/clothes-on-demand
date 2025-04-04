package com.frisk.Orders;

import com.frisk.Observer.CEO;
import com.frisk.Observer.OrderObserver;
import com.frisk.Users.Customer;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class OrderManagerTest {


    @Test
    public void testAddOrder() {
        Customer customer = new Customer("test", "test", "test", "test");
        Order order = new Order(customer);

        OrderManager.addOrder(order);
        assertNotNull(OrderManager.getOrderById(order.getOrderId()));
    }

    @Test
    public void testGetOrderByid(){
        Customer customer = new Customer("test", "test", "test", "test");
        Order order = new Order(customer);

        OrderManager.addOrder(order);
        Order takeOrder = OrderManager.getOrderById(order.getOrderId());

        assertNotNull(takeOrder);
        assertEquals(order, takeOrder);
    }

    @Test
    public void testRemoveOrderById() {
        Customer customer = new Customer("test", "test", "test", "test");
        Order order = new Order(customer);

        OrderManager.addOrder(order);
        OrderManager.removeOrderById(order.getOrderId());

        assertNull(OrderManager.getOrderById(order.getOrderId()));
    }

    @Test
    public void testGetReceiptForOrder() {
        Customer customer = new Customer("test", "test", "test", "test");
        Order order = new Order(customer);
        OrderManager.addOrder(order);

        Receipt receipt = OrderManager.getReceiptForOrder(order);
        assertNotNull(receipt);
    }

    @Test
    public void testAddObserver() {
        OrderObserver ceo = new CEO();
        OrderManager.addObserver(ceo);

        assertTrue(OrderManager.getObservers().contains(ceo));
    }

    @Test
    public void testNotifyOrderCompleted() {
        Customer customer = new Customer("test", "test", "test", "test");
        Order order = new Order(customer);

        OrderObserver observer = mock(OrderObserver.class);
        OrderManager.addObserver(observer);

        OrderManager.notifyOrderCompleted(order);

        verify(observer).onOrderCompleted(order);
    }

    @Test
    public void testNotifyOrderPlaced() {
        Customer customer = new Customer("test", "test", "test", "test");
        Order order = new Order(customer);

        OrderObserver observer = mock(OrderObserver.class);
        OrderManager.addObserver(observer);

        OrderManager.addOrder(order);

        verify(observer).onOrderPlaced(order);
    }
}
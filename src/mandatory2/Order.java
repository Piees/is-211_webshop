/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mandatory2;

import java.util.Stack;
import java.util.concurrent.LinkedBlockingQueue;

/**
 *
 * @author piees
 * Order blir opprettet for en Customer.
 * Man legger deretter til OrderLines med addOrderLine()
 */
public class Order {
    private Customer customer;
    private int orderID;
    private static int orderIDCounter = 0;
    // orderline lista er en nå en LinkedBlockingQueue. Dette er for å motarbeide
    // potensielle overbelastninger som kan skje i systemet. Dette kan skape en
    // flaskehals men er en sted hvor jeg tror kan bli overbelastes i produksjon
    // threading kunne bli brukt for å håndtere overbelasninger med andre
    // strukturer for å fjerne flaskehalsen
    private LinkedBlockingQueue<OrderLine> orderlineList = new LinkedBlockingQueue<>(75);
    
    Order(Customer customer) {
        this.customer = customer;
        orderIDCounter++;
        orderID = orderIDCounter;
    }
    
    public OrderLine createOrderLine(Product productRef, Integer productAmount) {
        OrderLine ol = new OrderLine(productRef, productAmount);
        orderlineList.add(ol);
        return ol;
    }

    public Customer getCustomer() {
        return customer;
    }

    public int getOrderID() {
        return orderID;
    }

    public LinkedBlockingQueue<OrderLine> getOrderlineList() {
        return orderlineList;
    }
    
}

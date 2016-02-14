/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mandatory2;

import java.util.Stack;

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
    // orderline lista er en stack ettersom det ikke har noe å si hvilken
    // rekkefølge det kommer ut så lenge det inneholder alle orderlinsa det skal
    private Stack<OrderLine> orderlineList = new Stack<>();
    
    Order(Customer customer) {
        this.customer = customer;
        orderIDCounter++;
        orderID = orderIDCounter;
    }
    
    public void addOrderLine(OrderLine ol) {
        orderlineList.add(ol);
    }


    public Customer getCustomer() {
        return customer;
    }

    public int getOrderID() {
        return orderID;
    }

    public Stack<OrderLine> getOrderlineList() {
        return orderlineList;
    }
    
}

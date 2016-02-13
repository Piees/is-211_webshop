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
    private int order_id;
    private static int order_id_counter = 0;
    // orderline lista er en stack ettersom det ikke har noe å si hvilken
    // rekkefølge det kommer ut så lenge det inneholder alle orderlinsa det skal
    private Stack<OrderLine> orderline_list = new Stack<>();
    
    private Order(Customer customer) {
        this.customer = customer;
        order_id_counter++;
        order_id = order_id_counter;
    }
    
    public void addOrderLine(OrderLine ol) {
        orderline_list.add(ol);
    }


    public Customer getCustomer() {
        return customer;
    }

    public int getOrder_id() {
        return order_id;
    }

    public Stack<OrderLine> getOrderline_list() {
        return orderline_list;
    }
    
}

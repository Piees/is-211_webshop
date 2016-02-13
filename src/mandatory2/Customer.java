/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mandatory2;

/**
 *
 * @author piees
 * Customer opprettes med et navn og blir tilgitt en auto incremental id
 */
public class Customer {
    private String name;
    private int cust_id;
    static int cust_id_counter = 0;
    
    private Customer(String name) {
        this.name = name;
        cust_id_counter++;
        cust_id = cust_id_counter;
    }

    public String getName() {
        return name;
    }

    public int getCust_id() {
        return cust_id;
    }
}

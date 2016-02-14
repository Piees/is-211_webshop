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
    private int custID;
    static int custIDCounter = 0;
    
    Customer(String name) {
        this.name = name;
        custIDCounter++;
        custID = custIDCounter;
    }

    public String getName() {
        return name;
    }

    public int getCustID() {
        return custID;
    }
}

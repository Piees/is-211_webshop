/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mandatory2;

/**
 *
 * @author piees
 */
public class Mandatory2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Webshop ws = new Webshop();
        Customer customer = ws.createCustomer("Johnny");
        ws.buyRecommendedInventory();
        ws.placeOrder("Fiskestang", customer);
    }
    
}

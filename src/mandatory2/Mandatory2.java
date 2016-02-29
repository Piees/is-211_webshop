/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mandatory2;

/**
 * Holder Main klassen for programmet
 * @author piees
 */
public class Mandatory2 {

    /**
     * Kjører createOrder funksjonen fra en opprettet Webshop med en ny customer
 som kjøper tre "fiskestang". Fiskestang produktet er ikke opprettet med
 tre i inventory så det blir gjort en backorder i addProductToOrder
 og deretter en rekursjon.
 Til slutt kjøper webshop anbefalt inventory for alle produktene, 
 printen blir gjort i createOrder så man ser ikke denne her.
 Data ikke laget her er lage i webshop createDummyData() som blir kjørt
 i webshop sin constructor.
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Webshop ws = new Webshop();
        Customer customer = ws.createCustomer("Johnny");
        Order order = ws.createOrder(customer);
        ws.addProductToOrder(ws.getProductByName("Fiskestang"), 2, order);
        ws.addProductToOrder(ws.getProductByName("Fiskestang"), 5, order);
        ws.placeOrder(order);
        System.out.println("Balance: " + ws.getBalance());
        System.out.println("Fiskestang in stock: " + ws.getProductByName("Fiskestang").getInventory());
        ws.buyRecommendedInventory();
        
    }
    
}

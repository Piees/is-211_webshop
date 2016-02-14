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
        // TODO code application logic here
        Webshop ws = new Webshop();
        System.out.println(ws.getBalance());
        Product product = ws.createProduct("Fiskestang", 20, 10);
        Supplier supplier = ws.createSupplier();
        SupplierProduct sp = supplier.createSupplierProduct(10, product);
        Customer customer = ws.createCustomer("Johnny");
        Order order = ws.createOrder(customer);
        ws.addProductToOrder(product, 3, order);
        ws.completeOrder(order);
        for(OrderLine ol : order.getOrderlineList()) {
            System.out.println(ol.getProductRef().getName());
            System.out.println(ol.getProductAmount());
            System.out.println(ws.getBalance());
            System.out.println(ws.getProductList().get(0).getInventory());
        }
    }
    
}

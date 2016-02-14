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
        Product product = ws.createProduct("Fiskestang", 20, 10);
        Supplier supplier = ws.createSupplier();
        SupplierProduct sp = supplier.createSupplierProduct(10, product);
        Customer customer = ws.createCustomer("Johnny");
        Order order = ws.createOrder(customer);
        ws.addProductToOrder(product, 3, order);
        ws.completeOrder(order);
        ws.buyRecommendedInventory();
        for(OrderLine ol : order.getOrderlineList()) {
            System.out.println("Produkt i order: "
                    + ol.getProductRef().getName());
            System.out.println("Antall produkter i order: "
                    + ol.getProductAmount());
            System.out.println("Webshop balance: "
                    + ws.getBalance());
            System.out.println("Antall av produktet i inventory: "
                    + ws.getProductList().get(0).getInventory());
        }
    }
    
}

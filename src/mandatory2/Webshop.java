/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mandatory2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author piees
 */
public class Webshop {
    // Lista over kunder er ArrayList ettersom den skal kunne få tilgang til 
    // kunder uten å måtte gå igjennom hele lista og den kan legge kunder på
    // på slutten av lista som har en lav stor O verdi
    ArrayList<Customer> customerList = new ArrayList<>();
    // produkt lista er ArrayList ettersom det trengs å akksessere data som
    // ArrayList gjør raskt om den vet index og den har raske inserts bakfra
    // ettersom den gjerne inneholder en del utbyttninger kunne jeg her 
    // vurdert å bruke LinkedList
    ArrayList<Product> productList = new ArrayList<>();
    // supplier lista er ArrayList ettersom det ikke er forventet mange
    // endringer men blir brukt til å søke opp produktene dem supplerer
    LinkedList<Supplier> supplierList = new LinkedList<>();
    // order lista er LinkedList implementert som Queue ettersom vi ønsker å
    // håndtere de eldste ordrene i lista
    Queue<Order> orderList = new LinkedList<>();

    public Webshop() {
    }
    
    /**
     * 
     * @param name 
     */
    public void createCustomer(String name) {
        Customer c = new Customer(name);
        customerList.add(c);
    }
    
    public void createProduct(String name, int price, int recommendedInventory) {
        Product p = new Product(name, price, recommendedInventory);
        productList.add(p);
    }
    
    public void createSupplier() {
        Supplier s = new Supplier();
        supplierList.add(s);
    }
    
    public void createOrder(Customer customer) {
        Order o = new Order(customer);
        orderList.add(o);
    }
    
    public Supplier findCheapestSupplier(Product product) {
        Supplier cheapestSupplier = null;
        for(Supplier supplier : supplierList) {
            for(SupplierProduct sp : supplier.getSupplierProductList())
                if(sp.getProduct() == product) {
                    if(cheapestSupplier == null) {
                        System.out.println("FIIISH!");
                        cheapestSupplier = supplier;
                    }
                    else if(sp.getPrice() < cheapestSupplier.getSupplierProductList().get(cheapestSupplier.getSupplierProductList().indexOf(product)).getPrice()) {
                        System.out.println("oisann");
                        cheapestSupplier = supplier;
                    }
                }
            }
        return cheapestSupplier;
    }
    
    public void placeBackOrder(Product product, int amount) {
        BackOrder backOrder = new BackOrder(this, findCheapestSupplier(product));
    }
    
    // not done, needs placeBackOrder
    public void addProductToOrder(Product product, int amount, Order order) {
        if(product.getInventory() > amount) {
        OrderLine orderLine = new OrderLine(product, amount);
        order.addOrderLine(orderLine);
        }
        else {
            //placeBackOrder goes here
        }
    }
}

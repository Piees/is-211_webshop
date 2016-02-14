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
    // webshop starter med 1000 balanse
    Integer balance = 1000;
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
        createDummyData();
    }
    
    /**
     * 
     * @param name 
     */
    public Customer createCustomer(String name) {
        Customer c = new Customer(name);
        customerList.add(c);
        return c;
    }
    
    public Product createProduct(String name, int price, int recommendedInventory) {
        Product p = new Product(name, price, recommendedInventory);
        productList.add(p);
        return p;
    }
    
    public Supplier createSupplier() {
        Supplier s = new Supplier();
        supplierList.add(s);
        return s;
    }
    
    public Order createOrder(Customer customer) {
        Order o = new Order(customer);
        orderList.add(o);
        return o;
    }
    
    public Supplier findCheapestSupplier(Product product) {
        // holder for billigste supplier
        Supplier cheapestSupplier = null;
        for(Supplier supplier : supplierList) {
            for(SupplierProduct sp : supplier.getSupplierProductList())
                if(sp.getProduct() == product) {
                    // hvis det ikke er satt noe billigste supplier blir første
                    // supplier som matcher valgt som billigst
                    if(cheapestSupplier == null) {
                        cheapestSupplier = supplier;
                    }
                    // om en supplier er allerede funnet blir det en sjekk
                    // på om supplier er billigere enn den som er satt som 
                    // billigst
                    else if(sp.getPrice() < cheapestSupplier
                            .getSupplierProductList()
                            .get(cheapestSupplier.getSupplierProductList()
                                    .indexOf(product)).getPrice()) {
                        cheapestSupplier = supplier;
                    }
                }
            }
        return cheapestSupplier;
    }
    
    public void placeBackOrder(Product product, int amount) {
        BackOrder backOrder = new BackOrder(this, findCheapestSupplier(product));
        SupplierProduct supplierProduct = null;
        for(SupplierProduct sp : backOrder.getSupplier().getSupplierProductList()) {
            if(sp.getProduct() == product) {
                supplierProduct = sp;
            }
        }
        if(supplierProduct != null) {
            BackOrderLine bol = backOrder.createBackOrderLine(supplierProduct, amount);
        }
        else {
            System.err.println("Fant ikke supplierProduct i placeBackOrder");
        }
        for(BackOrderLine bo : backOrder.getBackOrderLineList()) {
            changeBalance(-(amount * bo.getProductRef().getPrice()));
            product.changeInventory(+amount);
        }
    }
    
    public void addProductToOrder(Product product, int amount, Order order) {
        if((product.getInventory() - amount) >= 0) {
            OrderLine orderLine = order.createOrderLine(product, amount);
//        OrderLine orderLine = new OrderLine(product, amount);
//        order.addOrderLine(orderLine);
        }
        else {
            placeBackOrder(product, amount);
            addProductToOrder(product, amount, order);
        }
    }
    
    public void completeOrder(Order o) {
        for(OrderLine ol : o.getOrderlineList()) {
            ol.getProductRef().changeInventory(-ol.getProductAmount());
            this.changeBalance(ol.getProductAmount() * ol.getProductRef().getPrice());
        }
    }
    
    public void buyRecommendedInventory() {
        for(Product p : this.getProductList()) {
            Integer amountNeeded = p.getRecommendedInventory() - p.getInventory();
            if((amountNeeded * p.getPrice()) <= this.getBalance()) {
                p.changeInventory(amountNeeded);
                this.changeBalance(-(amountNeeded * p.getPrice()));
            }
            else {
                System.err.println("har ikke råd til å kjøpe inn anbefalt inventory");
            }
        }
    }

    public Integer getBalance() {
        return balance;
    }

    public void changeBalance(Integer balance) {
        if((this.balance += balance) >= 0) {
            this.balance += balance;
        }
        else {
            System.err.println("Webshop har ikke råd til denne endring i balance");
        }
    }

    public ArrayList<Customer> getCustomerList() {
        return customerList;
    }

    public ArrayList<Product> getProductList() {
        return productList;
    }

    public LinkedList<Supplier> getSupplierList() {
        return supplierList;
    }

    public Queue<Order> getOrderList() {
        return orderList;
    }
    
    public void createDummyData() {
        Product product = this.createProduct("Fiskestang", 20, 10);
        Supplier supplier = this.createSupplier();
        SupplierProduct sp = supplier.createSupplierProduct(10, product);
    }
    
    public void placeOrder(String productName, Customer customer) {
//        Product product = this.createProduct("Fiskestang", 20, 10);
//        Supplier supplier = this.createSupplier();
//        SupplierProduct sp = supplier.createSupplierProduct(10, product);
//        Customer customer = this.createCustomer("Johnny");
        Product product = null;
        for(Product p : productList) {
            if(p.getName() == productName) {
                product = p;
            }
        }
        Order order = this.createOrder(customer);
        if(product != null) {
            this.addProductToOrder(product, 3, order);
        }
        else {
            System.err.println("placeOrder: Fant ikke produkt lik productName");
        }
        this.completeOrder(order);
        for(OrderLine ol : order.getOrderlineList()) {
            System.out.println("Produkt i order: "
                    + ol.getProductRef().getName());
            System.out.println("Antall produkter i order: "
                    + ol.getProductAmount());
            System.out.println("Webshop balance: "
                    + this.getBalance());
            System.out.println("Antall av produktet i inventory: "
                    + this.getProductList().get(0).getInventory());
        }
    }
}

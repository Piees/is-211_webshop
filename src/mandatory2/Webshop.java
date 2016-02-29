/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mandatory2;

import java.util.ArrayDeque;
import java.util.ArrayList;
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
    ArrayList<Supplier> supplierList = new ArrayList<>();
    // order lista er LinkedList implementert som Queue ettersom vi ønsker å
    // håndtere de eldste ordrene i lista
    Queue<Order> orderList = new ArrayDeque<>();

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
    

    
    /**
     * Legger til et produkt til order, om det ikke er nok inventory blir det
     * gjort en placeBackOrder deretter en rekursjon som prøver å legge til
     * produktet på nytt
     * @param product
     * @param amount
     * @param order 
     */
    public void addProductToOrder(Product product, int amount, Order order) {
        if((product.getInventory() - amount) >= 0) {
            OrderLine orderLine = order.createOrderLine(product, amount);
        }
        else {
            Supplier cSupplier = findCheapestSupplier(product);
            BackOrder backOrder = cSupplier.createBackOrder(this);
            SupplierProduct sProduct = null;
            for(SupplierProduct sp : cSupplier.getSupplierProductList()) {
                if(sp.getProduct() == product) {
                    sProduct = sp;
                }
            }
            backOrder.createBackOrderLine(sProduct, amount);
            
            for(BackOrderLine bol : backOrder.getBackOrderLineList()) {
                System.out.println(bol.getProductRef().getPrice());
                System.out.println(bol.getProductAmount().toString());
            }
            
            System.out.println(backOrder.getBackOrderLineList().toString());
            cSupplier.processBackOrders(this);
            addProductToOrder(product, amount, order);
        }
    }
    
    /**
     * Fulfører ordre
     * @param o orderen som fullføres
     */
    public void placeOrder(Order o) {
        for(OrderLine ol : o.getOrderlineList()) {
            ol.getProductRef().changeInventory(-ol.getProductAmount());
            this.changeBalance(ol.getProductAmount() * ol.getProductRef().getPrice());
        }
    }
    
    
    /**
     * sjekke alle Product i productList og kjøper antall som trengs for å oppnå
     * anbefalt inventory
     */
    public void buyRecommendedInventory() {
        for(Product p : this.getProductList()) {
            Integer amountNeeded = p.getRecommendedInventory() - p.getInventory();
            if((amountNeeded * p.getPrice()) <= this.getBalance()) {
                p.changeInventory(amountNeeded);
                this.changeBalance(-(amountNeeded * p.getPrice()));
                System.out.println("################");
                System.out.println("Anbefalt inventory kjøpt:");
                System.out.println(amountNeeded.toString() + " av " + p.getName()
                        + " kjøpt for " + (amountNeeded * p.getPrice()) + " balance");
                System.out.println("Ny balance er: " + this.getBalance());
                System.out.println("################");
            }
            else {
                System.err.println("har ikke råd til å kjøpe inn anbefalt inventory");
            }
        }
    }
    
    /**
     * 
     * @return product by name
     */
    public Product getProductByName(String name) {
        for(Product p : productList) {
            if(p.getName().equals(name)) {
                return p;
            }
        }
        System.err.println("Webshop.getProductByName: could not find product by name.");
        return null;
    }

    public Integer getBalance() {
        return balance;
    }

    public void changeBalance(Integer balance) {
        if((this.balance + balance) >= 0) {
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

    public ArrayList<Supplier> getSupplierList() {
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
}

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
public class Supplier {

    private int supplier_id;
    static int supplierIDCounter = 0;
    // produkt lista er ArrayList ettersom den trenger effektivt å søke igjennom
    // lista for å se hvilke produkter som supplier kan supplere med
    ArrayList<SupplierProduct> supplierProductList = new ArrayList<>();
    // backorder lista er queue ettersom man gjerne vil håndtere backorders i
    // rekkefølgen de kommer inn for å ungå stack effekten hvor det kan ligge
    // noe helt på bunnen å aldri bli backordra ettersom det er FIFO
    Queue<BackOrder> backOrderList = new LinkedList<>();

    public Supplier() {
        supplierIDCounter++;
        supplier_id = supplierIDCounter;
    }

    public ArrayList<SupplierProduct> getSupplierProductList() {
        return supplierProductList;
    }

    public void addSupplierProduct(SupplierProduct sp) {
        supplierProductList.add(sp);
    }
    
    public BackOrder createBackOrder(Webshop webshop) {
        BackOrder bo = new BackOrder(webshop, this);
        backOrderList.add(bo);
        return bo;
    }

    public void processBackOrders(Webshop webshop) {
        for (BackOrder bo : backOrderList) {
            for (BackOrderLine bol : bo.getBackOrderLineList()) {
                webshop.changeBalance(-(bol.getProductAmount() * bol.getProductRef().getPrice()));
                bol.getProductRef().getProduct().changeInventory(bol.getProductAmount());
            }
        }
    }

    /**
     * Utfører en backOrder og gjør endringer i balance og inventory
     *
     * @param product
     * @param amount
     */
    /*    public void placeBackOrder(Webshop webshop, Product product, int amount) {
     BackOrder backOrder = new BackOrder(webshop, webshop.findCheapestSupplier(product));
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
     webshop.changeBalance(-(amount * bo.getProductRef().getPrice()));
     product.changeInventory(+amount);
     }
     }*/
    /**
     * @param price
     * @param product
     * @return SupplierProduct som blir opprettet og lagt til i
     * supplierProductList
     */
    public SupplierProduct createSupplierProduct(int price, Product product) {
        SupplierProduct sp = new SupplierProduct(price, product);
        addSupplierProduct(sp);
        return sp;
    }

    public Queue<BackOrder> getBackOrderList() {
        return backOrderList;
    }

    @Deprecated
    public void addBackOrder(BackOrder bo) {
        backOrderList.add(bo);
    }
}

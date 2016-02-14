/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mandatory2;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author piees
 BackOrder må opprettes med informasjon om webshop og supplier som har
 produktene som skal bestilles. 
 Man legger deretter inn BackOrderLines i backOrderLineList med addBackOrderLine()
 */
public class BackOrder {
    private Webshop webshop;
    // orderline lista er queue ettersom backorders vil helst bli håndtert
    // i kø etter når dem kom inn
    private Queue<BackOrderLine> backOrderLineList = new LinkedList<>();
    private final Supplier supplier;

    public BackOrder(Webshop webshop, Supplier supplier) {
        this.webshop = webshop;
        this.supplier = supplier;
    }
    
    public void addBackOrderLine(BackOrderLine ol) {
        backOrderLineList.add(ol);
    }
    
    public BackOrderLine createBackOrderLine(SupplierProduct productRef, Integer productAmount) {
        BackOrderLine bol = new BackOrderLine(productRef, productAmount);
        this.addBackOrderLine(bol);
        return bol;
    }

    public Webshop getWebshop() {
        return webshop;
    }

    public Queue<BackOrderLine> getBackOrderLineList() {
        return backOrderLineList;
    }

    public Supplier getSupplier() {
        return supplier;
    }
    
}

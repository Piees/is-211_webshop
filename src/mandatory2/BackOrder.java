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
 Man legger deretter inn BackOrderLines i backorderline_list med addBackOrderLine()
 */
public class BackOrder {
    private Webshop webshop;
    // orderline lista er queue ettersom backorders vil helst bli håndtert
    // i kø etter når dem kom inn
    private Queue<BackOrderLine> backorderline_list = new LinkedList<>();
    private final Supplier supplier;

    public BackOrder(Webshop webshop, Supplier supplier) {
        this.webshop = webshop;
        this.supplier = supplier;
    }
    
    public void addBackOrderLine(BackOrderLine ol) {
        backorderline_list.add(ol);
    }

    public Webshop getWebshop() {
        return webshop;
    }

    public Queue<BackOrderLine> getBackorderline_list() {
        return backorderline_list;
    }
    
}

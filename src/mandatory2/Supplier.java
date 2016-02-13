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
    // produkt lista er ArrayList ettersom den trenger effektivt å søke igjennom
    // lista for å se hvilke produkter som supplier kan supplere med
    ArrayList<BackOrderLine> supplier_product_list = new ArrayList<>();
    // backorder lista er queue ettersom man gjerne vil håndtere backorders i
    // rekkefølgen de kommer inn for å ungå stack effekten hvor det kan ligge
    // noe helt på bunnen å aldri bli backordra ettersom det er FIFO
    Queue<BackOrder> backorder_list = new LinkedList<>();
}

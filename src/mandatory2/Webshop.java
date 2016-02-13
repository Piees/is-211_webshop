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
    ArrayList<Customer> customer_list = new ArrayList<>();
    // produkt lista er ArrayList ettersom det trengs å akksessere data som
    // ArrayList gjør raskt om den vet index og den har raske inserts bakfra
    // ettersom den gjerne inneholder en del utbyttninger kunne jeg her 
    // vurdert å bruke LinkedList
    ArrayList<Product> product_list = new ArrayList<>();
    // supplier lista er ArrayList ettersom det ikke er forventet mange
    // endringer men blir brukt til å søke opp produktene dem supplerer
    LinkedList<Supplier> supplier_list = new LinkedList<>();
    // order lista er LinkedList implementert som Queue ettersom vi ønsker å
    // håndtere de eldste ordrene i lista
    Queue<Order> order_list = new LinkedList<>();
    
    
}

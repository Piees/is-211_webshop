/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mandatory2;

/**
 *
 * @author piees
 * SupplierProduct blir laget med en produkt referanse og en produkt pris
 * Denne klassen bruker for å håndtere innkjøpspriser
 */
public class BackOrderLine {
    private SupplierProduct productRef;
    private Integer productAmount;
    
    private BackOrderLine(SupplierProduct productRef, Integer productAmount) {
        this.productRef = productRef;
        this.productAmount = productAmount;
    }
}

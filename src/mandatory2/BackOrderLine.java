/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mandatory2;

/**
 *
 * @author piees
 * SupplierProduct blir laget med en produkt referanse og en produkt amount
 */
public class BackOrderLine {
    private SupplierProduct productRef;
    private Integer productAmount;
    
    BackOrderLine(SupplierProduct productRef, Integer productAmount) {
        this.productRef = productRef;
        this.productAmount = productAmount;
    }

    public SupplierProduct getProductRef() {
        return productRef;
    }

    public void setProductRef(SupplierProduct productRef) {
        this.productRef = productRef;
    }

    public Integer getProductAmount() {
        return productAmount;
    }

    public void setProductAmount(Integer productAmount) {
        this.productAmount = productAmount;
    }
}

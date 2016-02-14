/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mandatory2;

/**
 *
 * @author piees
 * OrderLine blir opprettet med en produkt referanse og et antall
 */
public class OrderLine {
    private Product productRef;
    private Integer productAmount;
    
    OrderLine(Product productRef, Integer productAmount) {
        this.productRef = productRef;
        this.productAmount = productAmount;        
    }

    public Product getProductRef() {
        return productRef;
    }

    public Integer getProductAmount() {
        return productAmount;
    }

    public void setProductRef(Product productRef) {
        this.productRef = productRef;
    }

    public void setProductAmount(Integer productAmount) {
        this.productAmount = productAmount;
    }
}

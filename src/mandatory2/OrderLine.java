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
    private Product product_ref;
    private Integer product_amount;
    
    private OrderLine(Product product_ref, Integer product_amount) {
        this.product_ref = product_ref;
        this.product_amount = product_amount;        
    }

    public Product getProduct_ref() {
        return product_ref;
    }

    public Integer getProduct_amount() {
        return product_amount;
    }

    public void setProduct_ref(Product product_ref) {
        this.product_ref = product_ref;
    }

    public void setProduct_amount(Integer product_amount) {
        this.product_amount = product_amount;
    }
}

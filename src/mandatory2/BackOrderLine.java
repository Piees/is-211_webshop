/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mandatory2;

/**
 *
 * @author piees
 * Supplies_Product blir laget med en produkt referanse og en produkt pris
 * Denne klassen bruker for å håndtere innkjøpspriser
 */
public class BackOrderLine {
    private Product product_ref;
    private Integer product_price;
    private Integer product_amount;
    
    private BackOrderLine(Product product_ref, Integer product_price,
            Integer product_amount) {
        this.product_ref = product_ref;
        this.product_price = product_price;
        this.product_amount = product_amount;
    }

    public Product getProduct_ref() {
        return product_ref;
    }

    public void setProduct_ref(Product product_ref) {
        this.product_ref = product_ref;
    }

    public Integer getProduct_price() {
        return product_price;
    }

    public void setProduct_price(Integer product_price) {
        this.product_price = product_price;
    }

    public Integer getProduct_amount() {
        return product_amount;
    }

    public void setProduct_amount(Integer product_amount) {
        this.product_amount = product_amount;
    }
}

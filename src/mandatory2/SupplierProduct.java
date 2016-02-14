/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mandatory2;

/**
 *
 * @author piees
 SupplierProduct er laget med en pris og produkt.
 Dette er for at suppliers skal kunne sette en innkjøpspris for varer
 */
public class SupplierProduct {
    private int prod_id;
    private int price;
    static private int idCounter = 0;
    private Product product;
    
    SupplierProduct(int price, Product product) {
        this.price = price;
        this.product = product;
        idCounter++;
        prod_id = idCounter;
    }

    public int getProdID() {
        return prod_id;
    }

    public void setProdID(int prod_id) {
        this.prod_id = prod_id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public static int getIdCounter() {
        return idCounter;
    }

    public static void setIdCounter(int idCounter) {
        SupplierProduct.idCounter = idCounter;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}

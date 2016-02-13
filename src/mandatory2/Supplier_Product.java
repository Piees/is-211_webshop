/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mandatory2;

/**
 *
 * @author piees
 * Supplier_Product er laget med en pris og produkt.
 * Dette er for at suppliers skal kunne sette en innkjøpspris for varer
 */
public class Supplier_Product {
    private int prod_id;
    private int price;
    static private int id_counter = 0;
    private Product product;
    
    private Supplier_Product(int price, Product product) {
        this.price = price;
        this.product = product;
        id_counter++;
        prod_id = id_counter;
    }

    public int getProd_id() {
        return prod_id;
    }

    public void setProd_id(int prod_id) {
        this.prod_id = prod_id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public static int getId_counter() {
        return id_counter;
    }

    public static void setId_counter(int id_counter) {
        Supplier_Product.id_counter = id_counter;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mandatory2;

/**
 *
 * @author piees
 * Product blir opprettet med et navn, butikkpris og en anbefalt inventory
 */
public class Product {
    private String name;
    private int prod_id;
    private int store_price;
    private int inventory = 0;
    private int recommended_inventory;
    static private int prod_id_counter = 0;
    
    Product(String name, int price, int recommended_inventory) {
        this.name = name;
        this.store_price = price;
        prod_id_counter++;
        this.prod_id = prod_id_counter;
        this.recommended_inventory = recommended_inventory;
    }

    public String getName() {
        return name;
    }

    public int getProd_id() {
        return prod_id;
    }

    public int getInventory() {
        return inventory;
    }

    public int getStore_price() {
        return store_price;
    }

    public int getRecommended_inventory() {
        return recommended_inventory;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStore_price(int store_price) {
        this.store_price = store_price;
    }

    public void setInventory(int inventory) {
        this.inventory = inventory;
    }

    public void setRecommended_inventory(int recommended_inventory) {
        this.recommended_inventory = recommended_inventory;
    }
    
}
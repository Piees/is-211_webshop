/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mandatory2;

/**
 *
 * @author piees
 * Product blir opprettet med et navn, butikkpris og anbefalt inventory
 */
public class Product {
    private String name;
    private int prod_id;
    private int price;
    private int inventory = 0;
    private int recommendedInventory;
    static private int prodIDCounter = 0;
    
    public Product(String name, int price, int recommendedInventory) {
        this.name = name;
        this.price = price;
        prodIDCounter++;
        this.prod_id = prodIDCounter;
        this.recommendedInventory = recommendedInventory;
    }

    public String getName() {
        return name;
    }

    public int getProd_id() {
        return prod_id;
    }

    public int getPrice() {
        return price;
    }

    public int getInventory() {
        return inventory;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setInventory(int inventory) {
        this.inventory = inventory;
    }
    
    public void changeInventory(int amount) {
        inventory += amount;
    }

    public int getRecommendedInventory() {
        return recommendedInventory;
    }

    public void setRecommendedInventory(int recommendedInventory) {
        this.recommendedInventory = recommendedInventory;
    }
    
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mandatory2;

/**
 *
 * @author piees
 */
public class Supplier_Product extends Product {
    private String name;
    private int prod_id;
    private int store_price;
    private int inventory = 0;
    private int recommended_inventory;
    static private int prod_id_counter = 0;
    
    private Supplier_Product(String name, int price) {
        super(name, price);
    }

    @Override
    public void setRecommended_inventory(int recommended_inventory) {
        super.setRecommended_inventory(recommended_inventory); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setInventory(int inventory) {
        super.setInventory(inventory); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setStore_price(int store_price) {
        super.setStore_price(store_price); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setName(String name) {
        super.setName(name); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getRecommended_inventory() {
        return super.getRecommended_inventory(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getStore_price() {
        return super.getStore_price(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getInventory() {
        return super.getInventory(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getProd_id() {
        return super.getProd_id(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getName() {
        return super.getName(); //To change body of generated methods, choose Tools | Templates.
    }
    
}

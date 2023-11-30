package com.shoppingcart.model;
 
public class Cart extends Product {
    private int quantity;
    private String image;
    
    public Cart() {
    }
 
    public int getQuantity() {
        return quantity;
    }
 
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
 
    public String getImage() {
        return this.image;
    }
 
    public void setImage(String image) {
        this.image = image;
    }
}
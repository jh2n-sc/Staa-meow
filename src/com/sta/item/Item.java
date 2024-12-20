package com.sta.item;
import com.google.gson.annotations.Expose;
public class Item {

    @Expose private String category;
    @Expose private String description;
    @Expose private String itemID;
    @Expose private int stock;

    public Item(String category, String description, String itemID, int stock) {
        this.category = category;
        this.description = description;
        this.itemID = itemID;
        this.stock = stock;
    }

    public String getCategory() {
        return category;
    }

    public String getDescription() {
        return description;
    }

    public String getItemID() {
        return itemID;
    }

    public int getStock() {
        return stock;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setItemID(String itemID) {
        this.itemID = itemID;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "itemID: " + itemID + ", category: " + category + ", description: " + description + ", stock: " + stock;
    }
}

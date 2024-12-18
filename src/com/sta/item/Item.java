package com.sta.item;

public class Item {
    private String category;
    private String description;
    private String itemID;
    private int stock;

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

    @Override
    public String toString() {

        String tmp = "Category: " + category + ", Description: " + description + ", ItemID: " + itemID + ", " +
                "Stock: " + stock;
        return tmp;
    }
}

package com.sta;


import item.Item;

import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {
        ArrayList<Item> items = new ArrayList<>();

        for(int i = 0; i < 5; i++) {
            items.add(new Item().withName("hello" + i)
            .withPrice(i * 10)
                    .withPrice(i * 20));
        }

        for (Item item : items) {
            System.out.println(item);
        }
    }
}

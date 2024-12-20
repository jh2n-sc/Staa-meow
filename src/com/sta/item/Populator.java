package com.sta.item;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class Populator {
    public String jsonFilePath;
    public Populator(String jsonFilePath) {
        this.jsonFilePath = jsonFilePath;
        System.out.println("hello");
    }

    public ArrayList<Item> repopulate() {
        ArrayList<Item> itemList = new ArrayList<>();
        Gson gson = new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation()
                .create();
        System.out.println("hello142412");

        try (BufferedReader br = new BufferedReader(new FileReader("res/database/data.json"))) {
            Type listType = new TypeToken<ArrayList<Item>>() {}.getType();

            StringBuilder stringBuilder = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                stringBuilder.append(line);
            }

            String jsonString = stringBuilder.toString();
            itemList = gson.fromJson(jsonString, listType);
            for (Item item : itemList) {
                System.out.println(item);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return itemList;
    }

    public void writeItBack(ArrayList<Item> parentObjects) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (InputStream is = getClass().getResourceAsStream(jsonFilePath)) {
            BufferedWriter writer = new BufferedWriter(new FileWriter("res/database/data.json", false));
            BufferedWriter br = new BufferedWriter(new BufferedWriter(writer));
            String json = gson.toJson(parentObjects);
            writer.write(json);
            System.out.println(json);
            br.flush();
            br.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

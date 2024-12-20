package com.sta.item;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class Populator {
    public String jsonFilePath;
    public Populator(String jsonFilePath) {
        this.jsonFilePath = jsonFilePath;
        System.out.println("hello");
    }

    public ArrayList<Item> repopulate() {
        ArrayList<Item> parentObjects = new ArrayList<>();
        Gson gson = new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation()
                .create();

        try (InputStream is = getClass().getResourceAsStream(jsonFilePath)) {
            assert is != null;
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            Type listType = new TypeToken<ArrayList<Item>>() {}.getType();

             parentObjects = gson.fromJson(br, listType);
            for (Item parentObject : parentObjects) {
                System.out.println(parentObject.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return parentObjects;
    }

    public void writeItBack(ArrayList<Item> parentObjects) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (FileWriter writer = new FileWriter("output.json")) {
            // Write the ArrayList to a JSON file
            gson.toJson(parentObjects, writer);
            System.out.println("ArrayList has been written to output.json");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

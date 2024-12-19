package com.sta;

import javafx.scene.Scene;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class AdminStaMeowController {
    private Scene scene;


        //ArrayList<String> fileContents = readFile();

        // Replace with your file path
        String filePath = "example.txt";

        // Placeholder values, change as needed
        boolean buttonisclicked = false;


}

       /* Print values to CLI, but should be in gui change as needed
        if (buttonisclicked) {
            if (fileContents != null) {
                for (String line : fileContents) {
                    System.out.println(line);

                }
            }
        }*/


    /*public void readFile() {
        ArrayList<String>

        //placeholder values, change as needed
        String textfield = new String("hi");

        ArrayList<String> lines = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.equals(textfield)) {
                    lines.add(line);
                }
            }
        } catch (IOException e) {
            System.err.println("An error occurred while reading the file: " + e.getMessage());
            return null;
        }
        return lines;
    }*/



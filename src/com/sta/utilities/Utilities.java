package com.sta.utilities;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Utilities {

    //jn: copy paste
    public static void switchScene(String fxmlPath, String title, ActionEvent event) {
        try {
            // Load the specified scene
            FXMLLoader loader = new FXMLLoader(Utilities.class.getResource(fxmlPath));
            Parent root = loader.load();

            // Get the current stage and set the new scene
            Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle(title);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

package com.sta;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.Parent;

import java.io.IOException;

public class LogInController {

    @FXML
    private PasswordField password;

    @FXML
    private TextField username;

    @FXML
    void keepMeLoggedIn(ActionEvent event) {

    }

    @FXML
    public void onBtnClickLogIn(ActionEvent event) {

        String name = username.getText().trim();
        String password = this.password.getText().trim();


        //log in flag for empty username field
        //maybe i could make the error msg more apparent pero this will do for now
        if (name.isEmpty()) {
            username.setPromptText("Name is required!");
            return;

        }

        //log in flag for empty password field
        if (password.isEmpty()) {
            this.password.setPromptText("Password is required!");
            return;
        }

        //checks if admin or regular user
        //NOTE!!!!!
        //madagdag pa other conditionals such as checking whether input credentials match pre-existing ones in the
        //(currently non-existent) database.

        if(name.equals("admin") && password.equals("adminpassword1234")) {
            switchScene("/fxml/adminstameow.fxml", "StaMeow Admin", event);
        } else {
            switchScene("/fxml/userstameow.fxml", "StaMeow User", event);
        }



    }

    //util function to switch scenes
    //pwede siguro 'to ilagay in a separate utility package para magamit throughout the program
    private void switchScene(String fxmlPath, String title, ActionEvent event) {
        try {
            // Load the specified scene
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
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


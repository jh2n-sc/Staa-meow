package com.sta;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.Parent;

import java.io.IOException;
import com.sta.utilities.Utilities;
public class LogInController {

    @FXML
    private PasswordField passwordField;

    @FXML
    private TextField usernameField;

    @FXML
    void keepMeLoggedIn(ActionEvent event) {

    }

    @FXML
    public void onBtnClickLogIn(ActionEvent event) {

        String name = usernameField.getText().trim();
        String password = passwordField.getText().trim();
        boolean notLogin = false;


        passwordField.setStyle("-fx-border-color: default; -fx-prompt-text-fill: default;");
        usernameField.setStyle("-fx-border-color: default; -fx-prompt-text-fill: default;");
        //jn: reset node styles for every clicks
        //log in flag for empty username field
        //maybe i could make the error msg more apparent pero this will do for now

        if (name.isEmpty()) {
            usernameField.setStyle("-fx-border-color: red; -fx-prompt-text-fill: rgba(255,0,0,0.38);");
            usernameField.setPromptText("Name is required!");
            notLogin = true;

        }

        //log in flag for empty password field
        if (password.isEmpty()) {
            passwordField.setStyle("-fx-border-color: red; -fx-prompt-text-fill: rgba(255,0,0,0.38);");
            passwordField.setPromptText("Password is required!");
            notLogin = true;
        }

        if (notLogin) {
            return;
        }

        //checks if admin or regular user
        //NOTE!!!!!
        //madagdag pa other conditionals such as checking whether input credentials match pre-existing ones in the
        //(currently non-existent) database.

        if(name.equals("admin") && password.equals("adminpassword1234")) {
            Utilities.switchScene("/fxml/adminstameow.fxml", "StaMeow Admin", event);
        } else {
            Utilities.switchScene("/fxml/userstameow.fxml", "StaMeow User", event);
        }


        System.out.println("username: " + name + " password: " + password);
    }

    //jn: done/relocated to com.sta.utilities.utilites
    //util function to switch scenes
    //pwede siguro 'to ilagay in a separate utility package para magamit throughout the program


}


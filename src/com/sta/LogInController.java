package com.sta;

import javafx.event.ActionEvent;
import javafx.scene.input.MouseEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import com.sta.utility.Utility;

public class LogInController {

    @FXML
    private PasswordField passwordField;

    @FXML
    private TextField usernameField;

    @FXML
    public void onBtnClickLogIn(ActionEvent event) {

        String name = usernameField.getText().trim();
        String password = passwordField.getText().trim();
        boolean notLogin = false;


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
            Utility.switchScene("/fxml/adminstameow.fxml", "StaMeow Admin", event);
        } else {
            Utility.switchScene("/fxml/userstameow.fxml", "StaMeow User", event);
        }


        System.out.println("username: " + name + " password: " + password);
    }

    @FXML
    void createAccountClicked(MouseEvent event) {
        Utility.switchScene("/fxml/signin.fxml", "StaMeow Sign In", event);
    }

}


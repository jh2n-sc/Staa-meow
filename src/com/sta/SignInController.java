package com.sta;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import com.sta.utility.Utility;

public class SignInController {

    @FXML
    private PasswordField confirmPasswordField;

    @FXML
    private TextField firstNameField;

    @FXML
    private TextField lastNameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    void haveAnAccountClicked(MouseEvent event) { //user already has an account
        Utility.switchScene("/fxml/main.fxml", "StaMeow Log In", event);
    }

    @FXML
    void onBtnClickSignIn(ActionEvent event) {
        
    }

}
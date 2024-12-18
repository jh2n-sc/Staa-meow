package com.sta;

import com.sta.account.Account;
import com.sta.account.Admin;
import com.sta.account.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import com.sta.utility.Utility;
import com.sta.account.AccountHandler;
public class SignInController {
    AccountHandler accountHandler = new AccountHandler();

    @FXML
    private PasswordField confirmPasswordField;

    @FXML
    private TextField firstNameField;

    @FXML
    private TextField lastNameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private CheckBox isAdminCheckBox;

    @FXML
    void haveAnAccountClicked(MouseEvent event) { //user already has an account
        Utility.switchScene("/fxml/main.fxml", "StaMeow Log In", event);
    }

    @FXML
    void onBtnClickSignIn(ActionEvent event) {
        Account account;
        if (isAdminCheckBox.isSelected()) {
            account = new Admin(firstNameField.getText() + lastNameField.getText(), passwordField.getText());
        } else {
            account = new User(firstNameField.getText() + lastNameField.getText(), passwordField.getText());
        }
        accountHandler.makeNewAccount(account);
        accountHandler.readAccounts();
    }

}
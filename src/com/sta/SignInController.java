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
import javafx.scene.text.Text;

public class SignInController {
    AccountHandler accountHandler = new AccountHandler();
    @FXML
    private Text loginStatus;

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
        loginStatus.setVisible(false);

        Account account;
        if (isAdminCheckBox.isSelected()) {
            account = new Admin(firstNameField.getText() + lastNameField.getText(), passwordField.getText());
        } else {
            account = new User(firstNameField.getText() + lastNameField.getText(), passwordField.getText());
        }

        if (!confirmPasswordField.getText().equals(passwordField.getText())) {
            loginStatus.setVisible(true);
            loginStatus.setText("Passwords do not match");
            passwordField.setStyle("-fx-border-color: red; -fx-prompt-text-fill: rgba(255,0,0,0.38);");
            return;
        }

        if(!accountHandler.makeNewAccount(account)) {
            loginStatus.setVisible(true);
            loginStatus.setText("Username is already taken!");
            return;
        }

        Utility.switchScene("/fxml/signupsuccess.fxml", "Account Created Successfully", event);


        accountHandler.readAccounts();
    }

    @FXML
    public void initialize() {
        loginStatus.setVisible(false);
    }

}
package com.sta;

import com.sta.account.AccountHandler;
import javafx.event.ActionEvent;
import javafx.scene.input.MouseEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import com.sta.utility.Utility;
import com.sta.account.Account;
import javafx.scene.text.Text;

public class LogInController {

    AccountHandler accountHandler;

    @FXML
    private PasswordField passwordField;

    @FXML
    private TextField usernameField;

    @FXML
    private Text loginStatus;

    @FXML
    public void onBtnClickLogIn(ActionEvent event) {
        loginStatus.setVisible(false);
        loginStatus.managedProperty().bind(loginStatus.visibleProperty());


        accountHandler = new AccountHandler();

        String name = usernameField.getText().trim();
        String password = passwordField.getText().trim();
        boolean notLogin = false;

        //jn: fixed the style bug
        usernameField.setStyle("");
        passwordField.setStyle("");

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

        // creates new Account object to be compared to every accounts inside
        // the accountHandler
        Account account = new Account(name, password);
        Account retrievedAccount = accountHandler
                .retrieveAccount(account);

        AccountHandler.setCurrentAccount(retrievedAccount);

        //checks if admin or regular user
        //NOTE!!!!!
        //madagdag pa other conditionals such as checking whether input credentials match pre-existing ones in the
        //(currently existent) database.

        // if it is null, it means that the account doesnt exist
        if (retrievedAccount == null) {
            passwordField.setStyle("-fx-border-color: red; -fx-prompt-text-fill: rgba(255,0,0,0.38);");
            usernameField.setStyle("-fx-border-color: red; -fx-prompt-text-fill: rgba(255,0,0,0.38);");
            loginStatus.setVisible(true);
            loginStatus.setText("Login Error");
            return;
        }

        // it then checks whether that account is an admin or user
        assert retrievedAccount != null;
        if(retrievedAccount.toString().contains("Admin")) {
            Utility.switchScene("/fxml/adminstameow.fxml", "StaMeow Admin", event);
        }else {
            Utility.switchScene("/fxml/userstameow.fxml", "StaMeow User", event);
        }


        System.out.println("username: " + name + " password: " + password);
    }

    @FXML
    void createAccountClicked(MouseEvent event) {
        Utility.switchScene("/fxml/signin.fxml", "StaMeow Sign In", event);
    }

}


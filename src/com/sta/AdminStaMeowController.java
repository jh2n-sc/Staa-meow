package com.sta;

import com.sta.account.AccountHandler;
import javafx.fxml.FXML;
import javafx.scene.text.Text;


import javafx.scene.Scene;

public class AdminStaMeowController {
    @FXML
    private Text username;
    private String user = AccountHandler.getCurrentAccount().getUsername();

    @FXML
    public void initialize() {
        username.setText("ADMIN | Username: " +  user);
    }
}

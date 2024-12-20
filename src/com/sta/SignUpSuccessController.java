package com.sta;

import com.sta.utility.Utility;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class SignUpSuccessController {

    @FXML
    public void onOKClicked(ActionEvent actionEvent) {
        Utility.switchScene("/fxml/main.fxml", "Sta Meow Login", actionEvent);
    }
}

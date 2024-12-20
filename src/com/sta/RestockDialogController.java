package com.sta;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextFormatter;
import javafx.stage.Stage;
import javafx.util.converter.IntegerStringConverter;
import org.w3c.dom.Text;

public class RestockDialogController {

    private Stage stage;
    @FXML
    private Spinner<Integer> spinnerStock;

    @FXML private Text title12;

    @FXML
    void onCancelBtnClicked(ActionEvent event) {
        closeDialog(event);
    }

    @FXML
    void onRestockBtnClicked(ActionEvent event) {
        int prev = AdminStaMeowController.selectedItem.getStock();
        int curr = spinnerStock.getValue();

        AdminStaMeowController.selectedItem.setStock(prev + curr);
        AdminStaMeowController.reload();
        closeDialog(event);
    }
    @FXML
    private void initialize() {
        Platform.runLater(()-> {
            spinnerStock.setEditable(true);
            TextFormatter<Integer> textFormatter = new TextFormatter<>(new IntegerStringConverter(), 1, c -> {
                // Only allow digits and backspace
                return (c.getControlNewText().matches("^[0-9]*$")) ? c : null;
            });
            spinnerStock.getEditor().setTextFormatter(textFormatter);
            stage = (Stage) spinnerStock.getScene().getWindow();
        });

    }
    private void closeDialog(ActionEvent event) {
        stage.close();
    }

}

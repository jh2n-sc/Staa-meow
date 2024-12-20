package com.sta;

import com.sta.item.Item;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.stage.Stage;
import javafx.util.converter.IntegerStringConverter;

public class EditDialogController {

    private Stage stage;

    @FXML
    private Spinner<Integer> spinnerStock;

    @FXML
    private TextField categoryField;

    @FXML
    private TextField descriptionField;

    @FXML
    private TextField itemID;



    @FXML
    void onCancelBtnClicked(ActionEvent event) {
        closeDialog(event);
    }

    @FXML
    void onEditBtnClicked(ActionEvent event) {

        if (categoryField.getText().isEmpty() || descriptionField.getText().isEmpty() || itemID.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Empty Fields!");
            alert.show();
            return;
        }



        AdminStaMeowController.selectedItem.setStock(spinnerStock.getValue());

        AdminStaMeowController.selectedItem.setDescription(descriptionField.getText());

        AdminStaMeowController.selectedItem.setCategory(categoryField.getText());

        AdminStaMeowController.selectedItem.setItemID(itemID.getText());

        AdminStaMeowController.reload();
        closeDialog(event);

    }

    private void closeDialog(ActionEvent event) {
        stage.close();
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
            stage = (Stage) categoryField.getScene().getWindow();
            categoryField.setText(AdminStaMeowController.selectedItem.getCategory());
            descriptionField.setText(AdminStaMeowController.selectedItem.getDescription());
            itemID.setText(AdminStaMeowController.selectedItem.getItemID());
        });

    }

}

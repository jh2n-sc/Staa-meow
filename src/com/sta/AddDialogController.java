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

public class AddDialogController {
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
        private TextField stockField;

        @FXML
        void onAddBtnClicked(ActionEvent event) {
            if (categoryField.getText().isEmpty() || descriptionField.getText().isEmpty() || itemID.getText().isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Empty Fields!");
                alert.show();
                return;
            }


            Item newItem = new Item(categoryField.getText(),
                    descriptionField.getText(),
                    itemID.getText(),
                    spinnerStock.getValue());

            if (AdminStaMeowController.checkItemExist(newItem)) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Duplicate Item!");
                alert.show();
                return;
            }
            AdminStaMeowController.addItem(newItem);
            closeDialog(event);
        }

        @FXML
        void onCancelBtnClicked(ActionEvent event) {
            assert categoryField != null;
            stage.close();
        }

        private boolean canConvertToInt(String string) {
            try {
                Integer.parseInt(string);
                return true;
            } catch (NumberFormatException e) {
                return false;
            }
        }

        public void addItem(ActionEvent event, Item newItem) {
            AdminStaMeowController.addItem(newItem);
            stage.close();
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
            });

        }

}

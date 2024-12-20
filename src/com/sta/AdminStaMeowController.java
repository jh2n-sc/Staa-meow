package com.sta;

import com.sta.account.AccountHandler;
import com.sta.item.Item;
import com.sta.item.Populator;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;

import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import javafx.beans.value.ObservableValue;
import javafx.beans.value.ChangeListener;

public class AdminStaMeowController {

    @FXML private TableView<Item> table;
    @FXML private TableColumn<Item,String> category;
    @FXML private TableColumn<Item,String> description;
    @FXML private TableColumn<Item,String> itemID;
    @FXML private TableColumn<Item,Integer> stock;
    @FXML private Button editItemBtn;
    @FXML private Button restockItemBtn;
    @FXML private Button deleteItemBtn;

    static Item selectedItem;

    static Populator populator = new Populator("/database/data.json");
    static ArrayList<Item> items = populator.repopulate();
    static ObservableList<Item> arrayList;

    @FXML private TextField searchField;

    @FXML
    private Text username;
    private String user = AccountHandler.getCurrentAccount().getUsername();

    @FXML
    private Parent root;

    @FXML
    public void initialize() {
        username.setText("ADMIN | Username: " +  user);

        //nameColumn
        itemID.setCellValueFactory(new PropertyValueFactory<>("itemID"));

        //allegianceColumn
        category.setCellValueFactory(new PropertyValueFactory<>("category"));

        //positionColumn
        stock.setCellValueFactory(new PropertyValueFactory<>("stock"));

        //salaryColumn
        description.setCellValueFactory(new PropertyValueFactory<>("description"));

        //table = new TableView<>();
        table.setItems(getItems());

        table.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Item>() {
            @Override
            public void changed(ObservableValue<? extends Item> observable, Item oldValue, Item newValue) {
                if (newValue != null) {
                    editItemBtn.setDisable(false);
                    restockItemBtn.setDisable(false);
                    deleteItemBtn.setDisable(false);

                    // A row is selected, show alert with the selected person's details
                    AdminStaMeowController.selectedItem = newValue;

                } else {
                    editItemBtn.setDisable(true);
                    restockItemBtn.setDisable(true);
                    deleteItemBtn.setDisable(true);
                    // No row is selected (null selection)
                    System.out.println("No selection made.");
                }
            }
        });
    }

    private void showSelectionAlert(Item item) {
    }

    private

    @FXML
    void onAddNewItemClicked(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/adddialog.fxml"));

        Parent root = fxmlLoader.load();
        Stage newStage = new Stage();
        Scene newScene = new Scene(root);
        newStage.setScene(newScene);
        newStage.setTitle("Add New Item");
        newStage.show();
    }

    private ObservableList<Item> getItems() {
        arrayList = FXCollections.observableArrayList();
        arrayList.addAll(items);

        populator.writeItBack(items);
        return arrayList;
    }

    public static void addItem(Item item) {
        items.add(item);
        arrayList.add(item);
        populator.writeItBack(items);
    }

    public static boolean checkItemExist(Item item) {
        for (Item i : arrayList) {
            if(i.getItemID().equals(item.getItemID())) {
                return true;
            };
        }
        return false;
    }

    public static void reload() {
        arrayList.clear();
        arrayList.addAll(items);
        populator.writeItBack(items);
    }

    @FXML
    void onRestockItemBtnClicked(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/restockdialog.fxml"));

        Parent root = fxmlLoader.load();
        Stage newStage = new Stage();
        Scene newScene = new Scene(root);
        newStage.setScene(newScene);
        newStage.setTitle("Edit Selected Item");
        newStage.show();
    }

    @FXML
    void onEditItemBtnClicked(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/editdialog.fxml"));

        Parent root = fxmlLoader.load();
        Stage newStage = new Stage();
        Scene newScene = new Scene(root);
        newStage.setScene(newScene);
        newStage.setTitle("Edit Selected Item");
        newStage.show();
    }

    @FXML
    void onDeleteItemBtnClicked(ActionEvent event) throws IOException {
        items.remove(selectedItem);
        reload();
    }
    @FXML
    private void onSearchBtnClicked(ActionEvent event) throws IOException {

        if (searchField.getText().equals("")) {
            return;
        }
        ArrayList<Item> search= new ArrayList<>();
        for (Item item : items) {
            if (item.getItemID().contains(searchField.getText())
                    || item.getDescription().contains(searchField.getText())
            ||item.getCategory().contains(searchField.getText())) {
                search.add(item);
            }
        }
        arrayList.clear();
        arrayList.addAll(search);
    }
}

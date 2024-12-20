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
import javafx.scene.control.Dialog;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;

import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class AdminStaMeowController {

    @FXML private TableView<Item> table;
    @FXML private TableColumn<Item,String> category;
    @FXML private TableColumn<Item,String> description;
    @FXML private TableColumn<Item,String> itemID;
    @FXML private TableColumn<Item,Integer> stock;

    static Populator populator = new Populator("/database/data.json");
    static ArrayList<Item> items = populator.repopulate();
    static ObservableList<Item> arrayList;

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
    }

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
        Item item = new Item("pencil", "yellow", "BIC", 10);
        items.add(item);
        arrayList.addAll(items);

        populator.writeItBack(items);
        return arrayList;
    }

    public static void addItem(Item item) {
        arrayList.add(item);
    }

}

package com.sta;

import com.sta.account.AccountHandler;
import com.sta.item.Item;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;


import javafx.scene.Scene;

import java.util.ArrayList;

public class AdminStaMeowController {

    @FXML private TableView<Item> table;
    @FXML private TableColumn<Item,String> category;
    @FXML private TableColumn<Item,String> description;
    @FXML private TableColumn<Item,String> itemID;
    @FXML private TableColumn<Item,Integer> stock;

    @FXML
    private Text username;
    private String user = AccountHandler.getCurrentAccount().getUsername();

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

    private ObservableList<Item> getItems() {
        ObservableList<Item> arrayList = FXCollections.observableArrayList();

        Item item1 = new Item("Women", "afsasdf", "asdfasdf", 111);
        Item item2 = new Item("BlackPeople", "afsasdf", "asdfasdf", 111);
        Item item3 = new Item("AsianPeople", "afsasdf", "asdfasdf", 111);
        arrayList.add(item1);
        arrayList.add(item2);
        arrayList.add(item3);

        return arrayList;
    }
}

package com.sta;

import com.sta.item.Item;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Objects;

public class Main extends Application{

    private Stage stage;

    public void start(Stage primaryStage) throws Exception{
        stage = primaryStage;
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass()
                .getResource("/fxml/main.fxml")));

        Scene scene = new Scene(root, 400 , 436);
        assert stage != null : "primaryStage must not be null";
        stage.setTitle("StaMeow Log In");
        stage.setScene(scene);
        stage.show();
        stage.setResizable(false);
    }

    public static void main(String[] args) {
        launch(args);
    }
}

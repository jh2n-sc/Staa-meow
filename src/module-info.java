module com.sta.meow {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;

    opens com.sta to javafx.fxml;
    exports com.sta;
}
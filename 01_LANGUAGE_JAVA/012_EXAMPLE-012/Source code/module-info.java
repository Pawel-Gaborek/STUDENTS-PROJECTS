module com.example.project5_v2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.example.project5_v2 to javafx.fxml;
    exports com.example.project5_v2;
}
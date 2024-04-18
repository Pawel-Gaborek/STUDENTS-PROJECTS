module com.example.project_8 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.project_8 to javafx.fxml;
    exports com.example.project_8;
}
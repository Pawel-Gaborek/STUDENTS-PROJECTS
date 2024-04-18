module com.example.example_first {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires org.apache.derby.tools;
    requires java.desktop;


    opens com.example.example_first to javafx.fxml;
    exports com.example.example_first;
}
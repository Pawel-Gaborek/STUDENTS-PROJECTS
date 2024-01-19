module com.example.aufgabe_12 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.datatransfer;
    requires java.desktop;
    //requires java.desktop;
    //requires java.desktop;
    //requires java.desktop;
    opens com.example.aufgabe_22 to javafx.fxml;
    exports com.example.aufgabe_22;
}
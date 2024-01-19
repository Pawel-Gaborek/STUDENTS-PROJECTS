module com.example.aufgabe_111 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.aufgabe_111 to javafx.fxml;
    exports com.example.aufgabe_111;
}
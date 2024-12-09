module com.example.wo_prototyp {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.wo_prototyp to javafx.fxml;
    exports com.example.wo_prototyp;
}
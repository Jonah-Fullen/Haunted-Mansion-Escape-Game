module com.example.hauntedmansion {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.hauntedmansion to javafx.fxml;
    exports com.example.hauntedmansion;
}
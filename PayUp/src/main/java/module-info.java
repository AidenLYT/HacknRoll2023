module com.example.payup {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.payup to javafx.fxml;
    exports com.example.payup;
}
module com.example.tavla {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.tavla to javafx.fxml;
    exports com.example.tavla;
}
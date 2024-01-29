module com.example.abonents {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.abonents to javafx.fxml;
    exports com.example.abonents;
}
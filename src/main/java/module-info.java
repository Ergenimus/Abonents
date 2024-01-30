module com.example.abonents {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.abonents to javafx.fxml;
    exports com.example.abonents;
    exports com.example.abonents.classes;
    opens com.example.abonents.classes to javafx.fxml;
    exports com.example.abonents.controllers;
    opens com.example.abonents.controllers to javafx.fxml;
}
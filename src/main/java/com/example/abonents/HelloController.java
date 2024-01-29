package com.example.abonents;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.sql.SQLException;
import java.time.LocalDate;

public class HelloController {
    @FXML
    public Button Streets;
    @FXML
    public Button Search;
    @FXML
    public Button CSVOutput;
    @FXML
    public DatePicker CurDate;
    @FXML
    public TableColumn MobilePhone;
    @FXML
    public TableColumn WorkPhone;
    @FXML
    public TableColumn HomePhone;
    @FXML
    public TableColumn House;
    @FXML
    public TableColumn Street;
    @FXML
    public TableColumn FIO;
    @FXML
    public TableView Table;
}
package com.example.abonents;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.sql.*;
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
    public TableColumn<Abonents,String> MobilePhone;
    @FXML
    public TableColumn<Abonents,String> WorkPhone;
    @FXML
    public TableColumn<Abonents,String> HomePhone;
    @FXML
    public TableColumn<Abonents,String> House;
    @FXML
    public TableColumn<Abonents,String> Street;
    @FXML
    public TableColumn<Abonents,String> FIO;
    @FXML
    public TableView<Abonents> Table;

    ObservableList<Abonents> listA;

    int index = -1;
    Connection conn = null;
    ResultSet rs = null;
    Statement statmt = null;

    public void initialize() throws SQLException, ClassNotFoundException {
        FIO.setCellValueFactory(new PropertyValueFactory<Abonents,String>("fio"));
        House.setCellValueFactory(new PropertyValueFactory<Abonents,String>("house"));
        Street.setCellValueFactory(new PropertyValueFactory<Abonents,String>("street"));
        WorkPhone.setCellValueFactory(new PropertyValueFactory<Abonents,String>("WPhone"));
        HomePhone.setCellValueFactory(new PropertyValueFactory<Abonents,String>("HPhone"));
        MobilePhone.setCellValueFactory(new PropertyValueFactory<Abonents,String>("MPhone"));

        listA = SQLConnect.getAbonents();
        Table.setItems(listA);
    }

}
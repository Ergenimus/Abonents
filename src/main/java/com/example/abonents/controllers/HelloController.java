package com.example.abonents.controllers;

import com.example.abonents.ModalWindows;
import com.example.abonents.SQLConnect;
import com.example.abonents.classes.Abonents;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;


import java.io.*;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;


public class HelloController {
    private static final char DELIMITER =',';
    private static final char SEPARATOR ='\n';
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
    @FXML
    public void initialize() throws SQLException, ClassNotFoundException {

        Date dateStamp = new Date(System.currentTimeMillis());

        FIO.setCellValueFactory(new PropertyValueFactory<Abonents,String>("fio"));
        House.setCellValueFactory(new PropertyValueFactory<Abonents,String>("house"));
        Street.setCellValueFactory(new PropertyValueFactory<Abonents,String>("street"));
        WorkPhone.setCellValueFactory(new PropertyValueFactory<Abonents,String>("WPhone"));
        HomePhone.setCellValueFactory(new PropertyValueFactory<Abonents,String>("HPhone"));
        MobilePhone.setCellValueFactory(new PropertyValueFactory<Abonents,String>("MPhone"));

        listA = SQLConnect.getAbonents();
        Table.setItems(listA);

        CurDate.setValue(dateStamp.toLocalDate());
    }
    @FXML
    public void onClickMethod(ActionEvent actionEvent) throws IOException {
        Date date = new Date(System.currentTimeMillis());
        DateFormat dateFormat = new SimpleDateFormat("HH-mm-ss", Locale.ENGLISH);

        FileWriter file = new FileWriter("Report_" + date + "_" + dateFormat.format(date) + ".csv");
        for (Abonents ab : listA) {
            file.append(ab.getFio());
            file.append(DELIMITER);
            file.append(ab.getStreet());
            file.append(DELIMITER);
            file.append(ab.getHouse());
            file.append(DELIMITER);
            file.append(ab.getWPhone());
            file.append(DELIMITER);
            file.append(ab.getHPhone());
            file.append(DELIMITER);
            file.append(ab.getMPhone());
            file.append(SEPARATOR);
        }
        System.out.println("DB Data exported successfully!");
        file.close();
    }
    @FXML
    public void StreetsWindow(ActionEvent actionEvent) throws IOException {
        ModalWindows.StreetsWindow();
    }
    @FXML
    public void SearchByPhone(ActionEvent actionEvent) throws IOException {
        ModalWindows.SearchWindow();
    }
}
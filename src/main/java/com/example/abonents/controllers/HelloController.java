package com.example.abonents.controllers;

import com.example.abonents.ModalWindows;
import com.example.abonents.SQLConnect;
import com.example.abonents.classes.Abonents;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;


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
    @FXML
    public void initialize() throws SQLException, ClassNotFoundException {

        Date dateStamp = new Date(System.currentTimeMillis());

        FIO.setCellValueFactory(new PropertyValueFactory<>("fio"));
        House.setCellValueFactory(new PropertyValueFactory<>("house"));
        Street.setCellValueFactory(new PropertyValueFactory<>("street"));
        WorkPhone.setCellValueFactory(new PropertyValueFactory<>("WPhone"));
        HomePhone.setCellValueFactory(new PropertyValueFactory<>("HPhone"));
        MobilePhone.setCellValueFactory(new PropertyValueFactory<>("MPhone"));

        listA = SQLConnect.getAbonents();
        Table.setItems(listA);

        CurDate.setValue(dateStamp.toLocalDate());
    }
    @FXML
    public void onClickMethod() throws IOException {
        Date date = new Date(System.currentTimeMillis());
        DateFormat dateFormat = new SimpleDateFormat("HH-mm-ss", Locale.ENGLISH);

        FileWriter file = new FileWriter("Report_" + date + "_" + dateFormat.format(date) + ".csv");
        for (Abonents ab : listA) {
            file.append(ab.toString());
        }
        System.out.println("DB Data exported successfully!");
        file.close();
    }
    @FXML
    public void StreetsWindow() throws IOException {
        ModalWindows.StreetsWindow();
    }
    @FXML
    public void SearchByPhone() throws IOException {
        ModalWindows.SearchWindow();
    }
}
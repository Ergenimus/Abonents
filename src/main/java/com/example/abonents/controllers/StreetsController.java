package com.example.abonents.controllers;

import com.example.abonents.SQLConnect;
import com.example.abonents.classes.Streets;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.SQLException;

public class StreetsController {
    @FXML
    public TableColumn<Streets, Integer> Abonents;
    @FXML
    public TableColumn<Streets, String> Street;
    @FXML
    public TableView<Streets> StreetsTable;

    ObservableList<Streets> listS;

    @FXML
    public void initialize() throws SQLException {

        Abonents.setCellValueFactory(new PropertyValueFactory<>("count"));
        Street.setCellValueFactory(new PropertyValueFactory<>("street"));

        listS = SQLConnect.getStreets();

        StreetsTable.setItems(listS);

    }

}

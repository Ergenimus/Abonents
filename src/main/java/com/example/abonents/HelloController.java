package com.example.abonents;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
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

    public DatePicker CurDate;
}
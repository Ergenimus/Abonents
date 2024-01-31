package com.example.abonents.controllers;


import com.example.abonents.SQLConnect;
import com.example.abonents.classes.Phones;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.TilePane;

import java.sql.SQLException;
import java.util.Objects;

public class SearchController {

    public TableColumn<Phones,String> Abonent;
    public TableColumn<Phones,String> Phone;
    public Label NoLabel;
    public RadioButton WorkB;
    public RadioButton HomeB;
    public RadioButton MobileB;
    public TilePane pane;
    public Button SearchB;
    public TableView<Phones> phone;
    public TextField searchF;

    ObservableList<Phones> listP;

    @FXML
    public void initialize() throws SQLException, ClassNotFoundException {

        ToggleGroup radioGroup = new ToggleGroup();

        //to group radio buttons
        WorkB.setToggleGroup(radioGroup);
        HomeB.setToggleGroup(radioGroup);
        MobileB.setToggleGroup(radioGroup);

        pane.getChildren().add(WorkB);
        pane.getChildren().add(HomeB);
        pane.getChildren().add(MobileB);

        Abonent.setCellValueFactory(new PropertyValueFactory<Phones,String>("name"));
        Phone.setCellValueFactory(new PropertyValueFactory<Phones,String>("phone"));

    }

    public void SearchByPhone(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {

        if (WorkB.isSelected()){
            listP = SQLConnect.getWPhone();
        } else if (HomeB.isSelected()) {
            listP = SQLConnect.getHPhone();
        } else if (MobileB.isSelected()) {
            listP = SQLConnect.getMPhone();
        }

        String checker = searchF.getText();

        if (!Objects.equals(Phone.getText(), checker)) {
            NoLabel.setVisible(true);
            phone.setItems(listP);
        } else {
            phone.getItems().add((Phones) listP);
        }
    }

}

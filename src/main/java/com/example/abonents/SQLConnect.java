package com.example.abonents;
import com.example.abonents.classes.Abonents;
import com.example.abonents.classes.Streets;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;

public class SQLConnect {
    public static Connection conn;
    public static Statement statmt;
    public static ResultSet resSet;

    public static Connection Conn() throws ClassNotFoundException, SQLException
    {
        conn = null;
        Class.forName("org.sqlite.JDBC");
        conn = DriverManager.getConnection("jdbc:sqlite:SQLReport.db");

        System.out.println("Database successfully connected!");
        return conn;
    }

    public static ObservableList<Abonents> getAbonents() throws SQLException, ClassNotFoundException {
        Connection conn = Conn();
        ObservableList<Abonents> list = FXCollections.observableArrayList();

            statmt = conn.createStatement();
            resSet = statmt.executeQuery("SELECT Abonent.LastName, Abonent.FirstName, Abonent.MiddleName, " +
                        "Address.Street, Address.House, PhoneNumber.Home_Number, PhoneNumber.Work_Number, " +
                        "PhoneNumber.Phone_Number FROM Abonent INNER JOIN Address ON Address.ID_Address = Abonent.Address_ID " +
                        "INNER JOIN PhoneNumber ON PhoneNumber.Phone_ID = Abonent.PhoneNumber_ID");
            while (resSet.next()) {
                String name = resSet.getString("LastName") + " " + resSet.getString("FirstName") + " " + resSet.getString("MiddleName");
                String workPhone = resSet.getString("Work_Number");
                String homePhone = resSet.getString("Home_Number");
                String mobilePhone = resSet.getString("Phone_Number");
                String street = resSet.getString("Street");
                String house = resSet.getString("House");

                list.add(new Abonents(name,street,house,workPhone,homePhone,mobilePhone));
            }

        return list;
    }

    public static ObservableList<Streets> getStreets() throws SQLException, ClassNotFoundException {
        Connection conn = Conn();
        ObservableList<Streets> list = FXCollections.observableArrayList();

        int count = 0;

        statmt = conn.createStatement();
        resSet = statmt.executeQuery("SELECT Streets.Street, Street.Streets_ID, Abonent.Streets_ID " +
                "FROM Streets INNER JOIN Abonent WHERE Abonent.Streets_ID = Streets.Streets_ID");

        while (resSet.next()) {

            String street = resSet.getString("Street");
            int StId = resSet.getInt("Streets.Streets_ID");
            int AbId = resSet.getInt("Abonent.Streets_ID");
            if (AbId == StId) count++;
            list.add(new Streets(count,street));
        }

        return list;
    }



    /*public static void ReadDB() throws SQLException
    {
        statmt = conn.createStatement();
        resSet = statmt.executeQuery("SELECT Abonent.LastName, Abonent.FirstName, Abonent.MiddleName, " +
                "Address.Street, Address.House, PhoneNumber.Home_Number, PhoneNumber.Work_Number, " +
                "PhoneNumber.Phone_Number FROM Abonent INNER JOIN Address ON Address.ID_Address = Abonent.Address_ID " +
                "INNER JOIN PhoneNumber ON PhoneNumber.Phone_ID = Abonent.PhoneNumber_ID");


    }*/
}

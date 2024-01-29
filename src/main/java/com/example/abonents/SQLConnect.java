package com.example.abonents;
import java.sql.*;

public class SQLConnect {
    public static Connection conn;
    public static Statement statmt;
    public static ResultSet resSet;

    public static void Conn() throws ClassNotFoundException, SQLException
    {
        conn = null;
        Class.forName("org.sqlite.JDBC");
        conn = DriverManager.getConnection("jdbc:sqlite:SQLReport.db");

        System.out.println("Database successfully connected!");
    }

    // -------- Вывод таблицы--------
    public static void ReadDB() throws SQLException
    {
        statmt = conn.createStatement();
        resSet = statmt.executeQuery("SELECT Abonent.LastName, Abonent.FirstName, Abonent.MiddleName, Address.Street, Address.House, PhoneNumber.Home_Number, PhoneNumber.Work_Number, PhoneNumber.Phone_Number FROM Abonent INNER JOIN Address ON Address.ID_Address = Abonent.Address_ID INNER JOIN PhoneNumber ON PhoneNumber.Phone_ID = Abonent.PhoneNumber_ID");

        while(resSet.next())
        {

            String name = resSet.getString("LastName") + " " + resSet.getString("FirstName") + " " + resSet.getString("MiddleName");
            String workPhone = resSet.getString("Work_Number");
            String homePhone = resSet.getString("Home_Number");
            String mobilePhone = resSet.getString("Phone_Number");
            String street = resSet.getString("Street");
            String house = resSet.getString("House");


            System.out.println("Abonent FIO: " + name);
            System.out.println("Street: " + street);
            System.out.println("House: " + house);
            System.out.println("Work phone: " + workPhone);
            System.out.println("Home phone: " + homePhone);
            System.out.println("Mobile phone: " + mobilePhone);
            System.out.println();
        }
    }

}

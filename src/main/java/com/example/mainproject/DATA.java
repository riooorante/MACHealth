package com.example.mainproject;

import java.sql.*;
import java.util.ArrayList;

public class DATA {
    private static String USERNAME,PASSWORD,NAMA;
    private static Integer ID;

    public static void setUSERNAME(String USERNAME) {
        DATA.USERNAME = USERNAME;
    }

    public static void setPASSWORD(String PASSWORD) {
        DATA.PASSWORD = PASSWORD;
    }

    public static void setNAMA(String NAMA) {
        DATA.NAMA = NAMA;
    }

    public static void setID(Integer ID) {
        DATA.ID = ID;
    }

    public static String getUSERNAME() {
        return USERNAME;
    }

    public static String getPASSWORD() {
        return PASSWORD;
    }

    public static String getNAMA() {
        return NAMA;
    }

    public static Integer getID() {
        return ID;
    }
    public ArrayList datadiagram(String kolom){
        ArrayList<Double> arrayList = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:" + "D:/Programming/Java/MACHealth/src/main/resources/Database/MACHealth.db")) {
            String query = String.format("SELECT * FROM HISTORY WHERE IDUSER = '%d'", DATA.getID());
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                Double content = resultSet.getDouble(kolom);
                arrayList.add(content);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return arrayList;
    }
}

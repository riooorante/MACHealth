package com.example.mainproject;

import java.sql.*;
import java.util.ArrayList;

public class DATA {
    private static String NAMA;

    public static String getICON() {
        return ICON;
    }

    public static void setICON(String ICON) {
        DATA.ICON = ICON;
    }

    private static String ICON;
    private static Integer ID;

    public static void setNAMA(String NAMA) {
        DATA.NAMA = NAMA;
    }

    public static void setID(Integer ID) {
        DATA.ID = ID;
    }

    public static String getNAMA() {
        return NAMA;
    }

    public static Integer getID() {
        return ID;
    }
    public ArrayList datadiagram(String kolom, String table){
        ArrayList<Double> arrayList = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:" + "D:/Programming/Java/MACHealth/src/main/resources/Database/MACHealth.db")) {
            String query = String.format("SELECT * FROM %s WHERE IDUSER = '%d'", table,DATA.getID());
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

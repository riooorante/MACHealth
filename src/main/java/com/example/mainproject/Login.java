package com.example.mainproject;

import java.sql.*;

public class Login extends Database {
    public static Boolean readData(String USERNAME, String PASSWORD) {
        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:" + datapath)) {
            String query = String.format("SELECT * FROM LOGIN WHERE USERNAME = '%s'", USERNAME);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            if (resultSet.next()) {
                String pass = resultSet.getString("PASS");
                Integer ID = resultSet.getInt("IDUSER");
                String name = resultSet.getString("NICKNAME");
                if (pass.equals(PASSWORD.strip().trim())) {
                    DATA.setID(ID);
                    DATA.setNAMA(name);
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
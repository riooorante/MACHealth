package com.example.mainproject;

import java.sql.*;
public class Registrasi extends Database{
    public static Boolean inputData(String NAME,String USERNAME, String PASSWORD) {
        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:" + datapath)) {
            String queryread = String.format("SELECT * FROM LOGIN WHERE USERNAME = '%s'", USERNAME);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(queryread);
            if (resultSet.next()){
                return false;
            } else {
                String queryinput = "INSERT INTO LOGIN (USERNAME,PASS,NICKNAME) VALUES (?,?,?)";
                PreparedStatement statementinput = connection.prepareStatement(queryinput);
                statementinput.setString(1, USERNAME);
                statementinput.setString(2, PASSWORD);
                statementinput.setString(3, NAME);
                statementinput.executeUpdate();
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}


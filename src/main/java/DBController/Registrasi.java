package com.example.mainproject;

import java.sql.*;
public class Registrasi extends Database {

    public Registrasi(String name, String username, String password) {
        super(name, username, password);
    }

    public Boolean registrasi() {
        try {
            Connection conn = connection();
            String queryread = String.format("SELECT * FROM LOGIN WHERE USERNAME = '%s'", getUsername().strip().trim());
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(queryread);
            if (resultSet.next()) {
                conn.close();
                return false;
            } else {
                inputData();
                conn.close();
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Connection connection() {
        try {
            Connection connection = DriverManager.getConnection("jdbc:sqlite:" + datapath);
            return connection;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}


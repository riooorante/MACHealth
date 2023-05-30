package com.example.mainproject;

import java.sql.*;

public class Login extends Database {
    public Boolean readData(String USERNAME, String PASSWORD) {
        Connection conn = connection();
        try {
            if (conn == null) {
                conn.close();
                return false;
            }
            String query = String.format("SELECT * FROM LOGIN WHERE USERNAME = '%s'", USERNAME);
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            if (resultSet.next()) {
                String pass = resultSet.getString("PASS");
                Integer ID = resultSet.getInt("IDUSER");
                String name = resultSet.getString("NICKNAME");
                if (pass.equals(PASSWORD.strip().trim())) {
                    DATA.setID(ID);
                    DATA.setNAMA(name);
                    conn.close();
                    return true;
                } else {
                    conn.close();
                    return false;
                }
            } else {
                conn.close();
                return false;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

    }

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
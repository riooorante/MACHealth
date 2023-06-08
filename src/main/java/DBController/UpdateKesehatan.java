package com.example.mainproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class UpdateKesehatan extends Database {

    public UpdateKesehatan(Integer tekananDarah, Integer gulaDarah, Double tinggi, Integer berat) {
        super(tekananDarah, gulaDarah, tinggi, berat);
    }

    public Boolean updateKesehatan() throws SQLException {
        Connection conn = connection();
        inputData(DATA.getID());
        conn.close();
        return true;
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

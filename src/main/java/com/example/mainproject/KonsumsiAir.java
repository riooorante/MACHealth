package com.example.mainproject;

import java.sql.*;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class KonsumsiAir extends Database{
    public void updatedata(){
        LocalDate tglnow = LocalDate.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String tanggal = tglnow.format(format);

        try (Connection conn = connection()) {
            String queryread = String.format("SELECT * FROM KONSUMSIAIR WHERE IDUSER = '%d' AND TANGGAL = %s", DATA.getID(),tanggal);
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(queryread);
            if (resultSet.next()){
                int konsumsiair = resultSet.getInt("KONSUMSI");
                String queryupdate = String.format("UPDATE KONSUMSIAIR SET KONSUMSI = ? WHERE IDUSER = '%d' AND TANGGAL = %s",DATA.getID(),tanggal);
                PreparedStatement statementupdate =  conn.prepareStatement(queryupdate);
                statementupdate.setInt(1,konsumsiair+1);
                statementupdate.executeUpdate();
            } else {}
        }catch (SQLException e){
            e.printStackTrace();
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

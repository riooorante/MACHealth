package com.example.mainproject;

import java.sql.*;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class KonsumsiAir extends Database{
    public void updatedataminum(){
        LocalDate tglnow = LocalDate.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String tanggal = tglnow.format(format);

        try (Connection conn = connection()) {
            String queryread = String.format("SELECT * FROM KONSUMSI_AIR WHERE IDUSER = %d AND TANGGAL = '%s'", DATA.getID(),tanggal.trim().strip());
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(queryread);
            if (resultSet.next()){
                int konsumsiair = resultSet.getInt("KONSUMSI");
                String queryupdate = String.format("UPDATE KONSUMSI_AIR SET KONSUMSI = ? WHERE IDUSER = %d AND TANGGAL = '%s'",DATA.getID(),tanggal.trim().strip());
                PreparedStatement statementupdate =  conn.prepareStatement(queryupdate);
                statementupdate.setInt(1,konsumsiair+1);
                statementupdate.executeUpdate();
                conn.close();
            } else {
                String queryinsert = "INSERT INTO KONSUMSI_AIR (IDUSER, KONSUMSI, TANGGAL) VALUES (?,?,?)";
                PreparedStatement preparedStatement = conn.prepareStatement(queryinsert);
                preparedStatement.setInt(1,DATA.getID());
                preparedStatement.setInt(2, 1);
                preparedStatement.setString(3, tanggal);
                preparedStatement.executeUpdate();
                conn.close();
            }
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

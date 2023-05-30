package com.example.mainproject;

import java.sql.*;

public class UpdateKesehatan extends Database {
    public static Boolean inputData(int TekananDarah,int GulaDarah, int Tinggi, int Berat) {
        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:" + datapath)) {
            String queryinput = "INSERT INTO HISTORY (IDUSER,TEKANAN_DARAH,BMI,GULA_DARAH) VALUES (?,?,?,?)";
            PreparedStatement statementinput = connection.prepareStatement(queryinput);
            statementinput.setInt(1, DATA.getID());
            statementinput.setInt(2,TekananDarah);
            statementinput.setInt(3,(Berat/(Tinggi*Tinggi)));
            statementinput.setInt(4,GulaDarah);
            statementinput.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}

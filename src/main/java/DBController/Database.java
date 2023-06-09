package com.example.mainproject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public abstract class Database {
    private Integer tekananDarah, gulaDarah, berat;
    private Double tinggi;
    private String name, username, password;

    public Integer getTekananDarah() {
        return tekananDarah;
    }

    public Integer getGulaDarah() {
        return gulaDarah;
    }

    public Double getTinggi() {
        return tinggi;
    }

    public Integer getBerat() {
        return berat;
    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Database(String name, String username, String password) {
        this.name = name;
        this.username = username;
        this.password = password;
    }

    public Database(Integer tekananDarah, Integer gulaDarah, Double tinggi, Integer berat) {
        this.tekananDarah = tekananDarah;
        this.gulaDarah = gulaDarah;
        this.tinggi = tinggi/100;
        this.berat = berat;
    }

    public Database() {
    }

    public static final String datapath = "D:/Programming/Java/MACHealth/src/main/resources/Database/MACHealth.db";

    public abstract Connection connection();

    public void inputData(Integer userid) {
        try {
            String queryinput = "INSERT INTO HISTORY (IDUSER,TEKANAN_DARAH,BMI,GULA_DARAH) VALUES (?,?,?,?)";
            double BMI = (getBerat() / Math.pow(getTinggi(),2));
            PreparedStatement statementinput = connection().prepareStatement(queryinput);
            statementinput.setInt(1, userid);
            statementinput.setInt(2, getTekananDarah());
            statementinput.setDouble(3, BMI);
            statementinput.setInt(4, getGulaDarah());
            statementinput.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void inputData() throws SQLException {
        try {
            String queryinput = "INSERT INTO LOGIN (USERNAME,PASS,NICKNAME, ICON) VALUES (?,?,?,?)";
            PreparedStatement statementinput = connection().prepareStatement(queryinput);
            statementinput.setString(1, getUsername());
            statementinput.setString(2,getPassword());
            statementinput.setString(3, getName());
            statementinput.setString(4, DATA.getICON());
            statementinput.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}


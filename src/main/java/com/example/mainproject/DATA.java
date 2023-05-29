package com.example.mainproject;

public class DATA {
    private static String USERNAME,PASSWORD,NAMA;
    private static Integer ID;

    public static void setUSERNAME(String USERNAME) {
        DATA.USERNAME = USERNAME;
    }

    public static void setPASSWORD(String PASSWORD) {
        DATA.PASSWORD = PASSWORD;
    }

    public static void setNAMA(String NAMA) {
        DATA.NAMA = NAMA;
    }

    public static void setID(Integer ID) {
        DATA.ID = ID;
    }

    public static String getUSERNAME() {
        return USERNAME;
    }

    public static String getPASSWORD() {
        return PASSWORD;
    }

    public static String getNAMA() {
        return NAMA;
    }

    public static Integer getID() {
        return ID;
    }
}

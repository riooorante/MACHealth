package com.example.mainproject;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class HelloApplication extends Application {
    private Stage stage;

    @Override
    public void start(Stage Stage) throws Exception{
        stage = Stage;
        stage.setTitle("MACHealth");

        sceneLogin();

        stage.show();

    }
    private void sceneLogin(){
        Label label = new Label("MACHealth");

        TextField tfUsername = new TextField();
        tfUsername.setPromptText("Username");

        TextField tfPassword = new TextField();
        tfPassword.setPromptText("Password");

        Label label1 = new Label();
        Button login = new Button("LOGIN");
        login.requestFocus();
        login.setOnAction(event -> {
            if (!tfUsername.getText().isBlank() && !tfUsername.getText().isBlank()) {
                dashboard();
            } else {
                label1.setText("Username atau Password Tidak Boleh Kosong");
            }
        });

        Button register = new Button("REGISTER");
        register.requestFocus();
        register.setOnAction(event -> {
            regNameTB();
        });

        tfUsername.setOnKeyPressed(event -> {
            if (event.getCode().toString().equals("ENTER")){
                tfPassword.requestFocus();
            }
        });

        tfPassword.setOnKeyPressed(event -> {
            if (event.getCode().toString().equals("ENTER")){
                login.requestFocus();
            }
        });

        HBox hBox = new HBox(30);
        hBox.getChildren().add(label1);
        hBox.setAlignment(Pos.BOTTOM_CENTER);

        VBox vBox = new VBox(20);
        vBox.getChildren().addAll(label, tfUsername, tfPassword, login, register, label1);
        vBox.setAlignment(Pos.CENTER);

        Scene scene = new Scene(vBox, 490, 800);

        stage.setScene(scene);
        vBox.requestFocus();

    }
    private void regNameTB() {
        Label lNU = new Label("Nama dan Umur");

        TextField tfNama = new TextField();
        tfNama.setPromptText("Nama");

        TextField tfUmur = new TextField();
        tfUmur.setPromptText("Umur");

        TextField berat = new TextField();
        berat.setPromptText("Berat");
        TextField tinggi = new TextField();
        tinggi.setPromptText("Tinggi");

        Label warnLabel = new Label();
        Button btnNU = new Button("Lanjutkan");
        btnNU.setOnAction(event -> {
            if (!tfNama.getText().isBlank() && !tfUmur.getText().isBlank() && !berat.getText().isBlank() && !tinggi.getText().isBlank()) {
                regTekananDarah();
            } else {
                warnLabel.setText("Lengkapi Data");
            }
        });

        HBox hBox = new HBox(10);
        hBox.getChildren().addAll(berat, tinggi);
        hBox.setAlignment(Pos.CENTER);

        VBox vBox = new VBox(10);
        vBox.getChildren().addAll(lNU, tfNama, tfUmur, hBox, btnNU, warnLabel);
        vBox.setAlignment(Pos.CENTER);

        Scene root = new Scene(vBox, 490, 800);
        stage.setScene(root);
        vBox.requestFocus();

    }
    private void regTekananDarah() {
        Label lTekDar = new Label("Tekanan Darah");
        TextField tfTekDar = new TextField();

        Label warnLabel = new Label();
        Button btnTekDar = new Button("Lanjutkan");
        btnTekDar.setOnAction(event -> {
            if (!tfTekDar.getText().isBlank()) {
                regGulaDarah();
            }else {
                warnLabel.setText("Lengkapi Data");
            }
        });

        VBox vBox = new VBox(10);
        vBox.getChildren().addAll(lTekDar, tfTekDar, btnTekDar,warnLabel);
        vBox.setAlignment(Pos.CENTER);

        Scene root = new Scene(vBox, 490, 800);
        stage.setScene(root);
    }
    private void regGulaDarah() {
        Label lGulDar = new Label("Gula Darah");
        TextField tfGulDar = new TextField();

        Label warnLabel = new Label();
        Button btnGulDar = new Button("Lanjutkan");
        btnGulDar.setOnAction(event -> {
            if (!tfGulDar.getText().isBlank()) {
                        regKonsumsi();
            } else {
                warnLabel.setText("Lengkapi Data");
            }
        });

        VBox vBox = new VBox(10);
        vBox.getChildren().addAll(lGulDar,tfGulDar,btnGulDar);
        vBox.setAlignment(Pos.CENTER);

        Scene root = new Scene(vBox, 490, 800);
        stage.setScene(root);
        }
    private void regKonsumsi() {
        Button btnMinum = new Button("Minum");
        Button btnKA = new Button("Lanjutkan");
        btnKA.setOnAction(event -> {
            dashboard();
        });

        VBox vBox = new VBox(10);
        vBox.getChildren().addAll(btnMinum, btnKA);
        vBox.setAlignment(Pos.CENTER);

        Scene root = new Scene(vBox, 490, 800);
        stage.setScene(root);
    }
    public static void dashboard(){
        System.out.println("DashBoard");
    }
    public static void tekananDarah(){
        System.out.println("Tekanan Darah");
    }
    public static void gulaDarah(){
        System.out.println("Gula Darah");
    }
    public static void konsumsiAir(){
        System.out.println("Konsumsi Air");
    }
    public static void TBBB(){
        System.out.println("Tinggi Badan");
    }
    public static void summary(){
        System.out.println("Summary");
    }


    public static void main(String[] args) {
        launch(args);
    }
}
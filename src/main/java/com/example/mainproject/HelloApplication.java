package com.example.mainproject;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
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

        Button login = new Button("LOGIN");
        login.requestFocus();
        login.setOnAction(event -> {
            if (tfUsername.getText() != null && tfPassword.getText() != null){
                dashboard();
            }
        });

        Button register = new Button("REGISTER");
        register.setOnAction(event -> {regNameTB();});

        VBox vBox = new VBox(20);
        vBox.getChildren().addAll(label,tfUsername,tfPassword,login,register);
        vBox.setAlignment(Pos.CENTER);

        Scene scene = new Scene(vBox, 400,500);

        stage.setScene(scene);
        vBox.requestFocus();

    }
    private void regNameTB(){
        Label lNU = new Label("Nama dan Umur");

        TextField tfNama = new TextField();
        tfNama.setPromptText("Nama");

        TextField tfUmur = new TextField();
        tfUmur.setPromptText("Umur");

        Button btnNU = new Button("Lanjutkan");
        btnNU.setOnAction(event -> {regTekananDarah();});

        TextField berat = new TextField();
        berat.setPromptText("Berat");
        TextField tinggi = new TextField();
        tinggi.setPromptText("Tinggi");

        HBox hBox = new HBox(10);
        hBox.getChildren().addAll(berat,tinggi);

        VBox vBox = new VBox(10);
        vBox.getChildren().addAll(lNU, tfNama, tfUmur,hBox,btnNU);
        vBox.setAlignment(Pos.CENTER);

        Scene root = new Scene(vBox,300,300);
        stage.setScene(root);
        vBox.requestFocus();

    }
    private void regTekananDarah(){
        Label lTekDar = new Label("Tekanan Darah");
        TextField tfTekDar = new TextField();
        Button btnTekDar = new Button("Lanjutkan");

        VBox vBox = new VBox(10);
        vBox.getChildren().addAll(lTekDar,tfTekDar,btnTekDar);
    }
    private void regGulaDarah(){
        Label lGulDar = new Label("Gula Darah");
        TextField tfGulDar = new TextField();
        Button btnGulDar = new Button("Lanjutkan");

        VBox vBox = new VBox(10);
        vBox.getChildren().addAll(lGulDar,tfGulDar,btnGulDar);
    }
    private void regKonsumsi(){
        Button btnMinum = new Button("Minum");
        Button btnKA = new Button("Lanjutkan");

        VBox vBox = new VBox(10);
        vBox.getChildren().addAll(btnMinum,btnKA);
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
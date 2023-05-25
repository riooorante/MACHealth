package com.example.mainproject;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class HelloApplication extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Membuat konten di dalam ScrollPane
        VBox content = new VBox();
        for (int i = 1; i <= 20; i++) {
            Label label = new Label("Label " + i);
            content.getChildren().add(label);
        }

        // Membuat ScrollPane dan mengatur kontennya
        ScrollPane scrollPane = new ScrollPane(content);
        scrollPane.setFitToWidth(true);
        scrollPane.setFitToHeight(true);

        // Membuat scene dengan ScrollPane sebagai root node
        Scene scene = new Scene(scrollPane, 400, 300);

        primaryStage.setTitle("Scrollable Scene Example");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void sceneLogin(){
        System.out.println("Login");
    }
    public static void regNameTB(){
        System.out.println("Nama, Umur, TB, BB");
        VBox1.addall(lNU, tfNama, tfUmur, btnNU);
        Label lNU = new Label("Nama dan Umur");
        TextField tfNama = new TextField();
        tfNama.setPromptText("Nama");
        TextField tfUmur = new TextField();
        tfNama.setPromptText("Umur");
        Button btnNU = new Button("Lanjutkan");
    }
    public static void regTekananDarah(){
        System.out.println("Tekanan Darah");
        VBox2.addall(lTekDar, tfTekDar, btnTekDar);
        Label lTekDar = new Label("Tekanan Darah");
        TextField tfTekDar = new TextField();
        Button btnTekDar = new Button("Lanjutkan");
    }
    public static void regGulaDarah(){
        System.out.println("Gula Darah");
        VBox3.addall(lGulDar, tfGulDar, btnGulDar);
        Label lGulDar = new Label("Gula Darah");
        TextField tfGulDar = new TextField();
        Button btnGulDar = new Button("Lanjutkan");
    }
    public static void regKonsumsi(){
        System.out.println("Konsumsi Air");
        VBox4.addall(btnMinum, btnKA);
        Button btnMinum = new Button("Minum");
        Button btnKA = new Button("Lanjutkan");
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
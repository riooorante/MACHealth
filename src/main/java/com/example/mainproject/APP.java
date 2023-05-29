package com.example.mainproject;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.util.Arrays;

import static com.example.mainproject.Elemen.dashRectangle;

public class APP extends Application {
    private Stage stage;

    @Override
    public void start(Stage Stage) throws Exception {
        stage = Stage;
        stage.setTitle("MACHealth");
        dashboard();
        stage.show();
    }

    private void sceneLogin() {
        Label label = new Label("MACHealth");

        TextField tfUsername = new TextField();
        tfUsername.setPromptText("Username");

        TextField tfPassword = new TextField();
        tfPassword.setPromptText("Password");

        Label label1 = new Label();
        Button login = new Button("LOGIN");
        login.setId("Loginbutton");
        login.requestFocus();
        login.setOnAction(event -> {
            if (!tfUsername.getText().isBlank() && !tfPassword.getText().isBlank()) {
                dashboard();
            } else {
                label1.setText("Username atau Password Tidak Boleh Kosong");
            }
        });

        Button register = new Button("REGISTER");
        register.setId("Loginbutton");
        register.requestFocus();
        register.setOnAction(event -> {
            regmaindata();
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
        vBox.getChildren().addAll(label, tfUsername, tfPassword, label1, login, register);
        vBox.setAlignment(Pos.CENTER);

        Rectangle rectangle = new Rectangle(460, 420);
        rectangle.setId("rectangle");
        rectangle.setArcWidth(30);
        rectangle.setArcHeight(30);

        StackPane stackPane = new StackPane(rectangle, vBox);
        stackPane.setAlignment(Pos.CENTER);

        Scene root = new Scene(stackPane, 1400, 800);
        root.getStylesheets().add(getClass().getResource("/Styles/style.css").toExternalForm());
        stage.setScene(root);
        vBox.requestFocus();

    }
    private void regmaindata() {
        Label lNU = new Label("MACHealth");

        TextField tfNama = new TextField();
        tfNama.setPromptText("Nama");
        tfNama.setId("tfREG");

        TextField tfUsername = new TextField();
        tfUsername.setPromptText("Username");
        tfUsername.setId("tfREG");

        TextField tfpass = new TextField();
        tfpass.setPromptText("Password");
        tfpass.setId("tfREG");


        Label warnLabel = new Label();
        Button btnNU = new Button("LANJUTKAN");
        btnNU.setId("Loginbutton");
        btnNU.setOnAction(event -> {
            if (!tfNama.getText().isBlank() && !tfUsername.getText().isBlank() && !tfpass.getText().isBlank()) {
                updateKesehatan();
            } else {
                warnLabel.setText("Lengkapi Data");
            }
        });

        VBox vBox = new VBox(20);
        vBox.getChildren().addAll(lNU, tfNama, tfUsername, tfpass, warnLabel, btnNU);
        vBox.setAlignment(Pos.CENTER);

        Rectangle rectangle = new Rectangle(460, 420);
        rectangle.setId("rectangle");
        rectangle.setArcWidth(30);
        rectangle.setArcHeight(30);
        StackPane stackPane = new StackPane(rectangle, vBox);

        // Change Focus
        tfNama.setOnKeyPressed(event -> {
            if(event.getCode().toString().equals("ENTER")){
                tfUsername.requestFocus();
            }
        });
        tfUsername.setOnKeyPressed(event -> {
            if(event.getCode().toString().equals("ENTER")){
                tfpass.requestFocus();
            }
        });
        tfpass.setOnKeyPressed(event -> {
            if(event.getCode().toString().equals("ENTER")){
                btnNU.requestFocus();
            }
        });

        Scene root = new Scene(stackPane, 1400, 800);
        root.getStylesheets().add(getClass().getResource("/Styles/style.css").toExternalForm());
        stage.setScene(root);
        vBox.requestFocus();

    }

    private void updateKesehatan() {
        Label label = new Label("MACHealth");
        TextField tfTekDar = new TextField();
        tfTekDar.setPromptText("Tekanan Darah");
        tfTekDar.setId("tfREG");

        TextField tfGulDar = new TextField();
        tfGulDar.setPromptText("Gula Darah");
        tfGulDar.setId("tfREG");

        TextField berat = new TextField();
        berat.setPromptText("Berat");
        berat.setId("TBBB");

        TextField tinggi = new TextField();
        tinggi.setPromptText("Tinggi");
        tinggi.setId("TBBB");

        HBox hBox = new HBox(10);
        hBox.getChildren().addAll(berat, tinggi);
        hBox.setAlignment(Pos.CENTER);

        Label warnLabel = new Label();
        Button btnTekDar = new Button("LANJUTKAN");
        btnTekDar.setId("Loginbutton");
        btnTekDar.setOnAction(event -> {
            if (!tfTekDar.getText().isBlank()) {
                dashboard();
            } else {
                warnLabel.setText("Lengkapi Data");
            }
        });

        // Change Focus
        tfTekDar.setOnKeyPressed(event -> {
            if(event.getCode().toString().equals("ENTER")){
                tfGulDar.requestFocus();
            }
        });
        tfGulDar.setOnKeyPressed(event -> {
            if(event.getCode().toString().equals("ENTER")){
                berat.requestFocus();
            }
        });
        berat.setOnKeyPressed(event -> {
            if(event.getCode().toString().equals("ENTER")){
                tinggi.requestFocus();
            }
        });
        tinggi.setOnKeyPressed(event -> {
            if(event.getCode().toString().equals("ENTER")){
                btnTekDar.requestFocus();
            }
        });


        VBox vBox = new VBox(20);
        vBox.getChildren().addAll(label, tfTekDar, tfGulDar,  hBox, warnLabel, btnTekDar);
        vBox.setAlignment(Pos.CENTER);

        Rectangle rectangle = new Rectangle(460, 420);
        rectangle.setId("rectangle");
        rectangle.setArcHeight(30);
        rectangle.setArcWidth(30);
        StackPane stackPane = new StackPane(rectangle,vBox);

        Scene root = new Scene(stackPane, 1400, 800);
        root.getStylesheets().add(getClass().getResource("/Styles/style.css").toExternalForm());
        stage.setScene(root);

    }
    private void dashboard() {
        // Rectangle Profil
        Image image = new Image("/Main.png");
        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(100);
        imageView.setFitWidth(100);
        Label labelNama = new Label("Mario");
        VBox vBox = new VBox(10);
        vBox.setAlignment(Pos.CENTER);
        vBox.getChildren().addAll(imageView, labelNama);
        Rectangle rectangle = new Rectangle(300, 180);
        rectangle.setId("RecProfile");
        rectangle.setArcHeight(35);
        rectangle.setArcWidth(35);
        StackPane stackPane = new StackPane(rectangle, vBox);

        // Rectangle Minum
        Rectangle recMinum = new Rectangle(300, 150);
        recMinum.setId("RecButton");
        recMinum.setArcWidth(35);
        recMinum.setArcHeight(35);

        // Rectangle Button
        Rectangle rectangle1 = new Rectangle(300, 410);
        rectangle1.setArcWidth(35);
        rectangle1.setArcHeight(35);
        rectangle1.setId("RecButton");

        Button updatedata = new Button("DATA BARU"); // Tambahkan setOnAction ke scene UpadateKesehatan() line 154

        Button summary = new Button("SUMMARY"); // Tambahkan setOnAction ke scene summary

        Button logout = new Button("LOGOUT");
        logout.setOnAction(event -> {
            sceneLogin();
        });

        VBox vBox1 = new VBox(20);
        vBox1.setAlignment(Pos.CENTER);
        vBox1.getChildren().addAll(updatedata, summary, logout);

        StackPane stackPane1 = new StackPane(rectangle1, vBox1);

        VBox Scroll = new VBox(10,stackPane, recMinum,stackPane1);
        Scroll.setPadding(new Insets(20));

        // Rectangle LineChart
        FlowPane flowPane = new FlowPane();
        flowPane.setPadding(new Insets(25));
        flowPane.setHgap(20);
        flowPane.setVgap(20);
        flowPane.getChildren().addAll(dashRectangle("Konsumsi Air", Arrays.asList(1.0, 2.0)),
                dashRectangle("Tekanan Darah", Arrays.asList(1.3, 2.1)),
                dashRectangle("Gula Darah", Arrays.asList(1.2, 2.4)),
                dashRectangle("BMI", Arrays.asList(1.3, 9.0)));

        // Gridpane Dashboard
        GridPane gridPane = new GridPane();
        ColumnConstraints column0 = new ColumnConstraints(340);
        ColumnConstraints column1 = new ColumnConstraints(1060);
        gridPane.getColumnConstraints().addAll(column0, column1);
        gridPane.add(Scroll, 0, 0);
        gridPane.add(flowPane, 1, 0);

        // Set Scene
        Scene root = new Scene(gridPane, 1400, 800);
        root.getStylesheets().add(getClass().getResource("/Styles/style.css").toExternalForm());
        stage.setScene(root);
    }

    public static void summary(){
        System.out.println("Summary");
    }
    public static void main(String[] args) {
        launch(args);
    }
}
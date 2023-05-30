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

public class App extends Application {
    private Stage stage;

    @Override
    public void start(Stage Stage) throws Exception {
        stage = Stage;
        stage.setTitle("MACHealth");
        sceneLogin();
        stage.setResizable(false);
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
            if (!tfUsername.getText().isBlank() && !tfPassword.getText().isBlank() && Login.readData(tfUsername.getText(),tfPassword.getText())) {
                    dashboard();
            } else {
                label1.setText("Isi dengan baik dan benar");
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
            if (!tfNama.getText().isBlank() && !tfUsername.getText().isBlank() && !tfpass.getText().isBlank() && (tfNama.getText().length() <= 15)) {
                if (Registrasi.inputData(tfNama.getText(),tfUsername.getText(),tfpass.getText())){
                    sceneLogin();
                } else {
                    warnLabel.setText("Username Sudah Digunakan");
                }
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
            if (!tfTekDar.getText().isBlank() && !tfGulDar.getText().isBlank() && !berat.getText().isBlank() && !tinggi.getText().isBlank()) {
                int tekdar = Integer.parseInt(tfTekDar.getText());
                int guldar = Integer.parseInt(tfGulDar.getText());
                int Tinggi = Integer.parseInt(tinggi.getText());
                int Berat = Integer.parseInt(berat.getText());
                if (UpdateKesehatan.inputData(tekdar,guldar,Tinggi,Berat)){
                    dashboard();
                }
            } else {
                warnLabel.setText("Isi Data Dengan Baik Dan Benar");
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
        vBox.requestFocus();

    }
    private void dashboard() {
        // Rectangle Profil
        Image image = new Image("/Icon/Main.png");
        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(100);
        imageView.setFitWidth(100);
        Label labelNama = new Label(DATA.getNAMA());
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

        Button updatedata = new Button("DATA BARU");
        updatedata.setOnAction(event -> {
            updateKesehatan();
        });

        Button summary = new Button("SUMMARY");
        summary.setOnAction(event -> {
            summary();
        });

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
        DATA data = new DATA();
        FlowPane flowPane = new FlowPane();
        flowPane.setPadding(new Insets(25));
        flowPane.setHgap(20);
        flowPane.setVgap(20);
        flowPane.getChildren().addAll(dashRectangle("Konsumsi Air", data.datadiagram("TEKANAN_DARAH")),
                dashRectangle("Tekanan Darah", data.datadiagram("TEKANAN_DARAH")),
                dashRectangle("Gula Darah", data.datadiagram("GULA_DARAH")),
                dashRectangle("BMI", data.datadiagram("BMI")));

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
        Rectangle rectangle4 = new Rectangle(300, 100);
        rectangle1.setArcWidth(35);
        rectangle1.setArcHeight(35);
        rectangle1.setId("RecSummary");
        System.out.println("Summary");

        Label label = new Label("Summary");
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
        hBox.getChildren().add(ractangle4);

        Scene root = new Scene(hBox, 1400, 800);
        root.getStylesheets().add(getClass().getResource("/Styles/style.css").toExternalForm());
        stage.setScene(root);
        vBox.requestFocus();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
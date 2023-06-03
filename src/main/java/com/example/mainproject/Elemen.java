package com.example.mainproject;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;

import java.sql.*;
import java.util.ArrayList;

public class Elemen {
    public static String Kategori;
    public static int nilai;
    public static LineChart<Number, Number> diagram(ArrayList<Double> doubles) {
        NumberAxis xAxis = new NumberAxis();
        NumberAxis yAxis = new NumberAxis();
        LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);
        XYChart.Series<Number, Number> series = new XYChart.Series<>();
        lineChart.lookup(".chart-vertical-grid-lines").setVisible(false);
        lineChart.lookup(".chart-horizontal-grid-lines").setVisible(false);
        lineChart.getYAxis().setTickLabelsVisible(false);
        lineChart.getYAxis().setOpacity(0);
        lineChart.getXAxis().setTickLabelsVisible(false);
        lineChart.getXAxis().setOpacity(0);
        int day = 0;
        for (Double data : doubles){
            series.getData().add(new XYChart.Data<>(day++,data));
        }
        lineChart.getData().add(series);
        lineChart.setPrefSize(200,300);
        lineChart.setLegendVisible(false);

        return lineChart;
    }
    public static StackPane dashRectangle(String label, ArrayList<Double> listdata){
        Rectangle rectangle = new Rectangle(490, 350);
        rectangle.setArcWidth(20);
        rectangle.setArcHeight(20);
        Label labeldiagram = new Label(label);
        VBox vBox2 = new VBox(diagram(listdata), labeldiagram);
        vBox2.setAlignment(Pos.CENTER);
        StackPane stackPane = new StackPane(rectangle, vBox2);
        rectangle.setId("dashRectangle");

        return stackPane;
    }

    public static PieChart pieChart(ArrayList<Double> arrayList) {
        int lastData = arrayList.size() - 1;
        PieChart.Data max = new PieChart.Data("", 8);
        PieChart.Data minum = new PieChart.Data("", arrayList.size() == 0 ? 0 : arrayList.get(lastData) < 8 ? arrayList.get(lastData) : 8);

        PieChart pieChart = new PieChart();
        pieChart.getData().addAll(max, minum);

        pieChart.setPrefWidth(15);
        pieChart.setPrefHeight(15);

        return pieChart;
    }
    public static StackPane rectanglesum(String kategori, double angka) {
        Label Nilai = new Label(String.format("%d",(int) angka));
        Nilai.setStyle("-fx-font-size:40px;");
        Label Kategori = new Label(kategori);
        Label Type = new Label(kategori(kategori,angka));
        VBox vBox = new VBox(5,Kategori,Type);
        vBox.setAlignment(Pos.CENTER);
        HBox hBox = new HBox(10,Nilai,vBox);
        hBox.setAlignment(Pos.CENTER);
        Rectangle rectangle = new Rectangle(230, 180);
        rectangle.setArcWidth(35);
        rectangle.setArcHeight(35);
        rectangle.setId("SUM");
        StackPane stackPane = new StackPane(rectangle,hBox);
        stackPane.setPadding(new Insets(10));
        return stackPane;
    }
    public static StackPane saran(double bmi, double tekdar, double guldar, double konsumsi) throws SQLException {
        String[] list = {kategori("BMI",bmi), kategori("Tekanan Darah",tekdar), kategori("Gula Darah",guldar), kategori("Konsumsi Air", konsumsi)};
        FlowPane flowPane = new FlowPane();
        ArrayList<Button> listButton = new ArrayList<>();
        for (String kategori : list){
            Connection connection = DriverManager.getConnection("jdbc:sqlite:" + "D:/Programming/Java/MACHealth/src/main/resources/Database/MACHealth.db");
            String query = String.format("SELECT * FROM SARAN WHERE KATEGORI = '%s'", kategori);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                String pesan = resultSet.getString("SARAN");
                Button button = new Button(pesan);
                button.setPrefSize(20,pesan.length());
                button.setId("Saran");
                listButton.add(button);
            }
        }
        flowPane.getChildren().addAll(listButton);
        flowPane.setAlignment(Pos.CENTER);
        flowPane.setHgap(10);
        flowPane.setVgap(10);
        flowPane.setPrefWidth(490);
        flowPane.setPrefHeight(490);


        Rectangle rectangle = new Rectangle(1000,500 );
        StackPane stackPane = new StackPane(rectangle,flowPane);
        rectangle.setArcWidth(35);
        rectangle.setArcHeight(35);
        rectangle.setId("SUM");

        StackPane.setAlignment(rectangle, Pos.CENTER);
        StackPane.setAlignment(flowPane, Pos.TOP_CENTER);
        stackPane.setPadding(new Insets(0,10,10,10));

        return stackPane;
    }

    public static String kategori(String kategori, double angka) {
        switch (kategori) {
            case "Tekanan Darah":
                if (90 <= angka && angka <= 120) {
                    return "Aman";
                } else {
                    return (angka > 120 ? "Tinggi" : "Rendah");
                }
            case "BMI":
                if (18.5 <= angka && angka <= 24.9) {
                    return "Ideal";
                } else {
                    return (angka > 24.9 ? "Obesitas" : "Kurus");
                }
            case "Gula Darah":
                if (140 <= angka) {
                    return "Prediabetes";
                } else {
                    return (70 <= angka && angka < 140 ? "Normal" : "Hipoglikemia");
                }
            case "Konsumsi Air":
                if (angka >= 8) {
                    return "Cukup";
                } else {
                    return "Kurang";
                }
            default:
                return null;
        }
    }
}

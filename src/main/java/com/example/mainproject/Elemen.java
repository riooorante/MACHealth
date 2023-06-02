package com.example.mainproject;

import javafx.geometry.Pos;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;

public class Elemen {
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
        PieChart.Data minum = new PieChart.Data("", arrayList.get(lastData) < 8 ? arrayList.get(lastData) : 8);

        PieChart pieChart = new PieChart();
        pieChart.getData().addAll(max, minum);

        pieChart.setPrefWidth(15);
        pieChart.setPrefHeight(15);



        return pieChart;
    }

}

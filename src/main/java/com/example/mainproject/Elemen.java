package com.example.mainproject;

import javafx.geometry.Pos;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;

import java.util.List;

public class Elemen {
    public static LineChart<Number, Number> diagram(List<Double> doubles) {
        NumberAxis xAxis = new NumberAxis();
        NumberAxis yAxis = new NumberAxis();

        LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);
        XYChart.Series<Number, Number> series = new XYChart.Series<>();

        for (int i = 0; i < doubles.size(); i++) {
            series.getData().add(new XYChart.Data<>(i++, doubles.get(i)));
        }

        lineChart.getData().add(series);
        lineChart.setPrefSize(200,300);

        return lineChart;
    }
    public static StackPane dashRectangle(String label, List<Double> listdata){
        Rectangle rectangle = new Rectangle(490, 350);
        rectangle.setArcWidth(20);
        rectangle.setArcHeight(20);
        Label labeldiagram = new Label(label);
        VBox vBox2 = new VBox(10,diagram(listdata),labeldiagram);
        vBox2.setAlignment(Pos.CENTER);
        StackPane stackPane = new StackPane(rectangle,vBox2);
        rectangle.setId("dashRectangle");

        return stackPane;
    }
}

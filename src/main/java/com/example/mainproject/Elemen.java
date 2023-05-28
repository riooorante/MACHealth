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
        lineChart.lookup(".chart-vertical-grid-lines").setVisible(false);
        lineChart.lookup(".chart-horizontal-grid-lines").setVisible(false);
        lineChart.getYAxis().setTickLabelsVisible(false);
        lineChart.getYAxis().setOpacity(0);
        lineChart.getXAxis().setTickLabelsVisible(false);
        lineChart.getXAxis().setOpacity(0);

        series.getData().add(new XYChart.Data<>(1,2));
        series.getData().add(new XYChart.Data<>(2,7));
        series.getData().add(new XYChart.Data<>(3,9));
        series.getData().add(new XYChart.Data<>(4,4));


        lineChart.getData().add(series);
        lineChart.setPrefSize(200,300);
        lineChart.setLegendVisible(false);

        return lineChart;
    }
    public static StackPane dashRectangle(String label, List<Double> listdata){
        Rectangle rectangle = new Rectangle(490, 350);
        rectangle.setArcWidth(35);
        rectangle.setArcHeight(35);
        Label labeldiagram = new Label(label);
        VBox vBox2 = new VBox(diagram(listdata),labeldiagram);
        vBox2.setAlignment(Pos.CENTER);
        StackPane stackPane = new StackPane(rectangle,vBox2);
        rectangle.setId("dashRectangle");

        return stackPane;
    }
}

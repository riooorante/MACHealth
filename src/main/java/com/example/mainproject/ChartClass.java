package com.example.mainproject;

import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

import java.util.List;

public class ChartClass {
    public static LineChart<Number, Number> diagram(List<Double> doubles) {
        NumberAxis xAxis = new NumberAxis();
        NumberAxis yAxis = new NumberAxis();
        xAxis.setTickLabelsVisible(false);
        yAxis.setTickLabelsVisible(false);
        LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);
        XYChart.Series<Number, Number> series = new XYChart.Series<>();
        for (int i = 0; i < doubles.size(); i++) {
            series.getData().add(new XYChart.Data<>(i++, doubles.get(i)));
        }
        lineChart.getData().add(series);
        return lineChart;
    }
}

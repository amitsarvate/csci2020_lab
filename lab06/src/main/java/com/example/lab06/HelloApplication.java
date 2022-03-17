package com.example.lab06;

import javafx.application.Application;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Side;
import javafx.scene.Scene;
import javafx.scene.chart.*;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.layout.StackPane;

public class HelloApplication extends Application {

    private static double[] avgHousingPricesByYear = {
            247381.0,264171.4,287715.3,294736.1,
            308431.4,322635.9,340253.0,363153.7
    };
    private static double[] avgCommercialPricesByYear = {
            1121585.3,1219479.5,1246354.2,1295364.8,
            1335932.6,1472362.0,1583521.9,1613246.3
    };

    private static String[] ageGroups = {
            "18-25", "26-35", "36-45", "46-55", "56-65", "65+"
    };
    private static int[] purchasesByAgeGroup = {
            648, 1021, 2453, 3173, 1868, 2247
    };
    private static Color[] pieColours = {
            Color.AQUA, Color.GOLD, Color.DARKORANGE,
            Color.DARKSALMON, Color.LAWNGREEN, Color.PLUM
    };


    public void start(Stage stage) {

        CategoryAxis xAxis = new CategoryAxis();
        NumberAxis yAxis = new NumberAxis();

        //Adding labels for the axes
        yAxis.setLabel("Price");
        xAxis.setLabel("Categories");

        //Creating a Bar chart
        BarChart barChart = new BarChart<>(xAxis, yAxis);

        barChart.setTitle("Housing vs Commercial Price By Year");

        //Preparing data for the bar chart
        XYChart.Series series1 = new XYChart.Series();
        series1.setName("Housing");

        for (int i = 0; i < avgHousingPricesByYear.length; i++) {
            series1.getData().add(new XYChart.Data("200" + Integer.toString(i), avgHousingPricesByYear[i]));
        }

        //Preparing data for the bar chart
        XYChart.Series series2 = new XYChart.Series();
        series2.setName("Commercial");

        for (int i = 0; i < avgCommercialPricesByYear.length; i++) {
            series2.getData().add(new XYChart.Data("200" + Integer.toString(i), avgCommercialPricesByYear[i]));
        }

        barChart.getData().addAll(series1, series2);

        //Setting the legend on the top
        barChart.setLegendSide(Side.RIGHT);
        //Creating a stack pane to hold the chart

        ObservableList<PieChart.Data> pieChartData;
        pieChartData = FXCollections.observableArrayList();

        for (int i = 0; i < ageGroups.length; i++) {
            pieChartData.add(new PieChart.Data(ageGroups[i], purchasesByAgeGroup[i]));
        }

        PieChart pieChart = new PieChart(pieChartData);
        pieChart.setTitle("Age Group Spending");
        pieChart.setClockwise(true);
        pieChart.setLabelLineLength(50);
        pieChart.setLabelsVisible(true);
        pieChart.setStartAngle(180);

        // shifting the piechart to the right a bit to not overlap the barchart
        pieChart.setLayoutX(600);

        StackPane rootPane = new StackPane();

        Scene scene = new Scene(rootPane, 1200, 400);
        Pane pane1 = new Pane(barChart);
        Pane pane2 = new Pane(pieChart);
        rootPane.getChildren().addAll(pane1, pane2);
        stage.setTitle("Charts For Lab 06");
        stage.setScene(scene);
        stage.show();

    }
    public static void main(String args[]){
        launch(args);
    }
}
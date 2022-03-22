package com.example.lab07;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {

    private static int[] eventCounts;

    static {
        try {
            eventCounts = CSVReader.readCSV();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String[] events = {
            "SEVERE THUNDERSTORM", "SPECIAL MARINE", "FLASH FLOOD", "TORNADO"
    };

    private static Color[] pieColours = {
            Color.AQUA, Color.GOLD, Color.DARKORANGE,
            Color.DARKSALMON, Color.LAWNGREEN
    };


    @Override
    public void start(Stage stage) {

        ObservableList<PieChart.Data> pieChartData;
        pieChartData = FXCollections.observableArrayList();

        for (int i = 0; i < eventCounts.length; i++) {
            pieChartData.add(new PieChart.Data(events[i], eventCounts[i]));
        }

        PieChart pieChart = new PieChart(pieChartData);
        pieChart.setTitle("Weather Events Frequencies");
        pieChart.setClockwise(true);
        pieChart.setLabelLineLength(50);
        pieChart.setLabelsVisible(true);
        pieChart.setStartAngle(180);

        StackPane rootPane = new StackPane();
        Scene scene = new Scene(rootPane, 500, 400);
        Pane pane = new Pane(pieChart);
        rootPane.getChildren().addAll(pane);

        stage.setTitle("Lab07 - Weather Event Frequencies");
        stage.setScene(scene);
        stage.show();


    }

    public static void main(String[] args) {
        launch();
    }

}
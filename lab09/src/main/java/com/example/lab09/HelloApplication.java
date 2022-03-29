package com.example.lab09;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;

public class HelloApplication extends Application {

    private static ArrayList<Float> googlePrice = new ArrayList<Float>();
    private static ArrayList<Float> applePrice = new ArrayList<Float>();


    // reading data from the live URL
    public static ArrayList<Float> downloadStockPrices(String company) throws IOException {

        ArrayList<Float> price = new ArrayList<Float>();

        try {
            URL url = new URL("https://query1.finance.yahoo.com/v7/finance/download/" + company + "?period1=1262322000&period2=1451538000&interval=1mo&events=history&includeAdjustedClose=true");
            URLConnection yc = url.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader((yc.getInputStream())));

            String inputLine;
            int count = 0;

            while ((inputLine = in.readLine()) != null) {
                String row[] = inputLine.split(",");

                if (count > 0) {
                    float entry = Float.parseFloat(row[4]);
                    price.add(entry);
                }

                count++;
            }

            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return price;

    }

    @Override
    public void start(Stage stage) throws IOException {

        // Downloading specific respective data using the method created
        googlePrice = downloadStockPrices("GOOG");
        applePrice = downloadStockPrices("AAPL");

        // Initializing axi
        NumberAxis xAxis = new NumberAxis(0, googlePrice.size(), 12);
        xAxis.setLabel("Months");

        NumberAxis yAxis = new NumberAxis(0, 1000, 100);
        yAxis.setLabel("Price of Stock");

        // Creating line chart
        LineChart linechart = new LineChart(xAxis, yAxis);

        // Linechart display settings
        linechart.setPrefWidth(800);
        linechart.setPrefHeight(600);
        linechart.setCreateSymbols(false);
        linechart.setTitle("Stock Price Growth Trends");

        // Google series data
        XYChart.Series googleSeries = new XYChart.Series();
        googleSeries.setName("GOOG");

        // Populating the series
        for (int i = 0; i < googlePrice.size(); i++) {
            googleSeries.getData().add(new XYChart.Data(i, googlePrice.get(i)));
        }

        // Apple series data
        XYChart.Series appleSeries = new XYChart.Series();
        appleSeries.setName("AAPL");

        // Populating the apple series
        for (int i = 0; i < applePrice.size(); i++) {
            appleSeries.getData().add(new XYChart.Data(i, applePrice.get(i)));
        }

        // put the series in to the linechart
        linechart.getData().addAll(googleSeries, appleSeries);

        // setting the linechart on the panes and scenes
        Group root = new Group(linechart);

        Scene scene = new Scene(root, 800, 650);

        stage.setTitle("Lab 09 - Stock Price Trend Graphs");
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) throws IOException {
        launch();

    }
}
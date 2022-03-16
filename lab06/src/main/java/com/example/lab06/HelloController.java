package com.example.lab06;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    private static double[] avgHousingPricesByYear = {
            247381.0,264171.4,287715.3,294736.1,
            308431.4,322635.9,340253.0,363153.7
    };
    private static double[] avgCommercialPricesByYear = {
            1121585.3,1219479.5,1246354.2,1295364.8,
            1335932.6,1472362.0,1583521.9,1613246.3
    };


    @FXML
    private BarChart barchart;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        XYChart.Series series1 = new XYChart.Series();
        series1.setName("Housing");
        series1.getData().add(new XYChart.Data("2003", 2342));
        series1.getData().add(new XYChart.Data("2004", 2134));
        series1.getData().add(new XYChart.Data("2005", 2653));

        barchart.getData().addAll(series1);
    }

}

package com.example.lab05;

import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AnimationView implements Initializable {


    @FXML
    private Button backtomainbtn;

    @FXML
    private Circle shape;

    // when the button is pressed the main menu scene will be shown
    @FXML
    void backtomain(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        Scene scene = new Scene(parent);
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resources) {
        TranslateTransition translateHorizontal = new TranslateTransition();
        translateHorizontal.setNode(shape);
        translateHorizontal.setDuration(Duration.millis(2000));
        translateHorizontal.setCycleCount(2);
        translateHorizontal.setByX(500);
        translateHorizontal.setAutoReverse(true);
        translateHorizontal.play();
    }
}

package com.example.lab05;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloController {

    @FXML
    private Button aboutbtn;

    @FXML
    private Button animationbtn;

    @FXML
    private Button graphicsbtn;

    // when clicked shows the about scene
    @FXML
    void aboutload(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("about-view.fxml"));
        Scene scene = new Scene(parent);
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    // when click shows the animation scene
    @FXML
    void animationload(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("animation-view.fxml"));
        Scene scene = new Scene(parent);
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();


    }

    // when clicked shows the graphics scene
    @FXML
    void graphicsload(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("graphics-view.fxml"));
        Scene scene = new Scene(parent);
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();

    }

}

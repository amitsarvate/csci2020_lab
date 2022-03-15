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

public class GraphicsView {



    @FXML
    private Button backtomainbtn;

    // when the button is pressed the main menu scene will be shown
    @FXML
    void backtomain(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        Scene scene = new Scene(parent);
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

}

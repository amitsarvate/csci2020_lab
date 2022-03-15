package com.example.lab05;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AboutView implements Initializable {


    // components of the AboutView
    @FXML
    private Button backtomainbtn;

    @FXML
    private Text email;

    @FXML
    private Text soft_desc;

    @FXML
    private Text studentname;


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
        String[] result = ReadXMLParser.readXML();
        studentname.setText("My name is " + result[1] + ". My Student ID is " + result[0]);
        email.setText("Shoot me a message! Here is my email: " + result[2]);
        soft_desc.setText(result[3]);

    }
}




package com.example.lab10;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class ClientController {

    @FXML
    private Button exitBtn;

    @FXML
    private TextField msgInput;

    @FXML
    private Label msgLabel;

    @FXML
    private Button sendBtn;

    @FXML
    private TextField usrInput;

    @FXML
    private Label usrLabel;

    @FXML
    void exitBtnOnClick(ActionEvent event) {
        Platform.exit();
    }

    @FXML
    void sendBtnOnClick(ActionEvent event) {

        String message = MyApplication.isServer ? "Server: " : usrInput.getText();
        message += msgInput.getText();
        msgInput.clear();

        ServerController.textArea.appendText(message + "\n");

        try {
            MyApplication.connection.send(message);
        } catch (Exception e) {
            ServerController.textArea.appendText("Failed to Send \n");
        }

    }

}

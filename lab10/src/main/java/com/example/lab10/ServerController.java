package com.example.lab10;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class ServerController {

    @FXML
    private Button exitBtn;

    @FXML
    public static TextArea textArea;

    @FXML
    void exitBtnOnClick(ActionEvent event) {
        Platform.exit();

    }

}

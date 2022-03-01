package com.example.javafxproject;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class HelloController {

    final String phonePattern  = "(\\d{3}(\\d{3}(\\d{4})";
    final String phoneFormat = "$1-$2-$3";

    @FXML
    private Label usernameLabel;
    @FXML
    private TextField username;

    @FXML
    private Label passwordLabel;
    @FXML
    private PasswordField password;

    @FXML
    private Label fullNameLabel;
    @FXML
    private TextField fullName;

    @FXML
    private Label emailLabel;
    @FXML
    private TextField email;

    @FXML
    private Label phoneNumberLabel;
    @FXML
    private TextField phoneNumber;

    @FXML
    private Label dobLabel;
    @FXML
    private DatePicker dob;

    @FXML
    private Button register;

    public void handleButtonClick() {
        System.out.println("Full Name: " + fullName.getText());
        System.out.println("Email: " + email.getText());
        System.out.println("Phone #: " + phoneNumber.getText());
        System.out.println("DOB: " + dob.getValue());
    }

}
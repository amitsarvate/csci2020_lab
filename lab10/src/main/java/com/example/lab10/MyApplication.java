package com.example.lab10;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.IOException;

public class MyApplication extends Application {

    public static boolean isServer = true;
    public static Connection connection = isServer ? createServer() : createClient();

    private Parent createContent() throws IOException {

        Parent root;

        if (isServer) {
            root = createServerUI();
        } else {
            root = createClientUI();
        }

        return root;
    }

    private Parent createServerUI() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("server.fxml"));
        return root;
    }

    private Parent createClientUI() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("client.fxml"));
        return root;
    }

    @Override
    public void init() throws Exception {
        connection.startConnection();
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setScene(new Scene(createContent()));
        stage.show();
    }

    @Override
    public void stop() throws Exception {
        connection.closeConnection();
    }

    private static Server createServer() {
        return new Server(55555, data -> {
            Platform.runLater(() -> {
                ServerController.textArea.appendText(data.toString() + "\n");
            });
        });
    }

    private static Client createClient() {
        return new Client("127.0.0.1", 55555, data->{
            Platform.runLater(() -> {
            });
        });
    }

    public static void main(String[] args) {
        launch(args);
    }
}

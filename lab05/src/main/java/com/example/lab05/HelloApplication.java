package com.example.lab05;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {

    Stage window;
    TableView<StudentRecord> table;

    @Override
    public void start(Stage stage) throws IOException {
        window = stage;
        window.setTitle("Lab 05 - Student Records Table");

        // Student ID Column
        TableColumn<StudentRecord, String> idCol = new TableColumn<>("Student ID");
        idCol.setMinWidth(200);
        idCol.setCellValueFactory(new PropertyValueFactory<>("Student ID"));

        // Midterm Column
        TableColumn<StudentRecord, Float> midtermCol = new TableColumn<>("Midterm");
        midtermCol.setMinWidth(100);
        midtermCol.setCellValueFactory(new PropertyValueFactory<>("Midterm"));

        // Assignment Column
        TableColumn<StudentRecord, Float> assignmentCol = new TableColumn<>("Assignment");
        assignmentCol.setMinWidth(100);
        assignmentCol.setCellValueFactory(new PropertyValueFactory<>("Assignment"));

        // Exam Column
        TableColumn<StudentRecord, Float> examCol = new TableColumn<>("Final Exam");
        examCol.setMinWidth(100);
        examCol.setCellValueFactory(new PropertyValueFactory<>("Final Exam"));

        // Final Mark Column
        TableColumn<StudentRecord, Float> finalMarkCol = new TableColumn<>("Final Mark");
        examCol.setMinWidth(100);
        examCol.setCellValueFactory(new PropertyValueFactory<>("Final Mark"));

        // Letter Grade Column
        TableColumn<StudentRecord, Float> letterGradeCol = new TableColumn<>("Letter Grade");
        examCol.setMinWidth(100);
        examCol.setCellValueFactory(new PropertyValueFactory<>("Letter Grade"));


        table = new TableView<>();
        table.setItems(DataSource.getAllMarks());
        table.getColumns().addAll(idCol, midtermCol, assignmentCol, examCol, finalMarkCol, letterGradeCol);


        VBox vBox = new VBox();
        vBox.getChildren().addAll(table);

        Scene scene = new Scene(vBox);
        window.setScene(scene);
        window.show();

    }

    public static void main(String[] args) {
        launch();
    }

}
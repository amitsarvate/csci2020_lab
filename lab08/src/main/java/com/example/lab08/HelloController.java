package com.example.lab08;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    public String CURRENTFILENAME;

    FileChooser fileChooser = new FileChooser();

    @FXML
    private Button addbtn;

    @FXML
    private TableColumn<StudentRecord, Float> assigncol;

    @FXML
    private TextField assigninput;

    @FXML
    private Label assignlabel;

    @FXML
    private MenuItem exitoption;

    @FXML
    private TableColumn<StudentRecord, Float> exmcol;

    @FXML
    private TextField exminput;

    @FXML
    private Label exmlabel;

    @FXML
    private TableColumn<StudentRecord, Float> finalmarkcol;

    @FXML
    private TableColumn<StudentRecord, Float> lettergrdcol;

    @FXML
    private Menu mainmenu;

    @FXML
    private MenuBar menubar;

    @FXML
    private TableColumn<StudentRecord, Float> midcol;

    @FXML
    private TextField midinput;

    @FXML
    private Label midlabel;

    @FXML
    private MenuItem newoption;

    @FXML
    private MenuItem openoption;

    @FXML
    private MenuItem saveasoption;

    @FXML
    private MenuItem saveoption;

    @FXML
    private TableColumn<StudentRecord, Float> stucol;

    @FXML
    private TextField stuidinput;

    @FXML
    private Label stuidlabel;

    @FXML
    private TableView<StudentRecord> table;

    ObservableList<StudentRecord> studentRecordData;

    public void addRecord(String SID, float midterm, float assignment, float exam) {
        studentRecordData.add(new StudentRecord(SID, midterm, assignment, exam));
    }

    @FXML
    void addBtnClicked(ActionEvent event) {

        // getting values from text field and creating a new list item within the observable list
        String SID = stuidinput.getText();
        float assignmentGrade = Float.parseFloat(assigninput.getText());
        float midtermGrade = Float.parseFloat(midinput.getText());
        float examGrade = Float.parseFloat(exminput.getText());

        // adding record into the observable list
        addRecord(SID, assignmentGrade, midtermGrade, examGrade);

        table.setItems(studentRecordData);

        // resetting the fields
        stuidinput.setText("");
        assigninput.setText("");
        midinput.setText("");
        exminput.setText("");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        // initial file name
        CURRENTFILENAME = "/Users/amit.sar21/University/Second Year/Semester 2 /Systems Development and Integration - CSCI 2020/labs/lab08/src/studentRecordOutput.csv";
        studentRecordData = FXCollections.observableArrayList();

        // setting up the columns of the table view
        stucol.setCellValueFactory(new PropertyValueFactory<>("StudentID"));
        midcol.setCellValueFactory(new PropertyValueFactory<>("Midterm"));
        assigncol.setCellValueFactory(new PropertyValueFactory<>("Assignment"));
        exmcol.setCellValueFactory(new PropertyValueFactory<>("Exam"));
        finalmarkcol.setCellValueFactory(new PropertyValueFactory<>("FinalMark"));
        lettergrdcol.setCellValueFactory(new PropertyValueFactory<>("LetterGrade"));

    }

    @FXML
    // clear the table for new rows
    public void newOptionClicked(ActionEvent event) {
        studentRecordData.remove(0, studentRecordData.size());
    }

    @FXML
    // opens a selected file into the table
    public void openOptionClicked(ActionEvent event) throws Exception {

        // selecting the file to open
        File chosenFile = fileChooser.showOpenDialog(new Stage());
        if (chosenFile != null) {
            // loading data from that file
            CURRENTFILENAME = chosenFile.getPath();
            load();
        }

    }

    @FXML
    // saves the file (writing data to csv)
    public void saveOptionClicked(ActionEvent event) throws Exception {
        save();
    }

    // save as the file (writing data to csv)
    public void saveAsOptionClicked(ActionEvent event) throws Exception {
        File chosenFile = fileChooser.showSaveDialog(new Stage());

        if (chosenFile != null) {
            // loading data from a file
            CURRENTFILENAME = chosenFile.getPath();
            save();
        }

    }

    // exit function
    public void exitOptionClicked(ActionEvent event) {
        System.exit(0);
    }

    // save function
    public void save() throws Exception {
        Writer csvWriter = null;
        try {
            File file = new File(CURRENTFILENAME);
            csvWriter = new BufferedWriter((new FileWriter(file)));

            for (StudentRecord student : studentRecordData) {
                String line = student.getStudentID() + "," + student.getAssignment() + "," + student.getMidterm() + "," + student.getExam() + "\n";
                csvWriter.write(line);

            }
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            csvWriter.flush();
            csvWriter.close();
        }

    }

    // loads data from csv
    public void load() throws Exception {
        BufferedReader csvReader = null;
        String line = "";

        try {
            csvReader = new BufferedReader(new FileReader(CURRENTFILENAME));
            while ((line = csvReader.readLine()) != null) {
                String[] row = line.split(",");

                // add record to list
                addRecord(row[0], Float.parseFloat(row[1]), Float.parseFloat(row[2]), Float.parseFloat(row[3]));
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            csvReader.close();
        }

        // update table with rows
        table.setItems(studentRecordData);
    }

}

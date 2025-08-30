package com.frogman650;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
//https://www.youtube.com/watch?v=9XJicRt_FaI&t=1538s
public class Controller1 implements Initializable {
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private Label primaryText;
    @FXML
    private Label secondaryText;
    @FXML
    private Label bodyText;
    @FXML
    private Label errorText;

    public void nextButtonAction(ActionEvent event) {
        try {
            root = FXMLLoader.load(getClass().getResource("scene2.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            scene.getStylesheets().add(this.getClass().getResource("app.css").toExternalForm());
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            App.exceptionText = "exception thrown while changing to scene 2";
            System.out.println("exception thrown while changing to scene 2\n" + e);
        }
        if (!App.exceptionText.equals("")) {
            errorText.setText(App.exceptionText);
        }
    }
    public void cancelButtonAction(ActionEvent e) {
        javafx.application.Platform.exit();
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        primaryText.setText("Introduction");
        secondaryText.setText("Welcome to the CNC12 Update wizard!");
        bodyText.setText("Using this tool you can easily update CNC12 for Acorn, AcornSix, and Hickory (with wizard) and transfer your settings to the new version. " + 
        "Be mindful that this tool does not set anything new that is added. It is your responsibility as the updater to familiarize " + 
        "yourself with any changes made between the old version and new and adjust settings accordingly.");
    }
}

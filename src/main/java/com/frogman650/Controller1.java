package com.frogman650;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
//https://www.youtube.com/watch?v=9XJicRt_FaI&t=1538s
public class Controller1 implements Initializable {
    @FXML
    private Label primaryText;
    @FXML
    private Label secondaryText;
    @FXML
    private Label bodyText;
    @FXML
    private ProgressBar progressBar;

    double progress;

    public void nextButtonAction(ActionEvent e) {
        System.out.println("next button");
        progressBar.setProgress(progress += 0.1);
    }
    public void backButtonAction(ActionEvent e) {
        System.out.println("back button");
        progressBar.setProgress(progress -= 0.1);
    }
    public void cancelButtonAction(ActionEvent e) {
        System.out.println("cancel button");
        progressBar.setProgress(0);
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        primaryText.setText("Introduction");
        secondaryText.setText("Welcome to the CNC12 Update wizard!");
        bodyText.setText("Using this tool you can easily update CNC12 for Acorn, AcornSix, and Hickory (with wizard) and transfer your settings to the new version. " + 
        "Be mindful that this tool does not set anything new that is added. It is your responsibility as the updater to familiarize " + 
        "yourself with any changes made between the old version and new.");
    }
}

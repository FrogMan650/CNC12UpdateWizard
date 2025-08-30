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
public class Controller2 implements Initializable {
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private Label primaryText;
    @FXML
    private Label secondaryText;
    @FXML
    private Label bodyText;

    public void nextButtonAction(ActionEvent event) {
        try {
            root = FXMLLoader.load(getClass().getResource("scene3.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            scene.getStylesheets().add(this.getClass().getResource("app.css").toExternalForm());
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            System.out.println("exception thrown while changing to scene 3\n" + e);
        }
    }
    public void backButtonAction(ActionEvent event) {
        try {
            root = FXMLLoader.load(getClass().getResource("scene1.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            scene.getStylesheets().add(this.getClass().getResource("app.css").toExternalForm());
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            System.out.println("exception thrown while changing to scene 1\n" + e);
        }
    }
    public void cancelButtonAction(ActionEvent e) {
        javafx.application.Platform.exit();
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        primaryText.setText("Getting started");
        secondaryText.setText("Renaming directories and new install");
        bodyText.setText("First, we need to rename the current cnc* directory in the C: drive based on the type of machine it is:\nMill = 'old cncm'\n" + 
        "Lathe = 'old cnct'\nRouter = 'old cncr'\nPlasma = 'old cncp'\nLaser = 'old cncl'\n\nEven if your directory previously was for instance 'cncm'" + 
        ", it needs to be renamed to 'old cncr' if it's a router.\n\nFollowing this, download the latest CNC12 installer from the Centroid website and " + 
        "install the latest version of CNC12. With CNC12 closed, move on to the next step.");
    }
}

package com.frogman650;

import java.io.IOException;
import java.net.URL;
import java.util.Map;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Controller implements Initializable {
    public static int counter = 1;
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private ScrollPane errorText;
    @FXML
    private ScrollPane scrollPane;
    @FXML
    private Label keyALabel;
    @FXML
    private Label boardLabel;
    @FXML
    private Label versionLabel;

    public void nextButtonAction(ActionEvent event) {
        App.exceptionText.clear();
        App.warningText.clear();
        App.successText.clear();
        counter ++;
        if (counter == 4 && !App.usbBobInstalled) {
            counter ++;
        }
        if (counter == 2) {
        }
        if (counter == 3) {
            App.directoryName = "";
            App.setDirectoryName();
            App.getOldBoard();
            App.setOldBoardSoftwareInfo();
            App.checkBoardAndVersion();
            App.checkBoards();
            App.checkKeyA();
            App.copyLicense();
            App.createPresetIO();
            App.setNewBoardSoftwareInfo();
            App.transferParms();
            App.transferConfig();
            App.transferWizardSettings();
            App.setHomingType();
        }
        if (counter == 4) {
        }
        if (counter == 5) {
        }
        if (counter == 6) {
            App.copyOffsetLibrary();
            App.copyWCS();
            App.copyStats();
            App.copyToolLibrary();
            App.copyScales();
            App.transferCarouselSettings();
            App.transferRackMount();
            App.transferPlasmaConfig();
            App.transferOptions();
            App.transferBobConfig();
            App.transferParms();
            App.transferWizardSettings();
            App.copyHomeFile();
            App.copyToolChangeFile();
            App.copyParkMacro();
        }
        if (App.exceptionText.isEmpty()) {
            newScene(event, "scene" + counter + ".fxml");
        } else {
            VBox vBox = new VBox();
            for (int i = 0; i < App.exceptionText.size(); i++) {
                Label tempLabel = new Label(i+1 + ". " + App.exceptionText.get(i));
                tempLabel.setTextFill(Color.RED);
                vBox.getChildren().add(tempLabel);
            }
            for (int i = 0; i < App.warningText.size(); i++) {
            Label tempLabel = new Label(i+1 + ". " + App.warningText.get(i));
            tempLabel.setTextFill(Color.ORANGE);
            vBox.getChildren().add(tempLabel);
            }
            for (int i = 0; i < App.successText.size(); i++) {
            Label tempLabel = new Label(i+1 + ". " + App.successText.get(i));
            tempLabel.setTextFill(Color.GREEN);
            vBox.getChildren().add(tempLabel);
            }
            errorText.setContent(vBox);
            counter --;
        }
    }

    public void backButtonAction(ActionEvent event) {
        App.exceptionText.clear();
        App.warningText.clear();
        App.successText.clear();
        if (counter == 5 && !App.usbBobInstalled) {
            counter --;
        }
        counter --;
        newScene(event, "scene" + counter + ".fxml");
    }

    public void cancelButtonAction(ActionEvent e) {
        javafx.application.Platform.exit();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        keyALabel.setText(App.newBoardKeyA);
        boardLabel.setText(App.board);
        if (counter > 2) {
            versionLabel.setText(App.oldversionRaw + " -> " + App.newversionRaw);
        }
        VBox vBox = new VBox();
        for (int i = 0; i < App.warningText.size(); i++) {
            Label tempLabel = new Label(i+1 + ". " + App.warningText.get(i));
            tempLabel.setTextFill(Color.ORANGE);
            vBox.getChildren().add(tempLabel);
        }
        for (int i = 0; i < App.successText.size(); i++) {
            Label tempLabel = new Label(i+1 + ". " + App.successText.get(i));
            tempLabel.setTextFill(Color.GREEN);
            vBox.getChildren().add(tempLabel);
        }
        errorText.setContent(vBox);
        if (counter == 4) {
            VBox vBox2 = new VBox();
            for (Map.Entry<String, String> entry : App.usbInputsMap.entrySet()) {
                vBox2.getChildren().add(new Label(entry.getKey() + " " + entry.getValue()));
            }
            scrollPane.setContent(vBox2);
        }
    }

    public void newScene(ActionEvent event, String fxmlScene) {
        try {
            root = FXMLLoader.load(getClass().getResource(fxmlScene));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            scene.getStylesheets().add(this.getClass().getResource("app.css").toExternalForm());
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            App.exceptionText.add("Error changing scenes\n    " + e);
        }
    }
}

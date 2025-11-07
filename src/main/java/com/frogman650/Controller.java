package com.frogman650;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Map;
import java.util.ResourceBundle;

import javafx.beans.binding.Bindings;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class Controller implements Initializable {
    public static int counter = 1;
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private ScrollPane errorText;
    @FXML
    private ScrollPane bodyText;
    @FXML
    private Label keyALabel;
    @FXML
    private Label boardLabel;
    @FXML
    private Label versionLabel;
    @FXML
    private AnchorPane anchorPane;
    @FXML
    private Line line;
    @FXML
    private Line line2;
    @FXML
    private ProgressBar progressBar;
    @FXML
    private Button nextButton;
    @FXML
    private Button cancelButton;
    @FXML
    private Button backButton;
    @FXML
    private Button finishButton;

    public void nextButtonAction(ActionEvent event) {
        App.resetMessageBox();
        counter ++;
        if (counter == 4 && !App.usbBobInstalled) {
            counter ++;
        }
        if (counter == 2) {
        }
        if (counter == 3) {
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
            //App.transferWizardSettings();
            App.copyHomeFile();
            App.copyToolChangeFile();
            App.copyParkMacro();
        }
        if (App.exceptionText.isEmpty()) {
            newScene(event, "scene" + counter + ".fxml");
        } else {
            VBox messageWindowVBox = new VBox();
            for (int i = 0; i < App.exceptionText.size(); i++) {
                Label tempLabel = new Label(i+1 + ". " + App.exceptionText.get(i));
                tempLabel.setTextFill(Color.RED);
                tempLabel.setWrapText(true);
                messageWindowVBox.getChildren().add(tempLabel);
            }
            for (int i = 0; i < App.warningText.size(); i++) {
                Label tempLabel = new Label(i+1 + ". " + App.warningText.get(i));
                tempLabel.setTextFill(Color.ORANGE);
                tempLabel.setWrapText(true);
                messageWindowVBox.getChildren().add(tempLabel);
            }
            for (int i = 0; i < App.successText.size(); i++) {
                Label tempLabel = new Label(i+1 + ". " + App.successText.get(i));
                tempLabel.setTextFill(Color.GREEN);
                tempLabel.setWrapText(true);
                messageWindowVBox.getChildren().add(tempLabel);
            }
            errorText.setContent(messageWindowVBox);
            counter --;
        }
    }

    public void backButtonAction(ActionEvent event) {
        App.resetMessageBox();
        if (counter == 3) {
            App.resetBoardInfo();
        }
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
        VBox bodyTextVBox = new VBox();
        bodyTextVBox.prefWidthProperty().bind(bodyText.widthProperty());
        VBox messageWindowVBox = new VBox();
        messageWindowVBox.prefWidthProperty().bind(errorText.widthProperty());

        AnchorPane.setTopAnchor(bodyText, 119.0);
        AnchorPane.setRightAnchor(bodyText, 35.0);
        AnchorPane.setBottomAnchor(bodyText, 119.0);
        AnchorPane.setLeftAnchor(bodyText, 35.0);
        bodyTextVBox.setPadding(new Insets(0, 22, 0, 0));

        AnchorPane.setTopAnchor(line, 100.0);
        AnchorPane.setLeftAnchor(line, 35.0);
        line.endXProperty().bind(Bindings.createDoubleBinding(() -> bodyText.getWidth()+35.0, bodyText.widthProperty()));

        AnchorPane.setBottomAnchor(line2, 100.0);
        AnchorPane.setLeftAnchor(line2, 35.0);
        line2.endXProperty().bind(Bindings.createDoubleBinding(() -> bodyText.getWidth()+35.0, bodyText.widthProperty()));

        AnchorPane.setTopAnchor(progressBar, 0.0);
        AnchorPane.setRightAnchor(progressBar, 0.0);
        AnchorPane.setLeftAnchor(progressBar, 0.0);

        AnchorPane.setRightAnchor(errorText, 285.0);
        AnchorPane.setBottomAnchor(errorText, 0.0);
        AnchorPane.setLeftAnchor(errorText, 35.0);
        messageWindowVBox.setPadding(new Insets(0, 15, 0, 0));

        AnchorPane.setRightAnchor(cancelButton, 35.0);
        AnchorPane.setBottomAnchor(cancelButton, 35.0);

        ArrayList<String> bodyTextArrayList = new ArrayList<>();
        if (counter == 1) {
            bodyTextArrayList.add("Using this tool you can easily update CNC12 for Acorn, AcornSix, and Hickory " + 
            "(with wizard) and transfer your settings to the new version. Be mindful that this tool does not set anything" + 
            " new that is added. It is your responsibility as the updater to familiarize yourself with any changes made " + 
            "between the old version and new and adjust settings accordingly.");
            bodyTextArrayList.add("");
            bodyTextArrayList.add("This tool does not take into account your customized PLC, VCP, Macros, etc.");

            Label exampleError = new Label("1. Example Error Message\n    Error messages will prevent continuation");
            exampleError.setTextFill(Color.RED);
            exampleError.setWrapText(true);
            Label exampleWarning = new Label("1. Example Warning Message\n    Warning messages can generally be safely ignored but you should be aware of them");
            exampleWarning.setTextFill(Color.ORANGE);
            exampleWarning.setWrapText(true);
            Label exampleSuccess = new Label("1. Example Success Message\n    Success messages list settings or files that have been alterred");
            exampleSuccess.setTextFill(Color.GREEN);
            exampleSuccess.setWrapText(true);
            messageWindowVBox.getChildren().addAll(exampleError, exampleWarning, exampleSuccess);
        } else if (counter == 2) {
            bodyTextArrayList.add("1. We need to rename the current cnc* directory in the C: drive based on the type of machine it is:");
            bodyTextArrayList.add("Mill = 'old cncm'");
            bodyTextArrayList.add("Lathe = 'old cnct'");
            bodyTextArrayList.add("Router = 'old cncr'");
            bodyTextArrayList.add("Plasma = 'old cncp'");
            bodyTextArrayList.add("Laser = 'old cncl'");
            bodyTextArrayList.add("Even if your directory previously was 'cncm,' it needs to be renamed to 'old cncr' if it's a router or 'old cncp' if it's plasma.");
            bodyTextArrayList.add("2. Download the latest CNC12 installer from the Centroid website and install it.");
            bodyTextArrayList.add("3. Start CNC12 and it will first update the firmware on the board.");
            bodyTextArrayList.add("4. After the firmware updates, power cycle the board and restart CNC12.");
            bodyTextArrayList.add("5. Open the wizard by going to F7 - Utility > F10 - Wizard.");
            bodyTextArrayList.add("6. Click the 'Write Settings to CNC Control Configuration' button.");
            bodyTextArrayList.add("7. Click 'Yes' to confirm you'd like to save the settings and follow the prompts.");
            bodyTextArrayList.add("8. Close CNC12 and move on to the next screen.");
        } else if (counter == 3) {
            bodyTextArrayList.add("1. Start CNC12.");
            bodyTextArrayList.add("2. Your previous License will have been transferred, but if for any reason you need to install a License do that now by going to: F7 - Utility > F8 - CNC12 License > F8 - Import License.");
            bodyTextArrayList.add("3. Open the wizard by going to F7 - Utility > F10 - Wizard.");
            bodyTextArrayList.add("4. Navigate to the 'Input Definitions' section and find and click the 'Advanced I/O Configuration' button.");
            bodyTextArrayList.add("5. Switch to the Custom tab and select 'Previous_IO.'");
            bodyTextArrayList.add("6. Click the green 'Load Preset' button near the bottom of the wizard screen.");
            bodyTextArrayList.add("7. Select 'Yes' to confirm you want to load this I/O preset.");
            bodyTextArrayList.add("");
            bodyTextArrayList.add("DO NOT close CNC12 or the wizard yet.");
            bodyTextArrayList.add("You may now move on to the next screen.");
        } else if (counter == 4) {
            bodyTextArrayList.add("1. Navigate to the 'Centroid USB-BOB' section of the wizard.");
            bodyTextArrayList.add("2. Within the wizard, drag and drop the USB-BOB inputs as you see them listed below:");
            for (Map.Entry<String, String> entry : App.usbInputsMap.entrySet()) {
                bodyTextArrayList.add(entry.getKey() + " " + entry.getValue());
            }
            bodyTextArrayList.add("Once all of the inputs are in place move on to the next screen.");
        } else if (counter == 5) {
            bodyTextArrayList.add("Now that all of your I/O is loaded, we can now save our changes.");
            bodyTextArrayList.add("1. Click the 'Write Settings to CNC Control Configuration' button found in the bottom right of the wizard screen.");
            bodyTextArrayList.add("2. Click 'Yes' to confirm you'd like to write the settings.");
            bodyTextArrayList.add("3. Click 'OK' to acknowledge the warning about PLC changes.");
            bodyTextArrayList.add("4. Power cycle the board.");
            bodyTextArrayList.add("5. Wait for CNC12 to be closed and the board to reboot, while the wizard will still be open with the confirmation message on the screen.");
            bodyTextArrayList.add("6. Before pressing 'OK' to the wizard confirmation message move on to the next screen.");
        } else if (counter == 6) {
            AnchorPane.setRightAnchor(finishButton, 125.0);
            AnchorPane.setBottomAnchor(finishButton, 35.0);
            bodyTextArrayList.add("To finish the update click 'OK' to the wizard confirmation message.");
            bodyTextArrayList.add("CNC12 will now restart and the update is compete!");
            bodyTextArrayList.add("");
            bodyTextArrayList.add("Remember that it is the responsibility of the updater to ensure everything works correctly. Take the time to test things out to be sure they're setup as they should be.");
            bodyTextArrayList.add("ATCs will need to be re-initialized and Plasma users will need to re-calibrate the torch.");
            bodyTextArrayList.add("Job files, custom macros, and VCP modifications should be copied over if you'd like to keep them.");
            bodyTextArrayList.add("Custom macros may need to be re applied to the Aux keys if they previously were. Do this in the 'VCP Aux Keys' section of the wizard.");
        }
        if (counter > 1) {
            AnchorPane.setRightAnchor(backButton, 200.0);
            AnchorPane.setBottomAnchor(backButton, 35.0);
        }
        if (counter < 6) {
            AnchorPane.setRightAnchor(nextButton, 125.0);
            AnchorPane.setBottomAnchor(nextButton, 35.0);
        }
        if (counter > 2) {
            boardLabel.setText(App.board);
            AnchorPane.setRightAnchor(boardLabel, 35.0);
            AnchorPane.setTopAnchor(boardLabel, 15.0);
            keyALabel.setText(App.newBoardKeyA);
            AnchorPane.setRightAnchor(keyALabel, 35.0);
            AnchorPane.setTopAnchor(keyALabel, 30.0);
            versionLabel.setText(App.oldversionRaw + " -> " + App.newversionRaw);
            AnchorPane.setRightAnchor(versionLabel, 35.0);
            AnchorPane.setTopAnchor(versionLabel, 45.0);
        }
        for (int i = 0; i < App.warningText.size(); i++) {
            Label tempLabel = new Label(i+1 + ". " + App.warningText.get(i));
            tempLabel.setTextFill(Color.ORANGE);
            tempLabel.setWrapText(true);
            messageWindowVBox.getChildren().add(tempLabel);
        }
        for (int i = 0; i < App.successText.size(); i++) {
            Label tempLabel = new Label(i+1 + ". " + App.successText.get(i));
            tempLabel.setTextFill(Color.GREEN);
            tempLabel.setWrapText(true);
            messageWindowVBox.getChildren().add(tempLabel);
        }
        errorText.setContent(messageWindowVBox);
        for (int i = 0; i < bodyTextArrayList.size(); i++) {
                Label tempLabel = new Label(bodyTextArrayList.get(i));
                tempLabel.setWrapText(true);
                bodyTextVBox.getChildren().add(tempLabel);
            }
        bodyText.setContent(bodyTextVBox);
        String bodyTextStyling = "-fx-font-size: ";
        int defaultFontSize = 20;

        bodyText.widthProperty().addListener(new ChangeListener<Number>() {
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                bodyText.setStyle(bodyTextStyling + (((((bodyText.getWidth()*bodyText.getHeight())/(378*730))-1)*5)+defaultFontSize) + ";");
            }
        });
        bodyText.heightProperty().addListener(new ChangeListener<Number>() {
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                bodyText.setStyle(bodyTextStyling + (((((bodyText.getWidth()*bodyText.getHeight())/(378*730))-1)*5)+defaultFontSize) + ";");

            }
        });
    }

    public void newScene(ActionEvent event, String fxmlScene) {
        try {
            root = FXMLLoader.load(getClass().getResource(fxmlScene));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            double previousWidth = stage.getWidth();
            double previousHeight = stage.getHeight();
            scene = new Scene(root);
            scene.getStylesheets().add(this.getClass().getResource("app.css").toExternalForm());
            stage.setWidth(previousWidth);
            stage.setHeight(previousHeight);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            App.exceptionText.add("Error changing scenes\n    " + e);
        }
    }
}

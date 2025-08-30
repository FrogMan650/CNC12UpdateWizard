package com.frogman650;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;


import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class App extends Application {
    public static ArrayList<Integer> oldParamsToCheck = new ArrayList<>();
    public static ArrayList<Integer> newParamsToCheck = new ArrayList<>();
    public static Map<String, String> inputsMap = new LinkedHashMap<>();
    public static Map<String, String> outputsMap = new LinkedHashMap<>();
    public static Map<String, String> usbInputsMap = new LinkedHashMap<>();
    public static String exceptionText = "";
    public static String board;
    public static String directoryName = "";
    public static String directoryFiles;
    public static String oldversionRaw;
    public static String newversionRaw;
    public static double oldversionCombined;
    public static double newversionCombined;
    public static String boardKeyA;
    public static void main(String[] args) throws Exception {
        launch(args);
        // setDirectoryName();X
        // setBoardSoftwareInfo();X
        // System.out.println("Version: " + oldversionRaw + " -> " + newversionRaw);
        // System.out.println("Board: " + board);
        // System.out.println("KeyA: " + boardKeyA);
        // copyLicense();X
        // copyOffsetLibrary();
        // transferCarouselSettings();
        // transferPlasmaConfig();
        // transferRackMount();
        // copyWCS();
        // copyStats();
        // copyToolLibrary();
        // transferOptions();
        // transferWizardSettings();
        // transferConfig();
        // defineParams();
        // transferParms();
        // copyHomeFile();
        // copyToolChangeFile();
        // getIO();X
        // createPresetIO();X
        // usbBobInputs();
        // System.out.println("*Update Complete*");
    }

    //1. rename old directory
    //2. install new version
    //3. start new version to load firmware
    //4. get directory name
    //5. get board and version 
    //6. copy license
    //7. getIO
    //8. create preset IO file
    //9. open CNC12 and wizard
    //10. apply IO preset
    //11. write settings

    public static void usbBobInputs() {
        if (usbInputsMap.size() > 0) {
            System.out.println("*USB-BOB Inputs*");
            for (Map.Entry<String, String> entry : usbInputsMap.entrySet()) {
                System.out.println(entry.getKey() + " " + entry.getValue());
            }
        }
    }

    public static void createPresetIO() {
            try {
                Files.copy(Paths.get("src/main/resources/com/frogman650/Previous_IO.xml"), Paths.get("C:/"+ directoryName +"/resources/wizard/saved/plcPresets/Previous_IO.xml"), StandardCopyOption.REPLACE_EXISTING);
                Document previousIODocument = getDocument("C:/"+ directoryName +"/resources/wizard/saved/plcPresets/Previous_IO.xml");
                NodeList functionsNodeList = getDocument("C:/"+ directoryName +"/resources/wizard/default/plc/functions.xml").getElementsByTagName("PlcFunction");
                Element previousIORootElement = getRootElement(previousIODocument);
                Element inputNode = previousIODocument.createElement("Inputs");
                Element outputNode = previousIODocument.createElement("Outputs");
                for (int i = 0; i < functionsNodeList.getLength(); i++) {
                    Element displayName = (Element) functionsNodeList.item(i);
                    NodeList nameNodeList = displayName.getElementsByTagName("DisplayName");
                    String name = nameNodeList.item(0).getTextContent();
                    Node importNode = functionsNodeList.item(i);
                    if (inputsMap.containsKey(name)) {
                        Element definitionNode = previousIODocument.createElement("Definition");
                        Element IONumberNode = previousIODocument.createElement("IONumber");
                        IONumberNode.setTextContent(inputsMap.get(name).split("P")[1]);
                        Element isSelectedNode = previousIODocument.createElement("IsSelected");
                        isSelectedNode.setTextContent("true");
                        // Element stateNode = previousIODocument.createElement("State");
                        // stateNode.setTextContent("NormallyClosed");
                        Node importedNode = previousIODocument.importNode(importNode, true);
                        definitionNode.appendChild(importedNode);
                        Element newElement = previousIODocument.createElement("Function");
                        for (int j = 0; j < definitionNode.getChildNodes().getLength(); j++) {
                            Element oldElement = (Element) definitionNode.getChildNodes().item(j);
                            NamedNodeMap attributes = oldElement.getAttributes();
                            for (int k = 0; k < attributes.getLength(); k++) {
                                Node attr = attributes.item(k);
                                newElement.setAttribute(attr.getNodeName(), attr.getNodeValue());
                            }
                            NodeList children = oldElement.getChildNodes();
                            for (int k = 0; k < children.getLength(); k++) {
                                Node child = children.item(k);
                                newElement.appendChild(previousIODocument.importNode(child, true));
                            }
                                oldElement.getParentNode().replaceChild(newElement, oldElement);
                                // definitionNode.appendChild(newElement);
                        }
                        definitionNode.appendChild(isSelectedNode);
                        definitionNode.appendChild(IONumberNode);
                        // definitionNode.appendChild(stateNode);
                        inputNode.appendChild(definitionNode);
                    }
                    if (outputsMap.containsKey(name)) {
                        Element definitionNode = previousIODocument.createElement("Definition");
                        Element IONumberNode = previousIODocument.createElement("IONumber");
                        IONumberNode.setTextContent(outputsMap.get(name).split("T")[1]);
                        Element isSelectedNode = previousIODocument.createElement("IsSelected");
                        isSelectedNode.setTextContent("true");
                        // Element stateNode = previousIODocument.createElement("State");
                        // stateNode.setTextContent("NormallyClosed");
                        Node importedNode = previousIODocument.importNode(importNode, true);
                        definitionNode.appendChild(importedNode);
                        Element newElement = previousIODocument.createElement("Function");
                        for (int j = 0; j < definitionNode.getChildNodes().getLength(); j++) {
                            Element oldElement = (Element) definitionNode.getChildNodes().item(j);
                            NamedNodeMap attributes = oldElement.getAttributes();
                            for (int k = 0; k < attributes.getLength(); k++) {
                                Node attr = attributes.item(k);
                                newElement.setAttribute(attr.getNodeName(), attr.getNodeValue());
                            }
                            NodeList children = oldElement.getChildNodes();
                            for (int k = 0; k < children.getLength(); k++) {
                                Node child = children.item(k);
                                newElement.appendChild(previousIODocument.importNode(child, true));
                            }
                                oldElement.getParentNode().replaceChild(newElement, oldElement);
                                // definitionNode.appendChild(newElement);
                        }
                        definitionNode.appendChild(isSelectedNode);
                        definitionNode.appendChild(IONumberNode);
                        // definitionNode.appendChild(stateNode);
                        outputNode.appendChild(definitionNode);
                    }
                }
                previousIORootElement.appendChild(inputNode);
                previousIORootElement.appendChild(outputNode);
                writeToXml("C:/"+ directoryName +"/resources/wizard/saved/plcPresets/Previous_IO.xml", previousIODocument);
            } catch (Exception e) {
                exceptionText = "Exception thrown while creating IO preset";
                System.out.println("Exception thrown while creating IO preset\n" + e);
            }
            System.out.println("IO preset *DONE*");
        }

    public static void getIO() {
        try {
            File file = new File("C:/old " + directoryName + "/mpu.plc");
            Scanner scanner = new Scanner(file);
            String region = "";
            Boolean record = false;
            int counter = 0;
            while (counter < 3 && scanner.hasNext()) {
                String line = scanner.nextLine();
                if (line.contains("#endregion") && record) {
                    counter ++;
                    record = false;
                }else if (line.contains("#wizardregion Inputs")) {
                    record = true;
                    region = "inputs";
                } else if (line.contains("#wizardregion Outputs")) {
                    record = true;
                    region = "outputs";
                } else if (line.contains("#wizardregion UsbInput")) {
                    record = true;
                    region = "usbinputs";
                } else if (record && region.equals("inputs")) {
                    inputsMap.put(trimReplaceSplit(line)[1], trimReplaceSplit(line)[3]);
                } else if (record && region.equals("outputs")) {
                    outputsMap.put(trimReplaceSplit(line)[1], trimReplaceSplit(line)[3]);
                } else if (record && region.equals("usbinputs")) {
                    String lineSplitSV = trimReplaceSplit(line)[1].split("_")[1];
                    String lineSPlitINP = trimReplaceSplit(line)[3].split("_")[trimReplaceSplit(line)[3].split("_").length-2] + 
                    trimReplaceSplit(line)[3].split("_")[trimReplaceSplit(line)[3].split("_").length-1];
                    usbInputsMap.put(lineSPlitINP, lineSplitSV);
                }
            }
            scanner.close();
        } catch (Exception e) {
            exceptionText = "Exception thrown while getting IO";
            System.out.println("Exception thrown while getting IO\n" + e);
            }
            System.out.println("Getting IO *DONE*");
        }

    public static void copyToolChangeFile() {
        try {
            Document newWizardSettingsDocument = getDocument("C:/" + directoryName + "/wizardsettings.xml");
            Node toolChangeFileNode = getRootElement(newWizardSettingsDocument).getElementsByTagName("CustomToolChangeMacro").item(0);
            Element toolChangeElement = (Element) toolChangeFileNode;
            if (toolChangeElement.getAttribute("value").equals("True")) {
                Files.copy(Paths.get(directoryName.equals("cnct") ? "C:/old " + directoryFiles + "/cnctch.mac" : "C:/old " + directoryFiles + "/mfunc6.mac"), 
                Paths.get(directoryName.equals("cnct") ? "C:/" + directoryFiles + "/cnctch.mac" : "C:/" + directoryFiles + "/mfunc6.mac"), StandardCopyOption.REPLACE_EXISTING);
            }
        } catch (Exception e) {
            exceptionText = "Exception thrown while copying tool change macro";
            System.out.println("Exception thrown while copying tool change macro\n" + e);
        }
        System.out.println("Tool change macro *DONE*");
    }

    public static void copyHomeFile() {
        try {
            Document newWizardSettingsDocument = getDocument("C:/" + directoryName + "/wizardsettings.xml");
            Node homingFileNode = getRootElement(newWizardSettingsDocument).getElementsByTagName("HomingFileType").item(0);
            Element homingElement = (Element) homingFileNode;
            if (homingElement.getAttribute("value").equals("Custom")) {
                Files.copy(Paths.get("C:/old " + directoryName + "/" + directoryFiles + ".hom"), 
                Paths.get("C:/" + directoryName + "/" + directoryFiles + ".hom"), StandardCopyOption.REPLACE_EXISTING);
            }
        } catch (Exception e) {
            exceptionText = "Exception thrown while copying home file";
            System.out.println("Exception thrown while copying home file\n" + e);
        }
        System.out.println("Home file *DONE*");
    }

    public static void transferParms() {
        try {
            Document newParmDocument = getDocument("C:/" + directoryName + "/" + directoryFiles + ".prm.xml");
            NodeList oldParmNodeList = getRootElement(getDocument("C:/old " + directoryName + "/" + directoryFiles + ".prm.xml")).getElementsByTagName("value");
            NodeList newParmNodeList = getRootElement(newParmDocument).getElementsByTagName("value");
            for(int i = 0; i < oldParmNodeList.getLength(); i ++) {
                Node oldParmNode = oldParmNodeList.item(i);
                Node newParmNode = newParmNodeList.item(i);
                Element element = (Element) oldParmNode;
                String text = element.getTextContent();
                if (oldParamsToCheck.contains(i) && newParamsToCheck.contains(i)) {
                    newParmNode.setTextContent(text);
                    //newParmNode.setTextContent("69");//for testing
                }
            }
            writeToXml("C:/" + directoryName + "/" + directoryFiles + ".prm.xml", newParmDocument);
        } catch (Exception e) {
            exceptionText = "Exception thrown while transfering parameters";
            System.out.println("Exception thrown while transfering parameters");
        }
        System.out.println("Parameters *DONE*");
    }

    public static void defineParams() {
        try {
            NodeList oldVersionNodeList = getRootElement(getDocument("src/main/resources/com/frogman650/" + board + "/" + directoryName + "/" + roundVersion(oldversionCombined) +".xml")).getElementsByTagName("Parameter");
            NodeList newVersionNodeList = getRootElement(getDocument("src/main/resources/com/frogman650/" + board + "/" + directoryName + "/" + roundVersion(newversionCombined) +".xml")).getElementsByTagName("Parameter");
            for (int i = 0; i < oldVersionNodeList.getLength(); i++) {
                oldParamsToCheck.add(Integer.parseInt(oldVersionNodeList.item(i).getTextContent()));
            }
            for (int i = 0; i < newVersionNodeList.getLength(); i++) {
                newParamsToCheck.add(Integer.parseInt(newVersionNodeList.item(i).getTextContent()));
            }
        } catch (Exception e) {
            exceptionText = "Exception thrown while defining parameters";
            System.out.println("Exception thrown while defining parameters");
        }
        System.out.println("Defining params *DONE*");
    }

    public static void transferConfig() {
        try {
            Document newCfgDocument = getDocument("C:/" + directoryName + "/" + directoryFiles + "cfg.xml");
            NodeList oldCfgNodeList = getRootElement(getDocument("C:/old " + directoryName + "/" + directoryFiles + "cfg.xml")).getChildNodes();
            NodeList newCfgNodeList = getRootElement(newCfgDocument).getChildNodes();
            for (int i = 0; i < oldCfgNodeList.getLength(); i++) {
            }
            for (int i = 0; i < oldCfgNodeList.getLength(); i++) {
                Element element = (Element) oldCfgNodeList.item(i);
                Element element2 = (Element) newCfgNodeList.item(i);
                NamedNodeMap attributes = element.getAttributes();
                NamedNodeMap attributes2 = element2.getAttributes();
                for (int j = 0; j < attributes.getLength(); j++) {
                    for (int k = 0; k < attributes2.getLength(); k++) {
                        if (attributes.item(j).getNodeName().equals(attributes2.item(k).getNodeName())) {
                        element2.setAttribute(attributes2.item(k).getNodeName(), attributes.item(j).getTextContent());
                        break;
                        }
                    }
                }
            }
            writeToXml("C:/" + directoryName + "/" + directoryFiles + "cfg.xml", newCfgDocument);
        } catch (Exception e) {
            exceptionText = "Exception thrown while transfering config file";
            System.out.println("Exception thrown while transfering config file\n" + e);
        }
        System.out.println("Config *DONE*");
    }

    public static void transferWizardSettings() {
        try {
            Document newWizardSettingsDocument = getDocument("C:/" + directoryName + "/wizardsettings.xml");
            NodeList oldWizardSettingsNodeList = getRootElement(getDocument("C:/old " + directoryName + "/wizardsettings.xml")).getChildNodes();
            NodeList newWizardSettingsNodeList = getRootElement(newWizardSettingsDocument).getChildNodes();
            for (int i = oldWizardSettingsNodeList.getLength()-1; i >= 0; i --) {
                for (int j = 0; j < newWizardSettingsNodeList.getLength(); j ++) {
                    if (oldWizardSettingsNodeList.item(i).toString().equals(newWizardSettingsNodeList.item(j).toString())) {
                        Element element = (Element) oldWizardSettingsNodeList.item(i);
                        Element element2 = (Element) newWizardSettingsNodeList.item(j);
                        element2.setAttribute("value", element.getAttribute("value"));
                    }
                }
            }
            writeToXml("C:/" + directoryName + "/wizardsettings.xml", newWizardSettingsDocument);
        } catch (Exception e) {
            exceptionText = "Exception thrown while transfering wizard settings";
            System.out.println("Exception thrown while transfering wizard settings\n" + e);
        }
        System.out.println("Wizard settings *DONE*");
    }

    public static void transferOptions() {
        try {
            Document newOptionsDocument = getDocument("C:/" + directoryName + "/resources/vcp/options.xml");
            NodeList oldOptionsNodeList = getRootElement(getDocument("C:/old " + directoryName + "/resources/vcp/options.xml")).getElementsByTagName("VcpOption");
            NodeList newOptionsNodeList = getRootElement(newOptionsDocument).getElementsByTagName("VcpOption");
            for(int i = 0; i < oldOptionsNodeList.getLength(); i ++) {
                for(int j = 0; j < newOptionsNodeList.getLength(); j ++) {
                    String oldOptionNodeText = oldOptionsNodeList.item(i).getChildNodes().item(0).getTextContent();
                    String newOptionNodeText = newOptionsNodeList.item(j).getChildNodes().item(0).getTextContent();
                    if (oldOptionNodeText.equals(newOptionNodeText)) {
                        newOptionsNodeList.item(j).getChildNodes().item(1).setTextContent(oldOptionsNodeList.item(i).getChildNodes().item(1).getTextContent());
                        break;
                    }
                }
            }
            writeToXml("C:/" + directoryName + "/resources/vcp/options.xml", newOptionsDocument);
        } catch (Exception e) {
            exceptionText = "Exception thrown while transfering VCP options";
            System.out.println("Exception thrown while transfering VCP options\n" + e);
        }
        System.out.println("VCP options *DONE*");
    }

    public static void copyToolLibrary() {
        try {
            if (directoryName.equals("cnct")) {
                Files.copy(Paths.get("C:/old "+ directoryName +"/"+ directoryFiles +".ttl"), Paths.get("C:/"+ directoryName +"/"+ directoryFiles +".ttl"), StandardCopyOption.REPLACE_EXISTING);
            } else {
                Files.copy(Paths.get("C:/old "+ directoryName +"/"+ directoryFiles +".tl"), Paths.get("C:/"+ directoryName +"/"+ directoryFiles +".tl"), StandardCopyOption.REPLACE_EXISTING);
            }
        } catch (Exception e) {
            exceptionText = "Exception thrown while copying tool library";
            System.out.println("Exception thrown while copying tool library\n" + e);
        }
        System.out.println("Tool library *DONE*");
    }

    public static void copyStats() {
        try {
            Files.copy(Paths.get("C:/old "+ directoryName +"/mt.stats"), Paths.get("C:/"+ directoryName +"/mt.stats"), StandardCopyOption.REPLACE_EXISTING);
        } catch (Exception e) {
            exceptionText = "Exception thrown while copying stats file";
            System.out.println("Exception thrown while copying stats file\n" + e);
        }
        System.out.println("Stats *DONE*");
    }

    public static void copyWCS() {
        try {
            Files.copy(Paths.get("C:/old "+ directoryName +"/"+ directoryFiles +".wcs"), Paths.get("C:/"+ directoryName +"/"+ directoryFiles +".wcs"), StandardCopyOption.REPLACE_EXISTING);
        } catch (Exception e) {
            exceptionText = "Exception thrown while copying WCS file";
            System.out.println("Exception thrown while copying WCS file\n" + e);
        }
        System.out.println("WCS *DONE*");
    }

    public static void transferRackMount() {
        if (directoryName.equals("cncm") || directoryName.equals("cncr")) {
            try {
                Document newRackMountDocument = getDocument("C:/" + directoryName + "/RackMountBin.xml");
                NodeList oldRackMountNodeList = getRootElement(getDocument("C:/old " + directoryName + "/RackMountBin.xml")).getChildNodes();
                NodeList newRackMountNodeList = getRootElement(newRackMountDocument).getChildNodes();
                for (int i = 0; i < oldRackMountNodeList.getLength(); i++) {
                    for (int j = 0; j < newRackMountNodeList.getLength(); j++) {
                        if (oldRackMountNodeList.item(i).getChildNodes().getLength() == 1 && newRackMountNodeList.item(j).getChildNodes().getLength() == 1) {
                            if (oldRackMountNodeList.item(i).getNodeName().equals(newRackMountNodeList.item(j).getNodeName())) {
                                newRackMountNodeList.item(j).setTextContent(oldRackMountNodeList.item(i).getTextContent());
                            }
                        }
                        if (oldRackMountNodeList.item(i).getChildNodes().getLength() > 1 && newRackMountNodeList.item(j).getChildNodes().getLength() > 1 && 
                        oldRackMountNodeList.item(i).getFirstChild().getTextContent().equals(newRackMountNodeList.item(j).getFirstChild().getTextContent())) {
                            for (int k = 0; k < oldRackMountNodeList.item(i).getChildNodes().getLength(); k++) {
                                for (int l = 0; l < newRackMountNodeList.item(j).getChildNodes().getLength(); l++) {
                                    if (oldRackMountNodeList.item(i).getChildNodes().item(k).getNodeName().equals(newRackMountNodeList.item(j).getChildNodes().item(l).getNodeName())) {
                                        newRackMountNodeList.item(j).getChildNodes().item(l).setTextContent(oldRackMountNodeList.item(i).getChildNodes().item(k).getTextContent());
                                    }
                                }
                            }
                        }
                    }
                }
                writeToXml("C:/" + directoryName + "/RackMountBin.xml", newRackMountDocument);
            } catch (Exception e) {
                exceptionText = "Exception thrown while transfering rack mount settings";
                System.out.println("Exception thrown while transfering rack mount settings\n" + e);
            }
        }
        System.out.println("Rack mount settings *DONE*");
    }

    public static void transferPlasmaConfig() {
        if (directoryName.equals("cncp")) {
            try {
                Document newPlasmaConfigDocument = getDocument("C:/" + directoryName + "/PlasmaConfigurations.xml");
                File file = new File("C:/old " + directoryName + "/PlasmaConfigurations.txt");
                NodeList newPlasmaConfigNodeList = getRootElement(newPlasmaConfigDocument).getChildNodes();
                if (file.exists()) {
                    Scanner scanner = new Scanner(file);
                    int counter = 0;
                    while (scanner.hasNextLine()) {
                        newPlasmaConfigNodeList.item(counter).setTextContent(scanner.nextLine());
                        counter ++;
                    }
                    scanner.close();
                } else {
                    NodeList oldPlasmaConfigNodeList = getRootElement(getDocument("C:/old " + directoryName + "/PlasmaConfigurations.xml")).getChildNodes();
                    for (int i = 0; i < newPlasmaConfigNodeList.getLength(); i ++) {
                        for (int j = 0; j < oldPlasmaConfigNodeList.getLength(); j ++) {
                            if (newPlasmaConfigNodeList.item(i).getNodeName().equals(oldPlasmaConfigNodeList.item(j).getNodeName())) {
                                newPlasmaConfigNodeList.item(i).setTextContent(oldPlasmaConfigNodeList.item(j).getTextContent());
                            }
                        }
                    }
                }
                writeToXml("C:/" + directoryName + "/PlasmaConfigurations.xml", newPlasmaConfigDocument);
            } catch (Exception e) {
                exceptionText = "Exception thrown while transfering plasma config";
                System.out.println("Exception thrown while transfering plasma config\n" + e);
            }
            System.out.println("Plasma config *DONE*");
        }
    }

    public static void transferCarouselSettings() {
        if (directoryName.equals("cncm") || directoryName.equals("cncr")) {
            try {
                Document newCarouselSettingsDocument = getDocument("C:/" + directoryName + "/FixedCarouselSettings.xml");
                NodeList oldCarouselNodeList = getRootElement(getDocument("C:/old " + directoryName + "/FixedCarouselSettings.xml")).getChildNodes();
                NodeList newCarouselNodeList = getRootElement(newCarouselSettingsDocument).getChildNodes();
                for (int i = 0; i < newCarouselNodeList.getLength(); i ++) {
                    for (int j = 0; j < oldCarouselNodeList.getLength(); j ++) {
                        if (newCarouselNodeList.item(i).getNodeName().equals(oldCarouselNodeList.item(j).getNodeName())) {
                            newCarouselNodeList.item(i).setTextContent(oldCarouselNodeList.item(j).getTextContent());
                        }
                    }
                }
                writeToXml("C:/" + directoryName + "/FixedCarouselSettings.xml", newCarouselSettingsDocument);
            } catch (Exception e) {
                exceptionText = "Exception thrown while transfering carousel settings";
                System.out.println("Exception thrown while transfering carousel settings\n" + e);
            }
        }
        System.out.println("Carousel settings *DONE*");
    }

    public static void copyOffsetLibrary() {
        if (!directoryName.equals("cnct")) {
            try {
                Files.copy(Paths.get("C:/old "+ directoryName +"/"+ directoryFiles +".ol"), Paths.get("C:/"+ directoryName +"/"+ directoryFiles +".ol"), StandardCopyOption.REPLACE_EXISTING);
            } catch (Exception e) {
                exceptionText = "Exception thrown while copying offset library";
                System.out.println("Exception thrown while copying offset library\n" + e);
            }
        }
        System.out.println("Offset library *DONE*");
    }

    public static void copyLicense() {
        try {
            File file = new File("C:/old "+ directoryName +"/license.dat");
            if (file.exists()) {
            Files.copy(Paths.get("C:/old "+ directoryName +"/license.dat"), Paths.get("C:/"+ directoryName +"/license.dat"), StandardCopyOption.REPLACE_EXISTING);
            }
        } catch (Exception e) {
            exceptionText = "Exception thrown while copying license";
            System.out.println("Exception thrown while copying license\n" + e);
        }
        System.out.println("License *DONE*");
    }

    public static void setBoardSoftwareInfo() {
        try {
            oldversionRaw = setRawVersion("C:/old " + directoryName + "/" + directoryFiles + ".prm.xml");
            newversionRaw = setRawVersion("C:/" + directoryName + "/" + directoryFiles + ".prm.xml");
            oldversionCombined = getVersionCombined(oldversionRaw);
            newversionCombined = getVersionCombined(newversionRaw);
            if (newversionCombined > 538 && newversionCombined < 540) {//for testing only; rounds up v5.39 to 5.40
                newversionCombined = 540;
            }
            boardKeyA = getKeyA("C:/" + directoryName + "/" + directoryFiles + "cfg.xml");
            board = getBoardType();
        } catch (Exception e) {
            exceptionText = "Exception thrown while setting board and software version";
            System.out.println("Exception thrown while setting board and software version\n" + e);
        }
    }

    public static void setDirectoryName() {
        if (checkDirectory("cncm")) {
            directoryName = "cncm"; 
        }
        if (checkDirectory("cnct")) {
            if (directoryName != "") {
                throw new IllegalArgumentException("More than 1 old and new directory combination found");
            }
            directoryName = "cnct"; 
        }
        if (checkDirectory("cncr")) {
            if (directoryName != "") {
                throw new IllegalArgumentException("More than 1 old and new directory combination found"); 
            }
            directoryName = "cncr"; 
        }
        if (checkDirectory("cncp")) {
            if (directoryName != "") {
                throw new IllegalArgumentException("More than 1 old and new directory combination found"); 
            }
            directoryName = "cncp"; 
        }
        if (checkDirectory("cncl")) {
            if (directoryName != "") {
                throw new IllegalArgumentException("More than 1 old and new directory combination found"); 
            }
            directoryName = "cncl"; 
        }
        if (directoryName.equals("")) {
            throw new IllegalArgumentException("No directory combination found");
        }
        directoryFiles = directoryName.equals("cnct") ? "cnct" : "cncm";
    }

    public static String getKeyA(String filePath) {
        String keyA;
        String[] keyASplit = null;
        try {
            keyA = getRootElement(getDocument(filePath)).getAttribute("v300_Header").trim();
            keyASplit = keyA.split(" ");
        } catch (Exception e) {
            exceptionText = "Exception thrown while getting KeyA";
            System.out.println("Exception thrown while getting KeyA\n" + e);
        }
        return keyASplit[keyASplit.length-1];
    }

    public static Element trimEmptyElements(Element node) {
        for (int i = node.getChildNodes().getLength()-1; i >= 0; i--) {
            if (node.getChildNodes().item(i).getTextContent().trim().isEmpty() && !node.getChildNodes().item(i).hasAttributes()) {
                node.removeChild(node.getChildNodes().item(i));
                continue;
            }
            if (node.getChildNodes().item(i).hasChildNodes()) {
                for (int j = node.getChildNodes().item(i).getChildNodes().getLength()-1; j >= 0; j--) {
                    if (node.getChildNodes().item(i).getChildNodes().item(j).getTextContent().trim().isEmpty() && !node.getChildNodes().item(i).getChildNodes().item(j).hasAttributes()) {
                        node.getChildNodes().item(i).removeChild(node.getChildNodes().item(i).getChildNodes().item(j));
                    }
                }
            }
        }
        return node;
    }

    public static String[] trimReplaceSplit(String line) {
        String[] lineSplit = line.trim().replaceAll("\\s+", " ").split(" ");
        return lineSplit;
    }

    public static int roundVersion(double version) {
        double scaledVersion = version / 10;
        double roundScaledVersion = Math.floor(scaledVersion)*10;
        int intRoundedVersion = (int) roundScaledVersion;
        return intRoundedVersion;
    }

    public static Document getDocument(String filePath) {
        DocumentBuilderFactory factory;
        DocumentBuilder builder;
        Document document = null;
        try {
            factory = DocumentBuilderFactory.newInstance();
            builder = factory.newDocumentBuilder();
            document = builder.parse(new File(filePath));
        } catch (Exception e) {
            exceptionText = "Exception thrown while getting document from: " + filePath;
            System.out.println("Exception thrown while getting document from: " + filePath + "\n" + e);
        }
        return document;
    }

    public static Element getRootElement(Document document) {
        Element rootElement = null;
        try {
            rootElement = document.getDocumentElement();
        } catch (Exception e) {
            exceptionText = "Exception thrown while getting root1 element from document";
            System.out.println("Exception thrown while getting root1 element from document\n" + e);
        }
            return trimEmptyElements(rootElement);
    }

    public static void writeToXml(String filePath, Document document) {
        try {
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource docSource = new DOMSource(document);
            StreamResult docResult = new StreamResult(new File(filePath));
            transformer.transform(docSource, docResult);
        } catch (Exception e) {
            exceptionText = "Exception thrown while writing to file: " + filePath;
            System.out.println("Exception thrown while writing to file: " + filePath + "\n" + e);
        }
    }

    public static String setRawVersion(String filePath) {
        NodeList softwareVersionNodeList;
        String softwareVersion;
        String[] softwareVersionSplit = null;
        try {
            softwareVersionNodeList = getRootElement(getDocument(filePath)).getElementsByTagName("SoftwareVersion");
            softwareVersion = softwareVersionNodeList.item(0).getTextContent();
            softwareVersionSplit = softwareVersion.split(" ");
        } catch (Exception e) {
            exceptionText = "Exception thrown while setting raw version";
            System.out.println("Exception thrown while setting raw version\n" + e);
        }
        if (softwareVersionSplit[0].equals("ACORN")) {
            return softwareVersionSplit[3];
        } else {
            return softwareVersionSplit[2];
        }
    }

    public static double getVersionCombined(String rawVersion) {
        String[] versionSplitSplit = null;
        try {
            versionSplitSplit = rawVersion.split("\\.");
        } catch (Exception e) {
            exceptionText = "Exception thrown while getting combined version";
            System.out.println("Exception thrown while getting combined version\n" + e);
        }
        if (versionSplitSplit.length == 2) {
            return Double.parseDouble(versionSplitSplit[0] + versionSplitSplit[1]);
        } else {
            return Double.parseDouble(versionSplitSplit[0] + versionSplitSplit[1] + "." + versionSplitSplit[2]);
        }
    }

    public static String getBoardType() {
        NodeList boardVersionNodeList;
        String boardVersion;
        String oldBoard = null;
        String newBoard = null;
        String oldFilePath = "C:/old " + directoryName + "/mpu_info.xml";
        String newFilePath ="C:/" + directoryName + "/mpu_info.xml";
        try {
            boardVersionNodeList = getRootElement(getDocument(oldFilePath)).getElementsByTagName("PLCDeviceID");
            boardVersion = boardVersionNodeList.item(0).getTextContent();
            oldBoard = boardVersion.split("_")[2];
            boardVersionNodeList = getRootElement(getDocument(newFilePath)).getElementsByTagName("PLCDeviceID");
            boardVersion = boardVersionNodeList.item(0).getTextContent();
            newBoard = boardVersion.split("_")[2];
        } catch (Exception e) {
            exceptionText = "Exception thrown while setting board type";
            System.out.println("Exception thrown while setting board type\n" + e);
        }
        if (oldBoard.equals(newBoard)) {
            return newBoard;
        } else {
            throw new IllegalArgumentException("Board mismatch: " + oldBoard + " and " + newBoard);
        }
    }

    public static Boolean checkDirectory(String directory) {
        File firstDirectory = new File("C:/" + directory);
        File secondDirectory = new File("C:/old " + directory);
        return firstDirectory.exists() && secondDirectory.exists();
    }

    @Override
    public void start(Stage stage) throws Exception {
        Image icon = new Image(App.class.getResourceAsStream("LK_logo_square.png"));
        Parent root1 = FXMLLoader.load(getClass().getResource("scene1.fxml"));
        Scene scene1 = new Scene(root1);
        scene1.getStylesheets().add(this.getClass().getResource("app.css").toExternalForm());
        
        stage.setTitle("CNC12 Update Wizard");
        stage.getIcons().add(icon);
        stage.setResizable(false);
        stage.setX(50);
        stage.setY(50);
        stage.setFullScreen(false);

        stage.setScene(scene1);
        stage.show();
    }
}

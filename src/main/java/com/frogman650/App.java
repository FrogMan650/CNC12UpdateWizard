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
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
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
    public static Boolean usbBobInstalled = false;
    public static void main(String[] args) throws Exception {
        launch(args);
    }

    public static void createPresetIO() {
        getIO();
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
            System.out.println("IO preset *DONE*");
        } catch (Exception e) {
            exceptionText = exceptionText.equals("") ? "Error creating IO preset" : exceptionText;
            System.out.println("Exception thrown while creating IO preset\n" + e);
        }
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
                    usbBobInstalled = true;
                    String lineSplitSV = trimReplaceSplit(line)[1].split("_")[1];
                    String lineSPlitINP = trimReplaceSplit(line)[3].split("_")[trimReplaceSplit(line)[3].split("_").length-2] + 
                    trimReplaceSplit(line)[3].split("_")[trimReplaceSplit(line)[3].split("_").length-1];
                    usbInputsMap.put(lineSPlitINP, lineSplitSV);
                }
            }
            scanner.close();
            System.out.println("Getting IO *DONE*");
        } catch (Exception e) {
            exceptionText = exceptionText.equals("") ? "Error getting IO" : exceptionText;
            System.out.println("Exception thrown while getting IO\n" + e);
            }
        }

    public static void copyToolChangeFile() {
        try {
            Document newWizardSettingsDocument = getDocument("C:/" + directoryName + "/wizardsettings.xml");
            Node toolChangeFileNode = getRootElement(newWizardSettingsDocument).getElementsByTagName("CustomToolChangeMacro").item(0);
            Element toolChangeElement = (Element) toolChangeFileNode;
            if (toolChangeElement.getAttribute("value").equals("True")) {
                Files.copy(Paths.get(directoryName.equals("cnct") ? "C:/old " + directoryFiles + "/cnctch.mac" : "C:/old " + directoryFiles + "/mfunc6.mac"), 
                Paths.get(directoryName.equals("cnct") ? "C:/" + directoryFiles + "/cnctch.mac" : "C:/" + directoryFiles + "/mfunc6.mac"), StandardCopyOption.REPLACE_EXISTING);
                System.out.println("Tool change macro *DONE*");
            }
        } catch (Exception e) {
            exceptionText = exceptionText.equals("") ? "Error copying tool change macro" : exceptionText;
            System.out.println("Exception thrown while copying tool change macro\n" + e);
        }
    }

    public static void copyHomeFile() {
        try {
            Document newWizardSettingsDocument = getDocument("C:/" + directoryName + "/wizardsettings.xml");
            Node homingFileNode = getRootElement(newWizardSettingsDocument).getElementsByTagName("HomingFileType").item(0);
            Element homingElement = (Element) homingFileNode;
            if (homingElement.getAttribute("value").equals("Custom")) {
                Files.copy(Paths.get("C:/old " + directoryName + "/" + directoryFiles + ".hom"), 
                Paths.get("C:/" + directoryName + "/" + directoryFiles + ".hom"), StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Home file *DONE*");
            }
        } catch (Exception e) {
            exceptionText = exceptionText.equals("") ? "Error while copying home file" : exceptionText;
            System.out.println("Exception thrown while copying home file\n" + e);
        }
    }

    public static void transferParms() {
        defineParams();
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
            System.out.println("Parameters *DONE*");
        } catch (Exception e) {
            exceptionText = exceptionText.equals("") ? "Error transfering parameters" : exceptionText;
            System.out.println("Exception thrown while transfering parameters " + e);
        }
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
            System.out.println("Defining params *DONE*");
        } catch (Exception e) {
            exceptionText = exceptionText.equals("") ? "Error defining parameters" : exceptionText;
            System.out.println("Exception thrown while defining parameters");
        }
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
            System.out.println("Config *DONE*");
        } catch (Exception e) {
            exceptionText = exceptionText.equals("") ? "Error transfering config" : exceptionText;
            exceptionText = "Error transfering config file";
            System.out.println("Exception thrown while transfering config file\n" + e);
        }
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
            System.out.println("Wizard settings *DONE*");
        } catch (Exception e) {
            exceptionText = exceptionText.equals("") ? "Error transfering wizard settings" : exceptionText;
            System.out.println("Exception thrown while transfering wizard settings\n" + e);
        }
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
            System.out.println("VCP options *DONE*");
        } catch (Exception e) {
            exceptionText = exceptionText.equals("") ? "Error transfering VCP options" : exceptionText;
            System.out.println("Exception thrown while transfering VCP options\n" + e);
        }
    }

    public static void copyToolLibrary() {
        try {
            if (directoryName.equals("cnct")) {
                Files.copy(Paths.get("C:/old "+ directoryName +"/"+ directoryFiles +".ttl"), Paths.get("C:/"+ directoryName +"/"+ directoryFiles +".ttl"), StandardCopyOption.REPLACE_EXISTING);
            } else {
                Files.copy(Paths.get("C:/old "+ directoryName +"/"+ directoryFiles +".tl"), Paths.get("C:/"+ directoryName +"/"+ directoryFiles +".tl"), StandardCopyOption.REPLACE_EXISTING);
            }
            System.out.println("Tool library *DONE*");
        } catch (Exception e) {
            exceptionText = exceptionText.equals("") ? "Error copying tool library" : exceptionText;
            System.out.println("Exception thrown while copying tool library\n" + e);
        }
    }

    public static void copyStats() {
        try {
            Files.copy(Paths.get("C:/old "+ directoryName +"/mt.stats"), Paths.get("C:/"+ directoryName +"/mt.stats"), StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Stats *DONE*");
        } catch (Exception e) {
            exceptionText = exceptionText.equals("") ? "Error copying stats file" : exceptionText;
            System.out.println("Exception thrown while copying stats file\n" + e);
        }
    }

    public static void copyWCS() {
        try {
            Files.copy(Paths.get("C:/old "+ directoryName +"/"+ directoryFiles +".wcs"), Paths.get("C:/"+ directoryName +"/"+ directoryFiles +".wcs"), StandardCopyOption.REPLACE_EXISTING);
            System.out.println("WCS *DONE*");
        } catch (Exception e) {
            exceptionText = exceptionText.equals("") ? "Error copying WCS file" : exceptionText;
            System.out.println("Exception thrown while copying WCS file\n" + e);
        }
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
                System.out.println("Rack mount settings *DONE*");
            } catch (Exception e) {
                exceptionText = exceptionText.equals("") ? "Error transfering rack mount settings" : exceptionText;
                System.out.println("Exception thrown while transfering rack mount settings\n" + e);
            }
        }
    }

    public static void transferPlasmaConfig() {
        if (directoryName.equals("cncp") || directoryName.equals("cncl")) {
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
                System.out.println("Plasma config *DONE*");
            } catch (Exception e) {
                exceptionText = exceptionText.equals("") ? "Error transfering plasma config" : exceptionText;
                System.out.println("Exception thrown while transfering plasma config\n" + e);
            }
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
                System.out.println("Carousel settings *DONE*");
            } catch (Exception e) {
                exceptionText = exceptionText.equals("") ? "Error transfering carousel settings" : exceptionText;
                System.out.println("Exception thrown while transfering carousel settings\n" + e);
            }
        }
    }

    public static void copyOffsetLibrary() {
        if (!directoryName.equals("cnct")) {
            try {
                Files.copy(Paths.get("C:/old "+ directoryName +"/"+ directoryFiles +".ol"), Paths.get("C:/"+ directoryName +"/"+ directoryFiles +".ol"), StandardCopyOption.REPLACE_EXISTING);
                System.out.println("Offset library *DONE*");
            } catch (Exception e) {
                exceptionText = exceptionText.equals("") ? "Error copying offset library" : exceptionText;
                System.out.println("Exception thrown while copying offset library\n" + e);
            }
        }
    }

    public static void copyLicense() {
        try {
            File file = new File("C:/old "+ directoryName +"/license.dat");
            if (file.exists()) {
            Files.copy(Paths.get("C:/old "+ directoryName +"/license.dat"), Paths.get("C:/"+ directoryName +"/license.dat"), StandardCopyOption.REPLACE_EXISTING);
            }
            System.out.println("License *DONE*");
        } catch (Exception e) {
            exceptionText = exceptionText.equals("") ? "Error copying license" : exceptionText;
            System.out.println("Exception thrown while copying license\n" + e);
        }
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
            System.out.println("Software info *DONE*");
        } catch (Exception e) {
            exceptionText = exceptionText.equals("") ? "Error setting software versions" : exceptionText;
            System.out.println("Exception thrown while setting board and software version\n" + e);
        }
    }

    public static void setDirectoryName() {
        if (checkDirectory("cncm")) {
            directoryName = "cncm"; 
        }
        if (checkDirectory("cnct")) {
            if (directoryName != "") {
                exceptionText = exceptionText.equals("") ? "More than 1 old and new directory combination found" : exceptionText;
            }
            directoryName = "cnct"; 
        }
        if (checkDirectory("cncr")) {
            if (directoryName != "") {
                exceptionText = exceptionText.equals("") ? "More than 1 old and new directory combination found" : exceptionText;
            }
            directoryName = "cncr"; 
        }
        if (checkDirectory("cncp")) {
            if (directoryName != "") {
                exceptionText = exceptionText.equals("") ? "More than 1 old and new directory combination found" : exceptionText;
            }
            directoryName = "cncp"; 
        }
        if (checkDirectory("cncl")) {
            if (directoryName != "") {
                exceptionText = exceptionText.equals("") ? "More than 1 old and new directory combination found" : exceptionText;
            }
            directoryName = "cncl"; 
        }
        if (directoryName.equals("")) {
            exceptionText = exceptionText.equals("") ? "No directory combination found" : exceptionText;
        }
        directoryFiles = directoryName.equals("cnct") ? "cnct" : "cncm";
        System.out.println("Directory name *DONE*");
    }

    public static void getKeyA() {
        String keyA;
        String[] keyASplit = null;
        try {
            keyA = getRootElement(getDocument("C:/" + directoryName + "/" + directoryFiles + "cfg.xml")).getAttribute("v300_Header").trim();
            keyASplit = keyA.split(" ");
            boardKeyA = keyASplit[keyASplit.length-1];
            System.out.println("KeyA *DONE*");
        } catch (Exception e) {
            exceptionText = exceptionText.equals("") ? "Error getting KeyA" : exceptionText;
            System.out.println("Exception thrown while getting KeyA\n" + e);
        }
    }

    public static Element trimEmptyElements(Element node) {
        try {
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
        } catch (Exception e) {
            exceptionText = exceptionText.equals("") ? "Error trimming elements" : exceptionText;
            System.out.println("Exception thrown while gtrimming empty elements\n" + e);
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
            exceptionText = exceptionText.equals("") ? "Error getting document from: " + filePath : exceptionText;
            System.out.println("Exception thrown while getting document from: " + filePath + "\n" + e);
        }
        return document;
    }

    public static Element getRootElement(Document document) {
        Element rootElement = null;
        try {
            rootElement = document.getDocumentElement();
        } catch (Exception e) {
            exceptionText = exceptionText.equals("") ? "Error getting root element from document" : exceptionText;
            System.out.println("Exception thrown while getting root element from document\n" + e);
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
            exceptionText = exceptionText.equals("") ? "Error writing to file: " + filePath : exceptionText;
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
            exceptionText = exceptionText.equals("") ? "Error setting raw version" : exceptionText;
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
            exceptionText = exceptionText.equals("") ? "Error getting combined version" : exceptionText;
            System.out.println("Exception thrown while getting combined version\n" + e);
        }
        if (versionSplitSplit.length == 2) {
            return Double.parseDouble(versionSplitSplit[0] + versionSplitSplit[1]);
        } else {
            return Double.parseDouble(versionSplitSplit[0] + versionSplitSplit[1] + "." + versionSplitSplit[2]);
        }
    }

    public static void getBoardType() {
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
            exceptionText = exceptionText.equals("") ? "Error setting board type" : exceptionText;
            System.out.println("Exception thrown while setting board type\n" + e);
        }
        if (oldBoard.equals(newBoard)) {
            board = newBoard;
            System.out.println("Board type *DONE*");
        } else {
            exceptionText = "Board mismatch: " + oldBoard + " and " + newBoard;
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
        Parent root = FXMLLoader.load(getClass().getResource("scene1.fxml"));
        Scene scene = new Scene(root);
        scene.getStylesheets().add(this.getClass().getResource("app.css").toExternalForm());
        
        stage.setTitle("CNC12 Update Wizard");
        stage.getIcons().add(icon);
        stage.setResizable(false);
        stage.setX(50);
        stage.setY(50);
        stage.setFullScreen(false);

        stage.setScene(scene);
        stage.show();
    }
}

package com.frogman650;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
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
    public static ArrayList<String> exceptionText = new ArrayList<>();
    public static ArrayList<String> warningText = new ArrayList<>();
    public static ArrayList<String> successText = new ArrayList<>();
    public static String board = "";
    public static String directoryName = "";
    public static String directoryFiles = "";
    public static String oldversionRaw = "";
    public static String newversionRaw = "";
    public static double oldversionCombined = 0.0;
    public static double newversionCombined = 0.0;
    public static String oldBoardKeyA = "";
    public static String newBoardKeyA = "";
    public static Boolean usbBobInstalled = false;
    public static void main(String[] args) throws Exception {
        launch(args);
    }

    public static void resetBoardInfo() {
        board = "";
        directoryName = "";
        directoryFiles = "";
        oldversionRaw = "";
        newversionRaw = "";
        oldversionCombined = 0.0;
        newversionCombined = 0.0;
        oldBoardKeyA = "";
        newBoardKeyA = "";
        usbBobInstalled = false;
        inputsMap.clear();
        outputsMap.clear();
        usbInputsMap.clear();
        newParamsToCheck.clear();
        oldParamsToCheck.clear();
    }

    public static void resetMessageBox() {
        exceptionText.clear();
        warningText.clear();
        successText.clear();
    }

    public static void checkBoardAndVersion() {
        if (board.equals("hickory") && oldversionCombined < 520) {
            exceptionText.add("Hickory updater only available for CNC12 v5.20 and newer");
        }
        if (board.equals("acorn") && oldversionCombined < 500) {
            exceptionText.add("Acorn updater only available for CNC12 v5.00 and newer");
        }
        if (board.equals("acornsix") && oldversionCombined < 500) {
            exceptionText.add("AcornSix updater only available for CNC12 v5.00 and newer");
        }
    }

    public static void transferBobConfig() {
        File file = new File("C:/old " + directoryName + "/" + directoryFiles + ".bobcfg.xml");
        if (file.exists()) {
            try {
                Document newCfgDocument = getDocument("C:/" + directoryName + "/" + directoryFiles + ".bobcfg.xml");
                NodeList oldCfgNodeList = getRootElement(getDocument("C:/old " + directoryName + "/" + directoryFiles + ".bobcfg.xml")).getChildNodes();
                NodeList newCfgNodeList = getRootElement(newCfgDocument).getChildNodes();
                for (int i = 0; i < oldCfgNodeList.getLength(); i++) {
                    NodeList oldCfgInputList = oldCfgNodeList.item(i).getChildNodes();
                    NodeList newCfgInputList = newCfgNodeList.item(i).getChildNodes();
                    for (int j = 0; j < oldCfgInputList.getLength(); j++) {
                        for (int k = 0; k < newCfgInputList.getLength(); k++) {
                            if (oldCfgInputList.item(j).getAttributes().getNamedItem("index").getNodeValue().equals(newCfgInputList.item(k).getAttributes().getNamedItem("index").getNodeValue())) {
                                newCfgInputList.item(k).setTextContent(oldCfgInputList.item(j).getTextContent());
                            }
                        }
                    }
                }
                writeToXml("C:/" + directoryName + "/" + directoryFiles + ".bobcfg.xml", newCfgDocument);
                successText.add("USB-BOB config transferred");
            } catch (Exception e) {
                exceptionText.add("Error transferring bob config\n    " + e);
            }
        }
    }

    public static void createPresetIOFile() {
        try {
            File newFile = new File("C:/"+ directoryName +"/resources/wizard/saved/plcPresets/Previous_IO.xml");
            if (newFile.exists()) {
                newFile.delete();
            }
            newFile.createNewFile();
            BufferedWriter writer = new BufferedWriter(new FileWriter("C:/"+ directoryName +"/resources/wizard/saved/plcPresets/Previous_IO.xml", true));
            writer.write("<?xml version=\"1.0\" encoding=\"utf-8\"?><IOPreset xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\"" + 
            " xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"><Name>Previous_IO</Name><IsCustom>true</IsCustom></IOPreset>");
            writer.close();
        } catch (Exception e) {
            exceptionText.add("Error creating preset IO file\n    " + e);
        }
    }

    public static void createPresetIO() {
        getIO();
        createPresetIOFile();
        try {
            Document previousIODocument = getDocument("C:/"+ directoryName +"/resources/wizard/saved/plcPresets/Previous_IO.xml");
            NodeList functionsNodeList = getDocument("C:/"+ directoryName +"/resources/wizard/default/plc/functions.xml").getElementsByTagName("PlcFunction");
            Element previousIORootElement = getRootElement(previousIODocument);
            Element inputNode = previousIODocument.createElement("Inputs");
            Element outputNode = previousIODocument.createElement("Outputs");
            for (int i = 0; i < functionsNodeList.getLength(); i++) {
                Element displayName = (Element) functionsNodeList.item(i);
                NodeList nameNodeList = displayName.getElementsByTagName("Name");
                String name = nameNodeList.item(0).getTextContent();
                Node importNode = functionsNodeList.item(i);
                if (inputsMap.containsKey(name)) {
                    Element definitionNode = previousIODocument.createElement("Definition");
                    Element IONumberNode = previousIODocument.createElement("IONumber");
                    IONumberNode.setTextContent(inputsMap.get(name).split("P")[1]);
                    Element isSelectedNode = previousIODocument.createElement("IsSelected");
                    isSelectedNode.setTextContent("true");
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
                    }
                    definitionNode.appendChild(isSelectedNode);
                    definitionNode.appendChild(IONumberNode);
                    inputNode.appendChild(definitionNode);
                } else if (outputsMap.containsKey(name)) {
                    Element definitionNode = previousIODocument.createElement("Definition");
                    Element IONumberNode = previousIODocument.createElement("IONumber");
                    IONumberNode.setTextContent(outputsMap.get(name).split("T")[1]);
                    Element isSelectedNode = previousIODocument.createElement("IsSelected");
                    isSelectedNode.setTextContent("true");
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
                    }
                    definitionNode.appendChild(isSelectedNode);
                    definitionNode.appendChild(IONumberNode);
                    outputNode.appendChild(definitionNode);
                }
            }
            previousIORootElement.appendChild(inputNode);
            previousIORootElement.appendChild(outputNode);
            writeToXml("C:/"+ directoryName +"/resources/wizard/saved/plcPresets/Previous_IO.xml", previousIODocument);
            successText.add("IO preset created");
        } catch (Exception e) {
            exceptionText.add("Error creating IO preset\n    " + e);
        }
    }

    public static void getIO() {
        try {
            File file = new File("C:/old " + directoryName + "/mpu.plc");
            Element functionsRootElement = getRootElement(getDocument("C:/"+ directoryName +"/resources/wizard/default/plc/functions.xml"));
            for (int i = functionsRootElement.getChildNodes().getLength()-1; i >= 0; i--) {
                if (!functionsRootElement.getChildNodes().item(i).getAttributes().getNamedItem("xsi:type").getNodeValue().equals("UsbInput")) {
                    functionsRootElement.removeChild(functionsRootElement.getChildNodes().item(i));
                }
            }
            NodeList functionsNodeList = functionsRootElement.getChildNodes();
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
                    inputsMap.put(trimReplaceSplit(line)[1].equals("Ohmic_Sensor") ? "OhmicSensor" : trimReplaceSplit(line)[1], trimReplaceSplit(line)[3]);
                } else if (record && region.equals("outputs")) {
                    outputsMap.put(trimReplaceSplit(line)[1].equals("ChipPumpOut_O") ? "WashDownOut_O" : trimReplaceSplit(line)[1], trimReplaceSplit(line)[3]);
                } else if (record && region.equals("usbinputs")) {
                    usbBobInstalled = true;
                    String lineSplitSV = trimReplaceSplit(line)[1];
                    String lineSPlitINP = trimReplaceSplit(line)[3].split("_")[trimReplaceSplit(line)[3].split("_").length-2] + 
                    trimReplaceSplit(line)[3].split("_")[trimReplaceSplit(line)[3].split("_").length-1];
                    for (int i = 0; i < functionsNodeList.getLength(); i++) {
                        Element nameNode = (Element) functionsNodeList.item(i);
                        NodeList nameNodeList = nameNode.getElementsByTagName("Name");
                        NodeList displayNameNodeList = nameNode.getElementsByTagName("DisplayName");
                        String name = nameNodeList.item(0).getTextContent();
                        String displayName = displayNameNodeList.item(0).getTextContent();
                        if (lineSplitSV.equals(name)) {
                        lineSplitSV = displayName;
                        usbInputsMap.put(lineSPlitINP, lineSplitSV);
                        }
                    }
                }
            }
            scanner.close();
        } catch (Exception e) {
            exceptionText.add("Error getting IO\n    " + e);
            }
        }

    public static void copyToolChangeFile() {
        try {
            Document newWizardSettingsDocument = getDocument("C:/" + directoryName + "/wizardsettings.xml");
            Node toolChangeFileNode = getRootElement(newWizardSettingsDocument).getElementsByTagName("CustomToolChangeMacro").item(0);
            Element toolChangeElement = (Element) toolChangeFileNode;
            if (toolChangeElement.getAttribute("value").equals("True")) {
                Files.copy(Paths.get(directoryName.equals("cnct") ? "C:/old " + directoryName + "/cnctch.mac" : "C:/old " + directoryName + "/mfunc6.mac"), 
                Paths.get(directoryName.equals("cnct") ? "C:/" + directoryName + "/cnctch.mac" : "C:/" + directoryName + "/mfunc6.mac"), StandardCopyOption.REPLACE_EXISTING);
                successText.add("Tool change macro transferred");
            }
        } catch (Exception e) {
            exceptionText.add("Error copying tool change macro\n    " + e);
        }
    }

    public static void setHomingType() {
        try {
            Document newWizardSettingsDocument = getDocument("C:/" + directoryName + "/wizardsettings.xml");
            Node homingFileNode = getRootElement(newWizardSettingsDocument).getElementsByTagName("HomingFileType").item(0);
            Node oldCfgNode = getRootElement(getDocument("C:/old " + directoryName + "/" + directoryFiles + "cfg.xml")).getElementsByTagName("v300_ControlInfo").item(0);
            String homingTypeValue = oldCfgNode.getAttributes().getNamedItem("v300_HomeAtPowerup").getNodeValue();
            if (oldversionCombined < 540 && getOldParamValue(5)%2 == 1) {
                homingFileNode.getAttributes().getNamedItem("value").setNodeValue("NoHome");
            } else if (oldversionCombined < 520) {
                if (getOldParamValue(414) == 1) {
                homingFileNode.getAttributes().getNamedItem("value").setNodeValue("Custom");
                } else if (homingTypeValue.equals("0")) {
                homingFileNode.getAttributes().getNamedItem("value").setNodeValue("Simple");
                } else if (homingTypeValue.equals("1")) {
                homingFileNode.getAttributes().getNamedItem("value").setNodeValue("Automatic");
                } else if (homingTypeValue.equals("2")) {
                homingFileNode.getAttributes().getNamedItem("value").setNodeValue("ClearPathHardStop");
                }
            }
            writeToXml("C:/" + directoryName + "/wizardsettings.xml", newWizardSettingsDocument);
        } catch (Exception e) {
            exceptionText.add("Error while setting homing type\n    " + e);
        }
    }

    public static void setControlPanelType() {
        try {
            Document newWizardSettingsDocument = getDocument("C:/" + directoryName + "/wizardsettings.xml");
            Node controlPanelNode = getRootElement(newWizardSettingsDocument).getElementsByTagName("VCPorJogPanel").item(0);
            Node newCfgNode = getRootElement(getDocument("C:/" + directoryName + "/" + directoryFiles + "cfg.xml")).getElementsByTagName("v300_ControlInfo").item(0);
            String controlPanelTypeValue = newCfgNode.getAttributes().getNamedItem("v300_ConsoleType").getNodeValue();
            if (board.equals("acorn")) {
                if (controlPanelTypeValue.equals("0")) {
                    controlPanelNode.getAttributes().getNamedItem("value").setNodeValue("1");
                } else if (controlPanelTypeValue.equals("2")) {
                    controlPanelNode.getAttributes().getNamedItem("value").setNodeValue("0");
                } else if (controlPanelTypeValue.equals("4")) {
                    controlPanelNode.getAttributes().getNamedItem("value").setNodeValue("2");
                }
            }
            writeToXml("C:/" + directoryName + "/wizardsettings.xml", newWizardSettingsDocument);
        } catch (Exception e) {
            exceptionText.add("Error while setting control panel type\n    " + e);
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
                successText.add("Homing file transferred");
            }
        } catch (Exception e) {
            exceptionText.add("Error while copying home file\n    " + e);
        }
    }

    public static void transferParms() {
        defineParams();
        try {
            Document newParmDocument = getDocument("C:/" + directoryName + "/" + directoryFiles + ".prm.xml");
            NodeList oldParmNodeList = getRootElement(getDocument("C:/old " + directoryName + "/" + directoryFiles + ".prm.xml")).getElementsByTagName("value");
            NodeList newParmNodeList = getRootElement(newParmDocument).getElementsByTagName("value");
            Double fourthPairing = 0.0;
            Double fifthPairing = 0.0;
            for(int i = 0; i < oldParmNodeList.getLength(); i ++) {
                Node oldParmNode = oldParmNodeList.item(i);
                Node newParmNode = newParmNodeList.item(i);
                Element element = (Element) oldParmNode;
                Double parmValue = Double.parseDouble(element.getTextContent());
                if (i == 64 && parmValue != 0 && oldversionCombined < 540) {
                    //handle transferring P64 from older versions to P554/555 in newer versions
                    Double[] oldPairingParam = {64.0, 48.0, 32.0, 16.0, 3.0, 2.0, 1.0};
                    for (int j = 0; j < oldPairingParam.length; j++) {
                        if (parmValue >= oldPairingParam[j]) {
                            if (parmValue >= 16) {
                                fifthPairing = oldPairingParam[j] / 16;
                            } else {
                                fourthPairing = oldPairingParam[j];
                            }
                            parmValue -= oldPairingParam[j];
                        }
                    }
                } else if (i == 507 && parmValue != 0 && board.equals("acorn")) {
                    if (parmValue < 0) {
                        parmValue = parmValue * -1;
                    }
                    fourthPairing = parmValue;
                } else if (i == 554) {
                    newParmNode.setTextContent(fourthPairing.toString());
                } else if (i == 555) {
                    newParmNode.setTextContent(fifthPairing.toString());
                }
                if (oldParamsToCheck.contains(i) && newParamsToCheck.contains(i)) {
                    newParmNode.setTextContent(parmValue.toString());
                    //newParmNode.setTextContent("69");//for testing
                }
            }
            writeToXml("C:/" + directoryName + "/" + directoryFiles + ".prm.xml", newParmDocument);
            successText.add("Parameters transferred");
        } catch (Exception e) {
            exceptionText.add("Error transferring parameters\n    " + e);
        }
    }

    public static void copyParkMacro() {
        if (getOldParamValue(413) == 1) {
            try {
                Files.copy(Paths.get("C:/old " + directoryName + "/system/park.mac"), 
                Paths.get("C:/" + directoryName + "/system/park.mac"), StandardCopyOption.REPLACE_EXISTING);
                successText.add("Park file transferred");
            } catch (Exception e) {
                exceptionText.add("Error copying park.mac\n    " + e);
            }
        }
    }

    public static Double getOldParamValue(int param) {
        NodeList oldParmNodeList = getRootElement(getDocument("C:/old " + directoryName + "/" + directoryFiles + ".prm.xml")).getElementsByTagName("value");
        return Double.parseDouble(oldParmNodeList.item(param).getTextContent());
    }

    public static Double getNewParamValue(int param) {
        NodeList newParmNodeList = getRootElement(getDocument("C:/" + directoryName + "/" + directoryFiles + ".prm.xml")).getElementsByTagName("value");
        return Double.parseDouble(newParmNodeList.item(param).getTextContent());
    }

    public static void defineParams() {
        newParamsToCheck.clear();
        oldParamsToCheck.clear();
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document1 = builder.parse(App.class.getResourceAsStream("/com/frogman650/" + board + "/" + directoryName + "/" + roundVersion(oldversionCombined) +".xml"));
            Document document2 = builder.parse(App.class.getResourceAsStream("/com/frogman650/" + board + "/" + directoryName + "/" + roundVersion(newversionCombined) +".xml"));
            NodeList oldVersionNodeList = getRootElement(document1).getElementsByTagName("Parameter");
            NodeList newVersionNodeList = getRootElement(document2).getElementsByTagName("Parameter");
            for (int i = 0; i < oldVersionNodeList.getLength(); i++) {
                oldParamsToCheck.add(Integer.parseInt(oldVersionNodeList.item(i).getTextContent()));
            }
            for (int i = 0; i < newVersionNodeList.getLength(); i++) {
                newParamsToCheck.add(Integer.parseInt(newVersionNodeList.item(i).getTextContent()));
            }
        } catch (Exception e) {
            exceptionText.add("Error defining parameters\n    " + e);
        }
    }

    public static void transferConfig() {
        try {
            Document newCfgDocument = getDocument("C:/" + directoryName + "/" + directoryFiles + "cfg.xml");
            NodeList oldCfgNodeList = getRootElement(getDocument("C:/old " + directoryName + "/" + directoryFiles + "cfg.xml")).getChildNodes();
            NodeList newCfgNodeList = getRootElement(newCfgDocument).getChildNodes();
            for (int i = 0; i < oldCfgNodeList.getLength(); i++) {
                Element element = (Element) oldCfgNodeList.item(i);
                Element element2 = (Element) newCfgNodeList.item(i);
                NamedNodeMap attributes = element.getAttributes();
                NamedNodeMap attributes2 = element2.getAttributes();
                for (int j = 0; j < attributes.getLength(); j++) {
                    for (int k = 0; k < attributes2.getLength(); k++) {
                        if (attributes.item(j).getNodeName().equals(attributes2.item(k).getNodeName())) {
                            if (attributes.item(j).getNodeName().equals("v300_ConsoleType") && attributes.item(j).getNodeValue().equals("1")) {
                                //if console type set to "Legacy" previously, set it to M400/M39 VCP
                                element2.setAttribute(attributes2.item(k).getNodeName(), "4");
                            } else if (attributes.item(j).getNodeName().equals("v300_ConsoleType") && getOldParamValue(219) == 0 && oldversionCombined < 540) {
                                //If VCP was previously off in < 5.40 change panel type to M400/M39
                                element2.setAttribute(attributes2.item(k).getNodeName(), "0");
                            } else {
                                element2.setAttribute(attributes2.item(k).getNodeName(), attributes.item(j).getTextContent());
                            }
                        break;
                        }
                    }
                }
            }
            writeToXml("C:/" + directoryName + "/" + directoryFiles + "cfg.xml", newCfgDocument);
            successText.add("Config settings transferred");
        } catch (Exception e) {
            exceptionText.add("Error transferring config\n    " + e);
        }
    }

    public static void transferWizardSettings() {
        try {
            Document newWizardSettingsDocument = getDocument("C:/" + directoryName + "/wizardsettings.xml");
            NodeList oldWizardSettingsNodeList = getRootElement(getDocument("C:/old " + directoryName + "/wizardsettings.xml")).getChildNodes();
            Element newWizardRootElement = getRootElement(newWizardSettingsDocument);
            NodeList newWizardSettingsNodeList = newWizardRootElement.getChildNodes();
            for (int i = oldWizardSettingsNodeList.getLength()-1; i >= 0; i --) {
                for (int j = 0; j < newWizardSettingsNodeList.getLength(); j ++) {
                    if (oldWizardSettingsNodeList.item(i).toString().equals(newWizardSettingsNodeList.item(j).toString())) {
                        Element element = (Element) oldWizardSettingsNodeList.item(i);
                        Element element2 = (Element) newWizardSettingsNodeList.item(j);
                        element2.setAttribute("value", element.getAttribute("value"));
                    }
                }
            }
            Boolean customToolChangeMacro = newWizardRootElement.getElementsByTagName("CustomToolChangeMacro").item(0).getAttributes()
            .getNamedItem("value").getNodeValue().equals("True");
            if (customToolChangeMacro) {
                newWizardRootElement.getElementsByTagName("ATCWritten").item(0).getAttributes().getNamedItem("value").setNodeValue("True");
            }
            writeToXml("C:/" + directoryName + "/wizardsettings.xml", newWizardSettingsDocument);
            setHomingType();
            setControlPanelType();
            successText.add("Wizard settings transferred");
        } catch (Exception e) {
            exceptionText.add("Error transferring wizard settings\n    " + e);
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
            successText.add("VCP Options transferred");
        } catch (Exception e) {
            exceptionText.add("Error transferring VCP options\n    " + e);
        }
    }

    public static void copyToolLibrary() {
        try {
            if (directoryName.equals("cnct")) {
                Files.copy(Paths.get("C:/old "+ directoryName +"/"+ directoryFiles +".ttl"), Paths.get("C:/"+ directoryName +"/"+ directoryFiles +".ttl"), StandardCopyOption.REPLACE_EXISTING);
            } else {
                Files.copy(Paths.get("C:/old "+ directoryName +"/"+ directoryFiles +".tl"), Paths.get("C:/"+ directoryName +"/"+ directoryFiles +".tl"), StandardCopyOption.REPLACE_EXISTING);
            }
            successText.add("Tool library transferred");
        } catch (Exception e) {
            exceptionText.add("Error copying tool library\n    " + e);
        }
    }

    public static void copyStats() {
        try {
            Files.copy(Paths.get("C:/old "+ directoryName +"/mt.stats"), Paths.get("C:/"+ directoryName +"/mt.stats"), StandardCopyOption.REPLACE_EXISTING);
            successText.add("Stats transferred");
        } catch (Exception e) {
            exceptionText.add("Error copying stats file\n    " + e);
        }
    }

    public static void copyScales() {
        File file = new File("C:/old "+ directoryName +"/scale_settings.xml");
        if (file.exists()) {
            try {
                Files.copy(Paths.get("C:/old "+ directoryName +"/scale_settings.xml"), Paths.get("C:/"+ directoryName +"/scale_settings.xml"), StandardCopyOption.REPLACE_EXISTING);
            successText.add("Scales settings transferred");
            } catch (Exception e) {
            exceptionText.add("Error copying scales settings\n    " + e);
            }
        }
    }

    public static void copyWCS() {
        try {
            Files.copy(Paths.get("C:/old "+ directoryName +"/"+ directoryFiles +".wcs"), Paths.get("C:/"+ directoryName +"/"+ directoryFiles +".wcs"), StandardCopyOption.REPLACE_EXISTING);
            successText.add("WCS positions transferred");
        } catch (Exception e) {
            exceptionText.add("Error copying WCS file\n    " + e);
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
                            } else if (oldRackMountNodeList.item(i).getNodeName().equals("Speed")) {
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
            successText.add("Rack mount settings transferred");
            } catch (Exception e) {
                exceptionText.add("Error transferring rack mount settings\n    " + e);
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
            successText.add("Plasma config settings transferred");
            } catch (Exception e) {
                exceptionText.add("Error transferring plasma config\n    " + e);
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
            successText.add("Carousel settings transferred");
            } catch (Exception e) {
                exceptionText.add("Error transferring carousel settings\n    " + e);
            }
        }
    }

    public static void copyOffsetLibrary() {
        if (!directoryName.equals("cnct")) {
            try {
                Files.copy(Paths.get("C:/old "+ directoryName +"/"+ directoryFiles +".ol"), Paths.get("C:/"+ directoryName +"/"+ directoryFiles +".ol"), StandardCopyOption.REPLACE_EXISTING);
                successText.add("Offset library transferred");
            } catch (Exception e) {
            exceptionText.add("Error copying offset library\n    " + e);
            }
        }
    }

    public static void copyLicense() {
        try {
            File file = new File("C:/old "+ directoryName +"/license.dat");
            if (file.exists() && (newBoardKeyA.equals(oldBoardKeyA))) {
            Files.copy(Paths.get("C:/old "+ directoryName +"/license.dat"), Paths.get("C:/"+ directoryName +"/license.dat"), StandardCopyOption.REPLACE_EXISTING);
            successText.add("License transferred");
            return;
            }
            if (!newBoardKeyA.equals(oldBoardKeyA)) {
                warningText.add("License not transferred: KeyA mismatch");
            } else {
                warningText.add("License not found");
            }
        } catch (Exception e) {
            exceptionText.add("Error copying license\n    " + e);
        }
    }

    public static void setOldBoardSoftwareInfo() {
        try {
            oldversionRaw = setRawVersion("C:/old " + directoryName + "/" + directoryFiles + ".prm.xml");
            oldversionCombined = getVersionCombined(oldversionRaw);
        } catch (Exception e) {
            exceptionText.add("Error setting old software version\n    " + e);
        }
    }

    public static void setNewBoardSoftwareInfo() {
        try {
            newversionRaw = setRawVersion("C:/" + directoryName + "/" + directoryFiles + ".prm.xml");
            newversionCombined = getVersionCombined(newversionRaw);
        } catch (Exception e) {
            exceptionText.add("Error setting new software version\n    " + e);
        }
    }

    public static void setDirectoryName() {
        if (checkDirectory("cncm")) {
            directoryName = "cncm"; 
        }
        if (checkDirectory("cnct")) {
            if (directoryName != "") {
                exceptionText.add("More than 1 old and new directory combination found");
            }
            directoryName = "cnct"; 
        }
        if (checkDirectory("cncr")) {
            if (directoryName != "") {
                exceptionText.add("More than 1 old and new directory combination found");
            }
            directoryName = "cncr"; 
        }
        if (checkDirectory("cncp")) {
            if (directoryName != "") {
                exceptionText.add("More than 1 old and new directory combination found");
            }
            directoryName = "cncp"; 
        }
        if (checkDirectory("cncl")) {
            if (directoryName != "") {
                exceptionText.add("More than 1 old and new directory combination found");
            }
            directoryName = "cncl"; 
        }
        if (directoryName.equals("")) {
            exceptionText.add("No directory combination found");
        }
        directoryFiles = directoryName.equals("cnct") ? "cnct" : "cncm";
    }

    public static void getOldKeyA() {
        String keyA;
        String[] keyASplit = null;
        try {
            keyA = getRootElement(getDocument("C:/old " + directoryName + "/" + directoryFiles + "cfg.xml")).getAttribute("v300_Header").trim();
            keyASplit = keyA.split(" ");
            oldBoardKeyA = keyASplit[keyASplit.length-1];
        } catch (Exception e) {
            exceptionText.add("Error getting old KeyA\n    " + e);
        }
    }

    public static void getNewKeyA() {
        String keyA;
        String[] keyASplit = null;
        try {
            keyA = getRootElement(getDocument("C:/" + directoryName + "/" + directoryFiles + "cfg.xml")).getAttribute("v300_Header").trim();
            keyASplit = keyA.split(" ");
            newBoardKeyA = keyASplit[keyASplit.length-1];
        } catch (Exception e) {
            exceptionText.add("Error getting new KeyA\n    " + e);
        }
    }

    public static Boolean checkKeyA() {
        getOldKeyA();
        getNewKeyA();
        if (!oldBoardKeyA.equals(newBoardKeyA)) {
            warningText.add("KeyA mismatch: " + oldBoardKeyA + " and " + newBoardKeyA);
            return false;
        }
        return true;
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
            exceptionText.add("Error trimming elements\n    " + e);
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
            exceptionText.add("Error getting document from: " + filePath + "\n    " + e);
        }
        return document;
    }

    public static Element getRootElement(Document document) {
        Element rootElement = null;
        try {
            rootElement = document.getDocumentElement();
        } catch (Exception e) {
            exceptionText.add("Error getting root element from document\n    " + e);
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
            exceptionText.add("Error writing to file: " + filePath + "\n    " + e);
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
            exceptionText.add("Error setting raw version\n    " + e);
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
            exceptionText.add("Error getting combined version\n    " + e);
        }
        double versionCombined = Double.parseDouble(versionSplitSplit[0] + versionSplitSplit[1]);
        if (versionCombined == 539) {//For beta testing of 5.39
            return 540.0;
        }
        return Math.floor(versionCombined / 10) * 10;
    }

    public static void getOldBoard() {
        NodeList boardVersionNodeList;
        String boardVersion;
        String oldBoard = null;
        String oldFilePath = "C:/old " + directoryName + "/mpu_info.xml";
        try {
            boardVersionNodeList = getRootElement(getDocument(oldFilePath)).getElementsByTagName("PLCDeviceID");
            boardVersion = boardVersionNodeList.item(0).getTextContent();
            oldBoard = boardVersion.split("_")[2];
            board = oldBoard;
        } catch (Exception e) {
            exceptionText.add("Error getting old board type\n    " + e);
        }
    }

    public static String getNewBoard() {
        NodeList boardVersionNodeList;
        String boardVersion;
        String newBoard = null;
        String newFilePath ="C:/" + directoryName + "/mpu_info.xml";
        try {
            boardVersionNodeList = getRootElement(getDocument(newFilePath)).getElementsByTagName("PLCDeviceID");
            boardVersion = boardVersionNodeList.item(0).getTextContent();
            newBoard = boardVersion.split("_")[2];
        } catch (Exception e) {
            exceptionText.add("Error getting new board type\n    " + e);
        }
        return newBoard;
    }

    public static void checkBoards() {
        getOldBoard();
        String newBoard = getNewBoard();
        if (!board.equals(newBoard)) {
            warningText.add("Board mismatch: " + board + " and " + newBoard);
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
        
        stage.setTitle("CNC12 Updater");
        stage.getIcons().add(icon);
        stage.setResizable(true);
        stage.setX(50);
        stage.setY(50);
        stage.setFullScreen(false);

        stage.setScene(scene);
        stage.show();
    }
}

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;

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

public class App {
    public static ArrayList<Integer> oldParamsToCheck = new ArrayList<>();
    public static ArrayList<Integer> newParamsToCheck = new ArrayList<>();
    public static String board;
    public static String directoryName = "";
    public static String directoryFiles;
    public static String oldversionRaw;
    public static String newversionRaw;
    public static double oldversionCombined;
    public static double newversionCombined;
    public static void main(String[] args) throws Exception {
        //Check for CNC12 directories
        if (checkDirectory("cncm")) {
            directoryName = "cncm"; 
            System.out.println("Software: Mill");
        }
        if (checkDirectory("cnct")) {
            if (directoryName != "") {
                throw new IllegalArgumentException("More than 1 old and new directory combination found"); 
            }
            directoryName = "cnct"; 
            System.out.println("Software: Lathe");
        }
        if (checkDirectory("cncr")) {
            if (directoryName != "") {
                throw new IllegalArgumentException("More than 1 old and new directory combination found"); 
            }
            directoryName = "cncr"; 
            System.out.println("Software: Router");
        }
        if (checkDirectory("cncp")) {
            if (directoryName != "") {
                throw new IllegalArgumentException("More than 1 old and new directory combination found"); 
            }
            directoryName = "cncp"; 
            System.out.println("Software: Plasma");
        }
        if (checkDirectory("cncl")) {
            if (directoryName != "") {
                throw new IllegalArgumentException("More than 1 old and new directory combination found"); 
            }
            directoryName = "cncl"; 
            System.out.println("Software: Laser");
        }
        if (directoryName.equals("")) {
            throw new IllegalArgumentException("No directory combination found");
        }
        if (directoryName.equals("cnct")) {
            directoryFiles = "cnct";
        } else {
            directoryFiles = "cncm";
        }

        //Set file and directory paths
        String oldParmFile = "C:/old " + directoryName + "/" + directoryFiles + ".prm.xml";
        String newParmFile = "C:/" + directoryName + "/" + directoryFiles + ".prm.xml";
        String oldCfgFile = "C:/old " + directoryName + "/" + directoryFiles + "cfg.xml";
        String newCfgFile = "C:/" + directoryName + "/" + directoryFiles + "cfg.xml";
        String oldWizardSettingsFile = "C:/old " + directoryName + "/wizardsettings.xml";
        String newWizardSettingsFile = "C:/" + directoryName + "/wizardsettings.xml";
        String oldOptionsFile = "C:/old " + directoryName + "/resources/vcp/options.xml";
        String newOptionsFile = "C:/" + directoryName + "/resources/vcp/options.xml";
        String oldHomeFile = "C:/old " + directoryName + "/" + directoryFiles + ".hom";
        String newHomeFile = "C:/" + directoryName + "/" + directoryFiles + ".hom";
        String oldCarouselSettingsFile = "C:/old " + directoryName + "/FixedCarouselSettings.xml";
        String newCarouselSettingsFile = "C:/" + directoryName + "/FixedCarouselSettings.xml";
        String oldRackMountFile = "C:/old " + directoryName + "/RackMountBin.xml";
        String newRackMountFile = "C:/" + directoryName + "/RackMountBin.xml";
        String oldToolChangeMacroFile;
        String newToolChangeMacroFile;
        if (directoryName.equals("cnct")) {
            oldToolChangeMacroFile = "C:/old " + directoryFiles + "/cnctch.mac";
            newToolChangeMacroFile = "C:/" + directoryFiles + "/cnctch.mac";
        } else {
            oldToolChangeMacroFile = "C:/old " + directoryFiles + "/mfunc6.mac";
            newToolChangeMacroFile = "C:/" + directoryFiles + "/mfunc6.mac";
        }

        //Open documents
        Document oldParmDocument = getDocument(oldParmFile);
        Document newParmDocument = getDocument(newParmFile);
        Document oldCfgDocument = getDocument(oldCfgFile);
        Document newCfgDocument = getDocument(newCfgFile);
        Document oldWizardSettingsDocument = getDocument(oldWizardSettingsFile);
        Document newWizardSettingsDocument = getDocument(newWizardSettingsFile);
        Document oldOptionsDocument = getDocument(oldOptionsFile);
        Document newOptionsDocument = getDocument(newOptionsFile);
        Document oldCarouselSettingsDocument = getDocument(oldCarouselSettingsFile);
        Document newCarouselSettingsDocument = getDocument(newCarouselSettingsFile);
        Document oldRackMountDocument = getDocument(oldRackMountFile);
        Document newRackMountDocument = getDocument(newRackMountFile);

        //Get board and software versions
        oldversionRaw = setRawVersion(oldParmFile);
        newversionRaw = setRawVersion(newParmFile);
        oldversionCombined = getVersionCombined(oldversionRaw);
        newversionCombined = getVersionCombined(newversionRaw);

        System.out.println("Board: " + board);
        System.out.println("Old version: " + oldversionRaw);
        System.out.println("New version: " + newversionRaw);
        
        //License file
        try {
            Files.copy(Paths.get("C:/old "+ directoryName +"/license.dat"), Paths.get("C:/"+ directoryName +"/license.dat"), StandardCopyOption.REPLACE_EXISTING);
            System.out.println("License DONE");
        } catch (Exception e) {
            System.out.println("Exception thrown while copying license file");
            System.out.println(e);
        }
        
        //Offset library file
        if (!directoryName.equals("cnct")) {
            try {
                Files.copy(Paths.get("C:/old "+ directoryName +"/"+ directoryFiles +".ol"), Paths.get("C:/"+ directoryName +"/"+ directoryFiles +".ol"), StandardCopyOption.REPLACE_EXISTING);
                System.out.println("Offset library DONE");
            } catch (Exception e) {
                System.out.println("Exception thrown while copying tool library file");
                System.out.println(e);
            }
        }
        
        //Carousel settings file
        if (directoryName.equals("cncm") || directoryName.equals("cncr")) {
            try {
                NodeList oldCarouselNodeList = getRootElement(oldCarouselSettingsDocument).getChildNodes();
                NodeList newCarouselNodeList = getRootElement(newCarouselSettingsDocument).getChildNodes();
                for (int i = 1; i < newCarouselNodeList.getLength(); i = i+2) {
                    for (int j = 1; j < oldCarouselNodeList.getLength(); j = j+2) {
                        if (newCarouselNodeList.item(i).getNodeName().equals(oldCarouselNodeList.item(j).getNodeName())) {
                            newCarouselNodeList.item(i).setTextContent(oldCarouselNodeList.item(j).getTextContent());
                        }
                    }
                }
                writeToXml(newCarouselSettingsFile, newCarouselSettingsDocument);
                System.out.println("Carousel settings DONE");
            } catch (Exception e) {
                System.out.println("Exception thrown while parsing carousel file");
                System.out.println(e);
            }
        }
        
        //Rack mount settings file
        if (directoryName.equals("cncm") || directoryName.equals("cncr")) {
            try {
                NodeList oldRackMountNodeList = getRootElement(oldRackMountDocument).getElementsByTagName("Bin");
                NodeList newRackMountNodeList = getRootElement(newRackMountDocument).getElementsByTagName("Bin");
                for (int i = 0; i < oldRackMountNodeList.getLength(); i ++) {
                    for (int j = 1; j < oldRackMountNodeList.item(i).getChildNodes().getLength(); j = j+2) {
                        for (int k = 1; k < newRackMountNodeList.item(i).getChildNodes().getLength(); k = k+2) {
                            if (oldRackMountNodeList.item(i).getChildNodes().item(j).getNodeName().equals(newRackMountNodeList.item(i).getChildNodes().item(k).getNodeName())) {
                                newRackMountNodeList.item(i).getChildNodes().item(k).setTextContent(oldRackMountNodeList.item(i).getChildNodes().item(j).getTextContent());
                            }//this works fine, just doesnt account for settings that aren't bins, needs fixed
                            
                        }
                    }
                }
                writeToXml(newRackMountFile, newRackMountDocument);
                System.out.println("Rack mount settings DONE");
            } catch (Exception e) {
                System.out.println("Exception thrown while parsing rack mount file");
                System.out.println(e);
            }
        }

        //WCS file
        try {
            Files.copy(Paths.get("C:/old "+ directoryName +"/"+ directoryFiles +".wcs"), Paths.get("C:/"+ directoryName +"/"+ directoryFiles +".wcs"), StandardCopyOption.REPLACE_EXISTING);
            System.out.println("WCS DONE");
        } catch (Exception e) {
            System.out.println("Exception thrown while copying WCS file");
            System.out.println(e);
        }
        
        //Tool library file
        try {
            if (directoryName.equals("cnct")) {
                Files.copy(Paths.get("C:/old "+ directoryName +"/"+ directoryFiles +".ttl"), Paths.get("C:/"+ directoryName +"/"+ directoryFiles +".ttl"), StandardCopyOption.REPLACE_EXISTING);
            } else {
                Files.copy(Paths.get("C:/old "+ directoryName +"/"+ directoryFiles +".tl"), Paths.get("C:/"+ directoryName +"/"+ directoryFiles +".tl"), StandardCopyOption.REPLACE_EXISTING);
            }
            System.out.println("Tool library DONE");
            
        } catch (Exception e) {
            System.out.println("Exception thrown while copying tool library file");
            System.out.println(e);
        }
        
        //Options file
        try {
            NodeList oldOptionsNodeList = getRootElement(oldOptionsDocument).getElementsByTagName("VcpOption");
            NodeList newOptionsNodeList = getRootElement(newOptionsDocument).getElementsByTagName("VcpOption");
            for(int i = 0; i < oldOptionsNodeList.getLength(); i ++) {
                for(int j = 0; j < newOptionsNodeList.getLength(); j ++) {
                    String oldOptionNodeText = oldOptionsNodeList.item(i).getChildNodes().item(1).getTextContent();
                    String newOptionNodeText = newOptionsNodeList.item(j).getChildNodes().item(1).getTextContent();
                    if (oldOptionNodeText.equals(newOptionNodeText)) {
                        newOptionsNodeList.item(j).getChildNodes().item(3).setTextContent(oldOptionsNodeList.item(i).getChildNodes().item(3).getTextContent());
                        break;
                    }
                }
            }
            writeToXml(newOptionsFile, newOptionsDocument);
            System.out.println("VCP options DONE");
        } catch (Exception e) {
            System.out.println("Exception thrown during options.xml parsing");
            System.out.println(e);
        }

        //Wizard settings file
        try {
            NodeList oldWizardSettingsNodeList = getRootElement(oldWizardSettingsDocument).getChildNodes();
            NodeList newWizardSettingsNodeList = getRootElement(newWizardSettingsDocument).getChildNodes();
            for (int i = oldWizardSettingsNodeList.getLength()-2; i > 0; i = i-2) {
                for (int j = 1; j < newWizardSettingsNodeList.getLength(); j = j+2) {
                    if (oldWizardSettingsNodeList.item(i).toString().equals(newWizardSettingsNodeList.item(j).toString())) {
                        Element element = (Element) oldWizardSettingsNodeList.item(i);
                        Element element2 = (Element) newWizardSettingsNodeList.item(j);
                        element2.setAttribute("value", element.getAttribute("value"));
                    }
                }
            }
            writeToXml(newWizardSettingsFile, newWizardSettingsDocument);
            System.out.println("Wizard settings DONE");
        } catch (Exception e) {
            System.out.println("Exception thrown during wizardsettings.xml parsing");
            System.out.println(e);
        }

        //Config settings file
        try {
            NodeList oldCfgNodeList = getRootElement(oldCfgDocument).getChildNodes();
            NodeList newCfgNodeList = getRootElement(newCfgDocument).getChildNodes();
        for (int i = 1; i < oldCfgNodeList.getLength(); i = i+2) {
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
        writeToXml(newCfgFile, newCfgDocument);
        System.out.println("Config DONE");
        } catch (Exception e) {
            System.out.println("Exception thrown during config file parsing");
            System.out.println(e);
        }
        
        //Define params to check by version
        NodeList oldVersionNodeList = getRootElement(getDocument("src/"+ roundVersion(oldversionCombined) +".xml")).getElementsByTagName("Parameter");
        NodeList newVersionNodeList = getRootElement(getDocument("src/"+ roundVersion(newversionCombined) +".xml")).getElementsByTagName("Parameter");
        for (int i = 0; i < oldVersionNodeList.getLength(); i++) {
            oldParamsToCheck.add(Integer.parseInt(oldVersionNodeList.item(i).getTextContent()));
        }
        for (int i = 0; i < newVersionNodeList.getLength(); i++) {
            newParamsToCheck.add(Integer.parseInt(newVersionNodeList.item(i).getTextContent()));
        }

        //Parm values file
        try {
            NodeList oldParmNodeList = getRootElement(oldParmDocument).getElementsByTagName("value");
            NodeList newParmNodeList = getRootElement(newParmDocument).getElementsByTagName("value");
            for(int i = 0; i < oldParmNodeList.getLength(); i ++) {
                Node oldParmNode = oldParmNodeList.item(i);
                Node newParmNode = newParmNodeList.item(i);
                Element element = (Element) oldParmNode;
                String text = element.getTextContent();
                if (oldParamsToCheck.contains(i) && newParamsToCheck.contains(i)) {
                    newParmNode.setTextContent(text);
                }
            }
            writeToXml(newParmFile, newParmDocument);
            System.out.println("Parameters DONE");
        } catch (Exception e) {
            System.out.println("Exception thrown during param file parsing");
            System.out.println(e);
        }

        //Homing file
        try {
            Node homingFileNode = getRootElement(newWizardSettingsDocument).getElementsByTagName("HomingFileType").item(0);
            Element homingElement = (Element) homingFileNode;
            if (homingElement.getAttribute("value").equals("Custom")) {
                Files.copy(Paths.get(oldHomeFile), Paths.get(newHomeFile), StandardCopyOption.REPLACE_EXISTING);
                System.out.println("Homing file DONE");
            }
        } catch (Exception e) {
            System.out.println("Exception thrown while copying homing file");
            System.out.println(e);
        }
        
        //Tool change file
        try {
            Node toolChangeFileNode = getRootElement(newWizardSettingsDocument).getElementsByTagName("CustomToolChangeMacro").item(0);
            Element toolChangeElement = (Element) toolChangeFileNode;
            if (toolChangeElement.getAttribute("value").equals("True")) {
                Files.copy(Paths.get(oldToolChangeMacroFile), Paths.get(newToolChangeMacroFile), StandardCopyOption.REPLACE_EXISTING);
                System.out.println("Tool change macro DONE");
            }
        } catch (Exception e) {
            System.out.println("Exception thrown while copying tool change macro");
            System.out.println(e);
        }

        //FINISHED
        System.out.println("Update finished");
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
            System.out.println("Exception thrown while getting document from: " + filePath);
            System.out.println(e);
        }
        return document;
    }

    public static Element getRootElement(Document document) {
        Element rootElement = null;
        try {
            rootElement = document.getDocumentElement();
        } catch (Exception e) {
            System.out.println("Exception thrown while getting root element from document");
            System.out.println(e);
        }
            return rootElement;
    }

    public static void writeToXml(String filePath, Document document) {
        try {
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource docSource = new DOMSource(document);
            StreamResult docResult = new StreamResult(new File(filePath));
            transformer.transform(docSource, docResult);
        } catch (Exception e) {
            System.out.println("Exception thrown while writing to file: " + filePath);
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
            System.out.println("Exception thrown while setting raw version");
        }
        board = softwareVersionSplit[0];
        return softwareVersionSplit[3];
    }

    public static double getVersionCombined(String rawVersion) {
        String[] versionSplitSplit = null;
        try {
            versionSplitSplit = rawVersion.split("\\.");
        } catch (Exception e) {
            System.out.println("Exception thrown while getting combined version");
        }
        if (versionSplitSplit.length == 2) {
            return Double.parseDouble(versionSplitSplit[0] + versionSplitSplit[1]);
        } else {
            return Double.parseDouble(versionSplitSplit[0] + versionSplitSplit[1] + "." + versionSplitSplit[2]);
        }
    }

    public static Boolean checkDirectory(String directory) {
        File firstDirectory = new File("C:/" + directory);
        File secondDirectory = new File("C:/old " + directory);
        return firstDirectory.exists() && secondDirectory.exists();
    }
}

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
    public static ArrayList<String> paramValues = new ArrayList<>();
    public static ArrayList<Integer> paramsToCheck = new ArrayList<>();
    public static String board;
    public static String directoryName = "";
    public static String directoryFiles;
    public static String oldversionRaw;
    public static String newversionRaw;
    public static double oldversionCombined;
    public static double newversionCombined;
    public static void main(String[] args) throws Exception {
        //File and directory paths
        String cncmDirectoryPath = "C:/cncm";
        String cnctDirectoryPath = "C:/cnct";
        String cncrDirectoryPath = "C:/cncr";
        String cncpDirectoryPath = "C:/cncp";
        String cnclDirectoryPath = "C:/cncl";
        String oldCncmDirectoryPath = "C:/old cncm";
        String oldCnctDirectoryPath = "C:/old cnct";
        String oldCncrDirectoryPath = "C:/old cncr";
        String oldCncpDirectoryPath = "C:/old cncp";
        String oldCnclDirectoryPath = "C:/old cncl";

        //Check for CNC12 directories
        File cncmDirectory = new File(cncmDirectoryPath);
        File cnctDirectory = new File(cnctDirectoryPath);
        File cncrDirectory = new File(cncrDirectoryPath);
        File cncpDirectory = new File(cncpDirectoryPath);
        File cnclDirectory = new File(cnclDirectoryPath);
        File oldCncmDirectory = new File(oldCncmDirectoryPath);
        File oldCnctDirectory = new File(oldCnctDirectoryPath);
        File oldCncrDirectory = new File(oldCncrDirectoryPath);
        File oldCncpDirectory = new File(oldCncpDirectoryPath);
        File oldCnclDirectory = new File(oldCnclDirectoryPath);
        if (cncmDirectory.exists() && oldCncmDirectory.exists()) {
            directoryName = "cncm"; 
            System.out.println("Software: Mill");
        }
        if (cnctDirectory.exists() && oldCnctDirectory.exists()) {
            if (directoryName != "") {
                throw new IllegalArgumentException("More than 1 old and new directory combination found"); 
            }
            directoryName = "cnct"; 
            System.out.println("Software: Lathe");
        }
        if (cncrDirectory.exists() && oldCncrDirectory.exists()) {
            if (directoryName != "") {
                throw new IllegalArgumentException("More than 1 old and new directory combination found"); 
            }
            directoryName = "cncr"; 
            System.out.println("Software: Router");
        }
        if (cncpDirectory.exists() && oldCncpDirectory.exists()) {
            if (directoryName != "") {
                throw new IllegalArgumentException("More than 1 old and new directory combination found"); 
            }
            directoryName = "cncp"; 
            System.out.println("Software: Plasma");
        }
        if (cnclDirectory.exists() && oldCnclDirectory.exists()) {
            if (directoryName != "") {
                throw new IllegalArgumentException("More than 1 old and new directory combination found"); 
            }
            directoryName = "cncl"; 
            System.out.println("Software: Laser");
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
        String oldToolChangeMacroFile;
        String newToolChangeMacroFile;
        if (directoryName.equals("cnct")) {
            oldToolChangeMacroFile = "C:/old " + directoryFiles + "/cnctch.mac";
            newToolChangeMacroFile = "C:/" + directoryFiles + "/cnctch.mac";
        } else {
            oldToolChangeMacroFile = "C:/old " + directoryFiles + "/mfunc6.mac";
            newToolChangeMacroFile = "C:/" + directoryFiles + "/mfunc6.mac";
        }

        //Document builder factory
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        //Document builder
        DocumentBuilder builder = factory.newDocumentBuilder();

        //Parse the xml document
        Document oldParmDocument = builder.parse(new File(oldParmFile));
        Document newParmDocument = builder.parse(new File(newParmFile));

        Document oldCfgDocument = builder.parse(new File(oldCfgFile));
        Document newCfgDocument = builder.parse(new File(newCfgFile));

        Document oldWizardSettingsDocument = builder.parse(new File(oldWizardSettingsFile));
        Document newWizardSettingsDocument = builder.parse(new File(newWizardSettingsFile));

        Document oldOptionsDocument = builder.parse(new File(oldOptionsFile));
        Document newOptionsDocument = builder.parse(new File(newOptionsFile));

        //Get root elements
        Element oldParmRootElement = oldParmDocument.getDocumentElement();
        Element newParmRootElement = newParmDocument.getDocumentElement();

        Element oldCfgRootElement = oldCfgDocument.getDocumentElement();
        Element newCfgRootElement = newCfgDocument.getDocumentElement();

        Element oldWizardSettingsRootElement = oldWizardSettingsDocument.getDocumentElement();
        Element newWizardSettingsRootElement = newWizardSettingsDocument.getDocumentElement();

        Element oldOptionsRootElement = oldOptionsDocument.getDocumentElement();
        Element newOptionsRootElement = newOptionsDocument.getDocumentElement();

        //Get board and software versions
        try {
            NodeList oldsoftwareVersionNodeList = oldParmRootElement.getElementsByTagName("SoftwareVersion");
            NodeList newsoftwareVersionNodeList = newParmRootElement.getElementsByTagName("SoftwareVersion");
            String oldsoftwareVersion = oldsoftwareVersionNodeList.item(0).getTextContent();
            String newsoftwareVersion = newsoftwareVersionNodeList.item(0).getTextContent();
            String[] oldsoftwareVersionSplit = oldsoftwareVersion.split(" ");
            String[] newsoftwareVersionSplit = newsoftwareVersion.split(" ");
            board = oldsoftwareVersionSplit[0];
            oldversionRaw = oldsoftwareVersionSplit[3];
            newversionRaw = newsoftwareVersionSplit[3];
            String[] oldversionSplitSplit = oldversionRaw.split("\\.");
            String[] newversionSplitSplit = newversionRaw.split("\\.");
            if (oldversionSplitSplit.length == 2) {
                oldversionCombined = Double.parseDouble(oldversionSplitSplit[0] + oldversionSplitSplit[1]);
            } else {
                oldversionCombined = Double.parseDouble(oldversionSplitSplit[0] + oldversionSplitSplit[1] + "." + oldversionSplitSplit[2]);
            }
            if (newversionSplitSplit.length == 2) {
                newversionCombined = Double.parseDouble(newversionSplitSplit[0] + newversionSplitSplit[1]);
            } else {
                newversionCombined = Double.parseDouble(newversionSplitSplit[0] + newversionSplitSplit[1] + "." + newversionSplitSplit[2]);
            }
            System.out.println("Board: " + board);
            System.out.println("New version: " + oldversionRaw);
            System.out.println("Old version: " + newversionRaw);
        } catch (Exception e) {
            System.out.println("Exception thrown while getting board and software version");
            System.out.println(e);
        }
        
        //License file
        try {
            Files.copy(Paths.get("C:/old cncm/license.dat"), Paths.get("C:/cncm/license.dat"), StandardCopyOption.REPLACE_EXISTING);
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
            NodeList oldOptionsNodeList = oldOptionsRootElement.getElementsByTagName("VcpOption");
            NodeList newOptionsNodeList = newOptionsRootElement.getElementsByTagName("VcpOption");
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
            System.out.println("options.xml DONE");
        } catch (Exception e) {
            System.out.println("Exception thrown during options.xml parsing");
            System.out.println(e);
        }

        //Wizard settings file
        try {
            NodeList oldWizardSettingsNodeList = oldWizardSettingsRootElement.getChildNodes();
            NodeList newWizardSettingsNodeList = newWizardSettingsRootElement.getChildNodes();
            for (int i = oldWizardSettingsNodeList.getLength()-2; i > 0; i = i-2) {
                for (int j = 1; j < newWizardSettingsNodeList.getLength(); j = j+2) {
                    if (oldWizardSettingsNodeList.item(i).toString().equals(newWizardSettingsNodeList.item(j).toString())) {
                        Element element = (Element) oldWizardSettingsNodeList.item(i);
                        Element element2 = (Element) newWizardSettingsNodeList.item(j);
                        element2.setAttribute("value", element.getAttribute("value"));
                    }
                }
            }
            System.out.println("wizardsettings.xml DONE");
        } catch (Exception e) {
            System.out.println("Exception thrown during wizardsettings.xml parsing");
            System.out.println(e);
        }

        //Config settings file
        try {
            NodeList oldCfgNodeList = oldCfgRootElement.getChildNodes();
        NodeList newCfgNodeList = newCfgRootElement.getChildNodes();
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
        System.out.println("cncmcfg.xml DONE");
        } catch (Exception e) {
            System.out.println("Exception thrown during config file parsing");
            System.out.println(e);
        }
        
        //Define params to check by version
        if (529 < oldversionCombined && oldversionCombined < 540) {
            paramsToCheck.add(2);
            paramsToCheck.add(3);
            paramsToCheck.add(5);
            paramsToCheck.add(6);
            paramsToCheck.add(12);
            paramsToCheck.add(13);
            paramsToCheck.add(14);
            paramsToCheck.add(15);
            paramsToCheck.add(16);
            paramsToCheck.add(17);
            paramsToCheck.add(19);
            paramsToCheck.add(34);
            paramsToCheck.add(36);
            paramsToCheck.add(37);
            paramsToCheck.add(39);
            paramsToCheck.add(40);
            paramsToCheck.add(41);
            paramsToCheck.add(42);
            paramsToCheck.add(43);
            paramsToCheck.add(46);
            paramsToCheck.add(65);
            paramsToCheck.add(66);
            paramsToCheck.add(68);
            paramsToCheck.add(69);
            paramsToCheck.add(71);
            paramsToCheck.add(74);
            paramsToCheck.add(78);
            paramsToCheck.add(82);
            paramsToCheck.add(84);
            paramsToCheck.add(110);
            paramsToCheck.add(113);
            paramsToCheck.add(143);
            paramsToCheck.add(146);
            paramsToCheck.add(148);
            paramsToCheck.add(150);
            paramsToCheck.add(153);
            paramsToCheck.add(154);
            paramsToCheck.add(155);
            paramsToCheck.add(161);
            paramsToCheck.add(179);
            paramsToCheck.add(188);
            paramsToCheck.add(189);
            paramsToCheck.add(190);
            paramsToCheck.add(191);
            paramsToCheck.add(192);
            paramsToCheck.add(193);
            paramsToCheck.add(194);
            paramsToCheck.add(195);
            paramsToCheck.add(196);
            paramsToCheck.add(197);
            paramsToCheck.add(198);
            paramsToCheck.add(199);
            paramsToCheck.add(218);
            paramsToCheck.add(219);
            paramsToCheck.add(240);
            paramsToCheck.add(241);
            paramsToCheck.add(263);
            paramsToCheck.add(292);
            paramsToCheck.add(293);
            paramsToCheck.add(294);
            paramsToCheck.add(295);
            paramsToCheck.add(348);
            paramsToCheck.add(349);
            paramsToCheck.add(350);
            paramsToCheck.add(400);
            paramsToCheck.add(401);
            paramsToCheck.add(403);
            paramsToCheck.add(405);
            paramsToCheck.add(406);
            paramsToCheck.add(407);
            paramsToCheck.add(409);
            paramsToCheck.add(410);
            paramsToCheck.add(411);
            paramsToCheck.add(413);
            paramsToCheck.add(416);
            paramsToCheck.add(417);
            paramsToCheck.add(418);
            paramsToCheck.add(419);
            paramsToCheck.add(420);
            paramsToCheck.add(421);
            paramsToCheck.add(422);
            paramsToCheck.add(425);
            paramsToCheck.add(430);
            paramsToCheck.add(431);
            paramsToCheck.add(432);
            paramsToCheck.add(495);
            paramsToCheck.add(501);
            paramsToCheck.add(502);
            paramsToCheck.add(507);
            paramsToCheck.add(560);
            paramsToCheck.add(561);
            paramsToCheck.add(800);
            paramsToCheck.add(801);
            paramsToCheck.add(802);
            paramsToCheck.add(803);
            paramsToCheck.add(804);
            paramsToCheck.add(805);
            paramsToCheck.add(806);
            paramsToCheck.add(807);
            paramsToCheck.add(808);
            paramsToCheck.add(809);
            paramsToCheck.add(810);
            paramsToCheck.add(811);
            paramsToCheck.add(812);
            paramsToCheck.add(813);
            paramsToCheck.add(814);
            paramsToCheck.add(815);
            paramsToCheck.add(817);
            paramsToCheck.add(830);
            paramsToCheck.add(852);
            paramsToCheck.add(855);
            paramsToCheck.add(856);
            paramsToCheck.add(960);
            paramsToCheck.add(962);
            paramsToCheck.add(967);
            paramsToCheck.add(968);
            paramsToCheck.add(982);
            paramsToCheck.add(983);
            paramsToCheck.add(984);
            paramsToCheck.add(991);
            paramsToCheck.add(996);
            paramsToCheck.add(997);
            paramsToCheck.add(998);
        }

        //Parm values file
        try {
            NodeList oldParmNodeList = oldParmRootElement.getElementsByTagName("value");
            NodeList newParmNodeList = newParmRootElement.getElementsByTagName("value");
            for(int i = 0; i < oldParmNodeList.getLength(); i ++) {
                Node oldParmNode = oldParmNodeList.item(i);
                Node newParmNode = newParmNodeList.item(i);
                Element element = (Element) oldParmNode;
                String text = element.getTextContent();
                if (paramsToCheck.contains(i)) {
                    newParmNode.setTextContent(text);
                }
            }
            System.out.println("cncm.prm.xml DONE");
        } catch (Exception e) {
            System.out.println("Exception thrown while during param file parsing");
            System.out.println(e);
        }
        

        //Special cases

        //Homing file
        try {
            Node homingFileNode = newWizardSettingsRootElement.getElementsByTagName("HomingFileType").item(0);
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
            Node toolChangeFileNode = newWizardSettingsRootElement.getElementsByTagName("CustomToolChangeMacro").item(0);
            Element toolChangeElement = (Element) toolChangeFileNode;
            if (toolChangeElement.getAttribute("value").equals("True")) {
                Files.copy(Paths.get(oldToolChangeMacroFile), Paths.get(newToolChangeMacroFile), StandardCopyOption.REPLACE_EXISTING);
                System.out.println("Tool change macro DONE");
            }
        } catch (Exception e) {
            System.out.println("Exception thrown while copying tool change macro");
            System.out.println(e);
        }
        

        //Write to the xml files
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();

        DOMSource parmDocSource = new DOMSource(newParmDocument);
        DOMSource cfgDocSource = new DOMSource(newCfgDocument);
        DOMSource wizardSettingsDocSource = new DOMSource(newWizardSettingsDocument);
        DOMSource optionsDocSource = new DOMSource(newOptionsDocument);

        StreamResult parmDocResult = new StreamResult(new File(newParmFile));
        StreamResult cfgDocResult = new StreamResult(new File(newCfgFile));
        StreamResult wizardSettingsDocResult = new StreamResult(new File(newWizardSettingsFile));
        StreamResult optionsDocResult = new StreamResult(new File(newOptionsFile));

        transformer.transform(parmDocSource, parmDocResult);
        transformer.transform(cfgDocSource, cfgDocResult);
        transformer.transform(wizardSettingsDocSource, wizardSettingsDocResult);
        transformer.transform(optionsDocSource, optionsDocResult);

        System.out.println("ALL FILES SAVED");

    }
}

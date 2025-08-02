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

    private static final String oldParmFile = "C:/old cncm/cncm.prm.xml";
    private static final String newParmFile = "C:/cncm/cncm.prm.xml";
    private static final String oldCfgFile = "C:/old cncm/cncmcfg.xml";
    private static final String newCfgFile = "C:/cncm/cncmcfg.xml";
    private static final String oldWizardSettingsFile = "C:/old cncm/wizardsettings.xml";
    private static final String newWizardSettingsFile = "C:/cncm/wizardsettings.xml";
    private static final String oldOptionsFile = "C:/old cncm/resources/vcp/options.xml";
    private static final String newOptionsFile = "C:/cncm/resources/vcp/options.xml";
    public static ArrayList<String> paramValues = new ArrayList<>();
    public static ArrayList<Integer> paramsToCheck = new ArrayList<>();
    public static String board;
    public static String oldversionRaw;
    public static String newversionRaw;
    public static double oldversionCombined;
    public static double newversionCombined;
    public static void main(String[] args) throws Exception {
        paramsToCheck.add(700);
        paramsToCheck.add(710);
        paramsToCheck.add(720);
        paramsToCheck.add(725);
        paramsToCheck.add(738);
        paramsToCheck.add(750);
        paramsToCheck.add(775);
        paramsToCheck.add(792);

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

        //License file
        Files.copy(Paths.get("C:/old cncm/license.dat"), Paths.get("C:/cncm/license.dat"), StandardCopyOption.REPLACE_EXISTING);
        System.out.println("License DONE");

        //Options file
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

        //Wizard settings file
        NodeList oldWizardSettingsNodeList = oldWizardSettingsRootElement.getChildNodes();
        NodeList newWizardSettingsNodeList = newWizardSettingsRootElement.getChildNodes();
        for (int i = 1; i < oldWizardSettingsNodeList.getLength(); i = i+2) {
            for (int j = 1; j < newWizardSettingsNodeList.getLength(); j = j+2) {
                if (oldWizardSettingsNodeList.item(i).toString().equals(newWizardSettingsNodeList.item(j).toString())) {
                    Element element = (Element) oldWizardSettingsNodeList.item(i);
                    Element element2 = (Element) newWizardSettingsNodeList.item(j);
                    element2.setAttribute("value", element.getAttribute("value"));
                    break;
                }
            }
        }
        System.out.println("wizardsettings.xml DONE");

        //Config settings file
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

        //Parm values file
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

import java.io.File;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class App {

    private static final String oldParmFile = "C:/old cncm/cncm.prm.xml";
    private static final String newParmFile = "C:/cncm/cncm.prm.xml";
    private static final String oldCfgFile = "C:/old cncm/cncmcfg.xml";
    private static final String newCfgFile = "C:/cncm/cncmcfg.xml";
    private static final String oldWizardSettingsFile = "C:/old cncm/wizardsettings.xml";
    private static final String newWizardSettingsFile = "C:/cncm/wizardsettings.xml";
    public static ArrayList<String> paramValues = new ArrayList<>();
    public static ArrayList<Integer> paramsToCheck = new ArrayList<>();
    public static String board;
    public static String versionRaw;
    public static double versionCombined;
    public static void main(String[] args) throws Exception {
        paramsToCheck.add(700);
        paramsToCheck.add(710);
        paramsToCheck.add(720);
        paramsToCheck.add(725);
        paramsToCheck.add(738);
        paramsToCheck.add(750);
        paramsToCheck.add(775);
        paramsToCheck.add(792);
        //1. Document builder factory
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        //2. Document builder
        DocumentBuilder builder = factory.newDocumentBuilder();
        //3. Parse the xml document
        Document oldParmDocument = builder.parse(new File(oldParmFile));
        Document newParmDocument = builder.parse(new File(newParmFile));

        Document oldCfgDocument = builder.parse(new File(oldCfgFile));
        Document newCfgDocument = builder.parse(new File(newCfgFile));

        Document oldWizardSettingsDocument = builder.parse(new File(oldWizardSettingsFile));
        Document newWizardSettingsDocument = builder.parse(new File(newWizardSettingsFile));

        //4. Get root element
        Element oldParmRootElement = oldParmDocument.getDocumentElement();
        Element newParmRootElement = newParmDocument.getDocumentElement();

        Element oldCfgRootElement = oldCfgDocument.getDocumentElement();
        Element newCfgRootElement = newCfgDocument.getDocumentElement();

        Element oldWizardSettingsRootElement = oldWizardSettingsDocument.getDocumentElement();
        Element newWizardSettingsRootElement = newWizardSettingsDocument.getDocumentElement();

        //Get board and software version
        NodeList softwareVersionNodeList = oldParmRootElement.getElementsByTagName("SoftwareVersion");
        String softwareVersion = softwareVersionNodeList.item(0).getTextContent();
        String[] softwareVersionSplit = softwareVersion.split(" ");
        board = softwareVersionSplit[0];
        versionRaw = softwareVersionSplit[3];
        String[] versionSplitSplit = versionRaw.split("\\.");
        if (versionSplitSplit.length == 2) {
            versionCombined = Double.parseDouble(versionSplitSplit[0] + versionSplitSplit[1]);
        } else {
            versionCombined = Double.parseDouble(versionSplitSplit[0] + versionSplitSplit[1] + "." + versionSplitSplit[2]);
        }
        System.out.println(versionCombined);

        // //5. Get node list
        // NodeList oldParmNodeList = oldParmRootElement.getElementsByTagName("value");
        // NodeList newParmNodeList = newParmRootElement.getElementsByTagName("value");
        // //6. Iterate through node list and get elements and attributes
        // for(int i = 0; i < oldParmNodeList.getLength(); i ++) {
        //     Node oldParmNode = oldParmNodeList.item(i);
        //     Node newParmNode = newParmNodeList.item(i);
        //     Element element = (Element) oldParmNode;
        //     String index = element.getAttribute("index");
        //     String text = element.getTextContent();
        //     if (paramsToCheck.contains(i)) {
        //         newParmNode.setTextContent("69");//replace 69 with text after testing
        //     }
        // }
        // System.out.println("Param values set");

        // //Write to the xml files
        // TransformerFactory transformerFactory = TransformerFactory.newInstance();
        // Transformer transformer = transformerFactory.newTransformer();

        // DOMSource parmDocSource = new DOMSource(newParmDocument);
        // DOMSource cfgDocSource = new DOMSource(newCfgDocument);
        // DOMSource wizardSettingsDocSource = new DOMSource(newWizardSettingsDocument);

        // StreamResult parmDocResult = new StreamResult(new File(newParmFile));
        // StreamResult cfgDocResult = new StreamResult(new File(newCfgFile));
        // StreamResult wizardSettingsDocResult = new StreamResult(new File(newWizardSettingsFile));

        // transformer.transform(parmDocSource, parmDocResult);
        // transformer.transform(cfgDocSource, cfgDocResult);
        // transformer.transform(wizardSettingsDocSource, wizardSettingsDocResult);

        // System.out.println("xml values written");

    }
}

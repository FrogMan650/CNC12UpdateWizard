import java.io.File;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class App {

    private static final String readFileName = "C:/cncm/cncm.prm.xml";
    private static final String writeFileName = "C:/Users/Lucas/Desktop/cncm.prm_testing.xml";
    public static ArrayList<String> paramValues = new ArrayList<>();
    public static ArrayList<Integer> paramsToCheck = new ArrayList<>();
    public static void main(String[] args) throws Exception {
        paramsToCheck.add(0);
        paramsToCheck.add(10);
        paramsToCheck.add(120);
        paramsToCheck.add(320);
        paramsToCheck.add(359);
        paramsToCheck.add(496);
        paramsToCheck.add(856);
        paramsToCheck.add(999);
        //1. Document builder factory
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        //2. Document builder
        DocumentBuilder builder = factory.newDocumentBuilder();
        //3. Parse the xml document
        Document readDocument = builder.parse(new File(readFileName));
        Document writeDocument = builder.parse(new File(writeFileName));
        //4. Get root element
        Element readRootElement = readDocument.getDocumentElement();
        Element writeRootElement = writeDocument.getDocumentElement();
        //5. Get node list
        String tagName = "value";
        NodeList readNodeList = readRootElement.getElementsByTagName(tagName);
        NodeList writeNodeList = writeRootElement.getElementsByTagName(tagName);
        //6. Iterate through node list and get elements and attributes
        for(int i = 0; i < readNodeList.getLength(); i ++) {
            Node readNode = readNodeList.item(i);
            Node writeNode = writeNodeList.item(i);
            Element element = (Element) readNode;
            String index = element.getAttribute("index");
            String text = element.getTextContent();
            if (paramsToCheck.contains(i)) {
                writeNode.setTextContent(text);
            }
        }

        //Write to the new xml file
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(writeDocument);
        StreamResult result = new StreamResult(new File(writeFileName));
        transformer.transform(source, result);

    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.kpi.epam.xmlproject.dom;

import java.util.LinkedList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import ua.kpi.epam.xmlproject.warplanes.model.Warplane;
import ua.kpi.epam.xmlproject.warplanes.model.WarplaneType;

/**
 * DOM parsing of XML 
 * @author Dima
 */
public class DomParser {

    List<Warplane> planeList = new LinkedList<>();

    public List<Warplane> getPlanes() {
        return planeList;
    }

    /**
     * Parsing xml file with DOM
     * @param filename file
     */
    public void parse(String filename) {
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document document = db.parse(filename);
            Element root = document.getDocumentElement();
            parsePlanes(root.getChildNodes());
        } catch (Exception ex) {
            System.out.println("Error while parsing document " + filename);
        }
    }

    /**
     * Parse <warplane> tag
     * @param planes 
     */
    private void parsePlanes(NodeList planes) {
        for (int i = 0; i < planes.getLength(); i++) {
            Node node = planes.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element planeElement = (Element) node;
                Warplane planeEntity = new Warplane();
                planeEntity.setName(planeElement.getAttribute("name"));
                planeEntity.setPrice(Integer.valueOf(planeElement.getAttribute("price")));
                parsePlane(planeElement, planeEntity);
                planeList.add(planeEntity);
            }
        }

    }
    /**
     * Parse tags in <warplane> tag
     * @param planeElement
     * @param planeEntity 
     */
    private void parsePlane(Element planeElement, Warplane planeEntity) {
        try {
            Element originElement = (Element) planeElement.getElementsByTagName("origin").item(0);
            planeEntity.setOrigin(originElement.getFirstChild().getNodeValue());
            Element charsElement = (Element) planeElement.getElementsByTagName("chars").item(0);
            planeEntity.setType(((Element) charsElement.getElementsByTagName("type").item(0)).getFirstChild().getNodeValue());
            planeEntity.setPlace(Integer.valueOf(((Element) charsElement.getElementsByTagName("places").item(0)).getFirstChild().getNodeValue()));
            if (planeEntity.getType() == WarplaneType.SECRET_SERVICE_AGENT) {
                planeEntity.setRocket(0);
            } else {
                 planeEntity.setRocket(Integer.valueOf(((Element) charsElement.getElementsByTagName("rocket").item(0)).getFirstChild().getNodeValue()));
            }
            planeEntity.setRadar(Boolean.valueOf(((Element) charsElement.getElementsByTagName("radar").item(0)).getFirstChild().getNodeValue())); 
            Element parametersElement = (Element)planeElement.getElementsByTagName("parameters").item(0);
            planeEntity.setLength(Double.valueOf(((Element) parametersElement.getElementsByTagName("length").item(0)).getFirstChild().getNodeValue()));
            planeEntity.setHeight(Double.valueOf(((Element) parametersElement.getElementsByTagName("height").item(0)).getFirstChild().getNodeValue()));
            planeEntity.setWidth(Double.valueOf(((Element) parametersElement.getElementsByTagName("width").item(0)).getFirstChild().getNodeValue()));
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }
}

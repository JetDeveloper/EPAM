/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.kpi.epam.xmlproject.sax;

import java.util.LinkedList;
import java.util.List;
import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;
import ua.kpi.epam.xmlproject.warplanes.model.Warplane;
import ua.kpi.epam.xmlproject.warplanes.model.WarplaneType;

/**
 * SAX handler class
 * @author Dima
 */
public class SAXParser implements ContentHandler {

    private List<Warplane> list;
    private Warplane current = null;
    private String temp;

    public List<Warplane> getList() {
        return list;
    }

    @Override
    public void setDocumentLocator(Locator locator) {
    }

    @Override
    public void startDocument() throws SAXException {
        list = new LinkedList<>();
    }

    @Override
    public void endDocument() throws SAXException {
    }

    @Override
    public void startPrefixMapping(String prefix, String uri) throws SAXException {
    }

    @Override
    public void endPrefixMapping(String prefix) throws SAXException {
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes atts) throws SAXException {
        if ("warplane".equals(localName)) {
            current = new Warplane();
            current.setName(atts.getValue("name"));
            current.setPrice(Integer.valueOf(atts.getValue("price")));

        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        switch (localName) {
            case "warplane":
                list.add(current);
                break;
            case "origin":
                current.setOrigin(temp);
                break;
            case "type":
                current.setType(temp);
                break;
            case "places":
                current.setPlace(Integer.valueOf(temp));
                break;
            case "rocket":
                try {
                    if (current.getType() == WarplaneType.SECRET_SERVICE_AGENT) {
                        current.setRocket(0);  /*SSA plane hasn't rockets */
                    } else {
                        current.setRocket(Integer.valueOf(temp));
                    }
                } catch (Exception ex) {
                    System.err.println(ex.getMessage());
                }
                break;
            case "radar":
                current.setRadar(Boolean.valueOf(temp));
                break;
            case "length":
                current.setLength(Double.valueOf(temp));
                break;
            case "width":
                current.setWidth(Double.valueOf(temp));
                break;
            case "height":
                current.setHeight(Double.valueOf(temp));
                break;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        temp = new String(ch, start, length);
    }

    @Override
    public void ignorableWhitespace(char[] ch, int start, int length) throws SAXException {
    }

    @Override
    public void processingInstruction(String target, String data) throws SAXException {
    }

    @Override
    public void skippedEntity(String name) throws SAXException {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}

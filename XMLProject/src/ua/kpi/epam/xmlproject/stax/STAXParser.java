/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.kpi.epam.xmlproject.stax;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamReader;
import ua.kpi.epam.xmlproject.warplanes.model.Warplane;
import ua.kpi.epam.xmlproject.warplanes.model.WarplaneType;

/**
 * STAX parsing xml file
 * @author Dima
 */
public class STAXParser {

    List<Warplane> list = new LinkedList<>();

    public List<Warplane> getList() {
        return list;
    }

    public void parse(String fileName) {
        XMLInputFactory inputFactory = XMLInputFactory.newInstance();
        try (InputStream ifs = new FileInputStream(fileName)) {

            XMLStreamReader reader = inputFactory.createXMLStreamReader(ifs);

            Warplane current = null;
            while (reader.hasNext()) {
                int type = reader.next();
                switch (type) {
                    case XMLStreamConstants.START_ELEMENT:
                        String name = reader.getLocalName();
                        String temp;
                        switch (name) {
                            case "warplane":
                                current = new Warplane();
                                current.setName(reader.getAttributeValue("", "name"));
                                current.setPrice(Integer.valueOf(reader.getAttributeValue("", "price")));
                                break;
                            case "origin":
                                temp = reader.getElementText();
                                current.setOrigin(temp);
                                break;
                            case "type":
                                temp = reader.getElementText();
                                current.setType(temp);
                                break;
                            case "places":
                                 temp = reader.getElementText();
                                current.setPlace(Integer.valueOf(temp));
                                break;
                            case "rocket":
                                temp = reader.getElementText();
                                try {
                                    if (current.getType() == WarplaneType.SECRET_SERVICE_AGENT) {
                                        current.setRocket(0);
                                    } else {
                                        current.setRocket(Integer.valueOf(temp));
                                    }
                                } catch (Exception ex) {
                                    System.err.println(ex.getMessage());
                                }
                                break;
                            case "radar":
                                temp = reader.getElementText();
                                current.setRadar(Boolean.valueOf(temp));
                                break;
                            case "length":
                                temp = reader.getElementText();
                                current.setLength(Double.valueOf(temp));
                                break;
                            case "width":
                                temp = reader.getElementText();
                                current.setWidth(Double.valueOf(temp));
                                break;
                            case "height":
                                temp = reader.getElementText();
                                current.setHeight(Double.valueOf(temp));
                                break;
                        }
                        break;
                    case XMLStreamConstants.END_ELEMENT: {
                        name = reader.getLocalName();
                        if ("warplane".equals(name)) {
                            list.add(current);
                        }

                    }
                }
            }
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }
}

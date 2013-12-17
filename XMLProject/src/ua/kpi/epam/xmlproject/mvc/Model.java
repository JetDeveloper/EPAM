/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.kpi.epam.xmlproject.mvc;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import ua.kpi.epam.xmlproject.dom.DomParser;
import ua.kpi.epam.xmlproject.sax.SAXParser;
import ua.kpi.epam.xmlproject.stax.STAXParser;
import ua.kpi.epam.xmlproject.warplanes.WarplaneList;
import ua.kpi.epam.xmlproject.warplanes.model.Planes;
import ua.kpi.epam.xmlproject.warplanes.model.Warplane;
import ua.kpi.epam.xmlproject.warplanes.model.WarplaneType;

/**
 * XML Model class
 * @author Dima
 */
public class Model {

    private String xmlFilePath;   /* filepath to xml file*/

    private String xsdFilePath;   /* filepath to scheme (xsd) file*/


    public Model(String xmlFilePath, String xsdFilePath) {
        this.xmlFilePath = xmlFilePath;
        this.xsdFilePath = xsdFilePath;
    }

    /**
     * Validation with default validator
     * @return true - if successful
     */
    public boolean validate() {
        try {
            SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = schemaFactory.newSchema(new File(xsdFilePath));
            Validator validator = schema.newValidator();
            validator.validate(new StreamSource(new File(xmlFilePath)));
        } catch (SAXException | IOException ex) {
            System.err.println(ex.getMessage());
            return false;
        }
        return true;
    }

    /**
     * Parse xml file with JAXB
     * @return WarplaneList of Warplanes
     */
    public WarplaneList loadWithJAXB() {
        WarplaneList planeList = new WarplaneList();
        try (InputStream ifs = new FileInputStream(xmlFilePath)) {
            JAXBContext jaxb = JAXBContext.newInstance(WarplaneList.class);
            Unmarshaller unm = jaxb.createUnmarshaller();
            planeList = (WarplaneList) unm.unmarshal(ifs);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());

        }
        return planeList;
    }

    /**
     * Parse xml with DOM method
     * @return List of Warplanes
     */
    public List<ua.kpi.epam.xmlproject.warplanes.model.Warplane> loadWithDOM() {
        DomParser domParser = new DomParser();
        domParser.parse(xmlFilePath);
        return domParser.getPlanes();
    }

    /**
     * Parse xml with SAX method
     * @return List of Warplanes
     */
    public List<ua.kpi.epam.xmlproject.warplanes.model.Warplane> loadWithSAX() {
        SAXParser handler = new SAXParser();
        try {
            XMLReader reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(handler);
            reader.parse(xmlFilePath);
        } catch (SAXException | IOException ex) {
            System.err.println(ex.getMessage());
        }
        return handler.getList();
    }

    /**
     * Parse xml with STAX method
     * @return List of Warplanes
     */
    public List<ua.kpi.epam.xmlproject.warplanes.model.Warplane> loadWithSTAX() {
        STAXParser stax = new STAXParser();
        stax.parse(xmlFilePath);
        return stax.getList();
    }

    /**
     * Serialize planes to XML with JAXB
     * @param fileName filename
     */
    public void saveToXML(String fileName) {
        try (OutputStream oft = new FileOutputStream(fileName)) {
            Planes planes = new Planes();
            planes.addPlane(new Warplane("Lockheed AC-130", 333000,
                    "USA", WarplaneType.ESCORT, 2, 1, true, 40.67, 18, 11));
            planes.addPlane(new Warplane("Як 100500", 1333000,
                    "Россия", WarplaneType.DESTROYER, 2, 1, true, 40.67, 18, 11));
            JAXBContext context = JAXBContext.newInstance(Planes.class);
            Marshaller m = context.createMarshaller();
            m.setProperty("jaxb.formatted.output", true);
            m.marshal(planes, oft);
        } catch (JAXBException | IOException ex) {
            System.err.println(ex);
        }
    }
}

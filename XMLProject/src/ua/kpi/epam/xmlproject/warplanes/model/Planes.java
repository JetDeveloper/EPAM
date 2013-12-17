/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.kpi.epam.xmlproject.warplanes.model;

import java.util.LinkedList;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Planes class - root element of serialaze file
 * @author Dima
 */

@XmlRootElement
public class Planes {
    @XmlElement(name="plane")
    public List<Warplane> planes= new LinkedList<>();

    public void addPlane(Warplane plane) {
        planes.add(plane);
    }
}
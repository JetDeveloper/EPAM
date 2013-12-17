/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.kpi.epam.xmlproject.warplanes.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * PlaneList class to serialize
 * @author Dima
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class PlaneList {
    @XmlElement(name = "planes")
    Planes planes;

    public PlaneList() {
        planes = new Planes();
    }
    
    
    public void addPlane(Warplane plane){
        planes.addPlane(plane);
    }
}

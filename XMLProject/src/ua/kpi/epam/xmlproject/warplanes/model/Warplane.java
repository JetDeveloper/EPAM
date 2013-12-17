/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.kpi.epam.xmlproject.warplanes.model;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

/**
 * Warplane class
 * @author Dima
 */
@XmlAccessorType(XmlAccessType.NONE )
public class Warplane implements Serializable {

    @XmlAttribute
    private String name;
    
    @XmlAttribute
    private int price;
    
    @XmlElement
    private String origin;
    
    @XmlElement
    private WarplaneType type;
    
    @XmlElement
    private int place;
    
    @XmlElement
    private int rocket;
    
    @XmlElement
    private boolean radar;
    
    @XmlElement
    private double length;
    
    @XmlElement
    private double width;
    
    @XmlElement
    private double height;

    public Warplane() {
    }

    
    public Warplane(String name, int price, String origin, WarplaneType type, int place, int rocket, boolean radar, double length, double width, double height) {
        this.name = name;
        this.price = price;
        this.origin = origin;
        this.type = type;
        this.place = place;
        this.rocket = rocket;
        this.radar = radar;
        this.length = length;
        this.width = width;
        this.height = height;
    }

    
    
    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public int getPlace() {
        return place;
    }

    public void setPlace(int place) {
        this.place = place;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean isRadar() {
        return radar;
    }

    public void setRadar(boolean radar) {
        this.radar = radar;
    }

    public int getRocket() {
        return rocket;
    }

    public void setRocket(int rocket) throws Exception {
        if (type == WarplaneType.SECRET_SERVICE_AGENT) {
            this.rocket = 0;
        } else if (rocket >= 0 && rocket <= 10){
            this.rocket = rocket;
        } else throw new Exception("Wrong rocket value");
    }

    public WarplaneType getType() {
        return type;
    }

    public void setType(String type) {
        this.type = WarplaneType.parse(type);
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }
}

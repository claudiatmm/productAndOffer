package dataRead.xmlNode;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class Product {

    @XmlElement(name = "name")
    public String name;
    @XmlElement(name = "price")
    public Double price;

}

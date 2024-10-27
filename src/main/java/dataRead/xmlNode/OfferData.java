package dataRead.xmlNode;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
public class OfferData {

    @XmlElement(name = "customer")
    public String customer;

    @XmlElement(name = "products")
    public List <objects.Product> products;


}

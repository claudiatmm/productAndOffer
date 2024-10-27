package dataRead.xmlNode;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "configuration")
public class Configuration {

    @XmlElement(name = "offerData")
    public List <OfferData> offerData;

//    @XmlElement(name = "products")
//    public List<Product> products;
}

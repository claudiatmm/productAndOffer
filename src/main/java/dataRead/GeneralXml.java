package dataRead;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class GeneralXml {
    public static <T> T createConfig(Class<T> klass){
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(klass);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            return klass.cast(unmarshaller.unmarshal(new File("src/main/resources/data/testData.xml")));
        }
        catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }

}

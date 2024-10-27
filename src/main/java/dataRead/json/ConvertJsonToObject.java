package dataRead.json;

import java.io.File;
import java.io.IOException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dataRead.json.products.Offer;


public class ConvertJsonToObject {

    protected Offer fromJsonFileToObject(String dataPath){
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(new File(dataPath), Offer.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}

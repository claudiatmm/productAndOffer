package dataRead.json;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import dataRead.json.products.OfferJson;

import java.io.File;
import java.io.IOException;


public class ReadAndMapValue extends ConvertJsonToObject {

    @JsonProperty("Offer")
    public dataRead.json.products.Offer offer;
    public String path;


    public ReadAndMapValue(String dataPath) {
        this.path = dataPath;
        this.offer = fromJsonFileToObject(dataPath);
    }


    public OfferJson changeNameWithRandomValue() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        offer.offer.getProducts().get(0).setName("Tmmss");
        objectMapper.writeValue(new File(path), offer);
        return offer.offer;
    }


}

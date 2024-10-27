package dataRead.json.products;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import java.util.List;

@Data
public class OfferJson {

    @JsonProperty("customer")
    public String customer;

    @JsonProperty("products")
    public List<ProductJson> products;


}

package dataRead.json.products;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;


@Data
public class ProductJson {

    @JsonProperty("name")
    public String name;

    @JsonProperty("price")
    public int price;


}

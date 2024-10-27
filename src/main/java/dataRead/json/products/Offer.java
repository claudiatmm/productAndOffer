package dataRead.json.products;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Offer {

    @JsonProperty("offer")
   public OfferJson offer;

}

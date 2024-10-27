import dataRead.json.ReadAndMapValue;
import dataRead.json.products.OfferJson;
import logs.LoggerUtility;
import objects.Offer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;


//@RunWith(SpringRunner.class)
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TestsWithJson {


    private static final Logger logger = LogManager.getLogger();


    @Test
    @DisplayName("Read Values from Json file")
    public void readValuesFromJson() {
        LoggerUtility.addScenario("First Scenario");
        ReadAndMapValue readAndMapValue = new ReadAndMapValue("src\\main\\resources\\data\\dataJ.json");
        logger.info("Values from json file are: "+readAndMapValue.offer); // read all products
    }

    @Test
    @DisplayName("Write Values from Json file")
    public void writeValuesFromJson() throws IOException {
        ReadAndMapValue readAndMapValue = new ReadAndMapValue("src\\main\\resources\\data\\dataJ.json");
        OfferJson a  = readAndMapValue.changeNameWithRandomValue();
        logger.info("Values from json file write: " + a);
    }

}

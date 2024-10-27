package logs;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggerUtility {

    private static final Logger logger = LogManager.getLogger();

    public static void addScenario(String scenarioName){
        String message = String.format("=============== Execution started : %s ===============", scenarioName);
        logger.info(message);
    }

}

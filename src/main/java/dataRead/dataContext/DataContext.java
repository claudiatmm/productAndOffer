package dataRead.dataContext;

import java.util.HashMap;

public class DataContext {


    private static final HashMap<String, Object> testData = new HashMap<>();
    // object = este parintele tuturor claselor object in java

    //save data in the context
    public static void saveData(String key, Object value) {
        testData.put(key, value);
    }

    //retrieve data from the context with specific type
    public static <T> T getData(String key, Class<T> valueType) {
        if (testData.containsKey(key)) {
            Object value = testData.get(key);
            if (valueType.isInstance(value)) {
                return valueType.cast(value);
            } else {
                throw new ClassCastException("value associated with key " + key
                        + "is not the expected one types: " + valueType.getSimpleName());
            }
        } else {
            throw new RuntimeException(" There is no value stored for the key: " + key);
        }
    }

    public static HashMap<String, Object>getTestData(){
        return testData;
    }

    public static boolean checkKeyPresence(String key){
        return testData.containsKey(key);
    }

    public static void clearContext(){
        testData.clear();
    }

}

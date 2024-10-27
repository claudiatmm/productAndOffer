package connectionDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Database {

    private String hostname = "localhost";
    private int port = 5432;
    private String username = "postgres";
    private String password = "test123";
    private  Connection connection;
    private String dataBseName = "testClau";



    public Database() {
        this.hostname = hostname;
        this.port = port;
        this.username = username;
        this.password = password;

        String connectionString = "jdbc:postgresql://"+hostname+":"+port+"/"+dataBseName;

        try {
            connection = DriverManager.getConnection(connectionString, username, password);
        }
        catch (Exception e){
            System.out.println("Cannot connect to DB !!");
        }

    }


    public void executeQuery(String query){
        try {
            connection.createStatement().execute(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet selectQuery(String sql){
        ResultSet resultSet = null;
        try {
             resultSet = connection.createStatement().executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }


//    public void insertInDb() throws SQLException {
//        String valueCreated = RandomNumber.generateRandomNumber(TableData.PRODUCT_NAME);
//        try {
//            connection.createStatement()
//                    .execute("insert into products("+ TableData.PRODUCT_LINE+",textDescription,productCode,"+ TableData.PRODUCT_NAME+") values ("+ RandomNumber.generateRandomNumber(TableData.PRODUCT_LINE)+",'Test Automation Description',5558,"+valueCreated+")");
//            System.out.println("here is value for objects.Product Name : " + valueCreated);
//        }
//        catch (Exception e){
//            e.printStackTrace();
//        }
//    }
//
//
//    public JSONObject getInsertedQuery(String valueNr){
//        JSONObject json = new JSONObject();
//        try {
//            ResultSet resultSet = connection.createStatement().executeQuery("Select * from products where productLine = '"+valueNr+"'");
//            resultSet.next(); // to no read the table head
//            json.put("productLine", resultSet.getString("productLine"));
//            json.put("textDescription", resultSet.getString("textDescription"));
//            json.put("productCode", resultSet.getString("productCode"));
//            json.put("productName", resultSet.getString("productName"));
//
//            System.out.println("here is product name: " +resultSet.getString("productName"));
//            System.out.println("here is json : " + json);
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return json;
//    }







}

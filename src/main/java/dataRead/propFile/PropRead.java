package dataRead.propFile;

import objects.Offer;
import objects.Product;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class PropRead {


    public static Properties properties = new Properties();

    public static Offer readTestDataFromPropFile() {
        Offer offer = null;
        try (InputStream input = new FileInputStream(System.getProperty("user.dir") +"\\src\\main\\resources\\dataProp\\dataT.properties")) {
            // Load the properties file
            properties.load(input);

            // Retrieve the values
            String customer = properties.getProperty("customer");
//            List<String> products = Collections.singletonList(properties.getProperty("products"));
//            List<Double> price = Collections.singletonList(Double.valueOf(properties.getProperty("price")));
//            String product = properties.getProperty("products");
//            String pr =properties.getProperty("price");
//            Product productList = new Product(product, Double.valueOf(pr));
            
            List<Product> productList1 = getProductList();
            offer = new Offer(customer,productList1);
            System.out.println("Database customer: " + customer);

        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return offer;
    }


    public static List<Product> getProductList(){
        List<Product> productsList = new ArrayList<>();

        String products = properties.getProperty("products");

        String [] listProducts = products.split(",");
        for (String a : listProducts){
            String [] productsSplit = a.split("-");
        Product product = new Product(productsSplit[0],Double.valueOf(productsSplit[1]));
        productsList.add(product);
        }
        return productsList;
    }



}

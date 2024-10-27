import dataRead.dataContext.DataContext;
import dataRead.dataContext.DataKeys;
import exception.ValidationFailedException;
import objects.Offer;
import objects.Product;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TestsWithDataContext {

    public OfferServiceImpl offerService = new OfferServiceImpl();
    public Product dataSaveIntoContext ;


    @Test
    @DisplayName("Add new product to a user and save the data into DataContext")
    public void testForCreateOffer() throws ValidationFailedException {
        Product productOne = new Product("Oil", 22.5);
        Product productTwo = new Product("Cucumber", 23.5);

        List<Product> productList = new ArrayList<>();

        productList.add(productOne);
        productList.add(productTwo);
        Offer offer = new Offer("Sati Alin", productList);

        DataContext.saveData(DataKeys.INITIAL_VALUE, productOne);
        System.out.println("here " + DataContext.getTestData());

        offerService.create(offer);
    }

//server?
    @Test
    @DisplayName("Get data save into context ")
    public void retrieveDataFromContext() throws ValidationFailedException {
        dataSaveIntoContext = DataContext.getData(DataKeys.INITIAL_VALUE, Product.class);
        System.out.println("here is data : " + dataSaveIntoContext);
    }


    @Test
    @DisplayName("getClass")
    public void test() throws ValidationFailedException, IOException {
//       Offer offer = new Offer();
//        System.out.println( offer.getClass());
//
//        HashMap<Integer, String> test = new HashMap<>();
//        test.put(2, "ana");
//        test.put(2, "tt");
//        System.out.println(test.get(2));
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(4444);
        } catch (IOException e) {
            System.err.println("Could not listen on port: 4444.");
            System.exit(1);
        }
    }

}

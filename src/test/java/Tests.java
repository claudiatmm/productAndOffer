import dataRead.GeneralXml;
import dataRead.xmlNode.Configuration;
import exception.ValidationFailedException;
import objects.Offer;
import objects.Product;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static dataRead.propFile.PropRead.readTestDataFromPropFile;

public class Tests {


    public static Configuration configuration = GeneralXml.createConfig(Configuration.class);
    public OfferServiceImpl offerService = new OfferServiceImpl();

    @Test
    @DisplayName("Add new product to a user giving the data inside the test.")
    public void testForCreateOffer() throws ValidationFailedException {
        Product productOne = new Product("TestProduct", 22.5);
        Product productTwo = new Product("TestProductTwo", 23.5);
        List<Product> productList = new ArrayList<>();

        productList.add(productOne);
        productList.add(productTwo);
        Offer offer = new Offer("Pop Vlad", productList);

        offerService.create(offer);
    }

    @Test
    @DisplayName("Add new product to a user giving the data from an xml file.")
    public void testForCreateOfferXmlData() throws ValidationFailedException {
        int index = 0;
        Offer offer = new Offer(configuration.offerData.get(index).customer, configuration.offerData.get(index).products);
        offerService.create(offer);
        List<Offer> offers = offerService.search(configuration.offerData.get(index).customer);
        Assert.assertTrue(offers.get(0).getCustomer().equals("Adrian"));
        offerService.delete(offer);

//        offerService.search(configuration.offerData.customer);
//        offerService.create(offer);
//        offerService.findAllByProductName(configuration.offerData.products.get(0).getName());
    }


    @Test
    @DisplayName("Test find all products")
    public void testFindAll() throws ValidationFailedException {
        int index = 0;
        Offer offer = new Offer(configuration.offerData.get(0).customer, configuration.offerData.get(0).products);
        offerService.create(offer);
        List<Offer> or = offerService.findAllByProductName("Paine");
        boolean isPaine = true;
        for (Offer o : or) {
            if (o.getProducts().stream().filter(i -> i.getName().equals("Paine")).collect(Collectors.toList()).size() == 0)
                isPaine = false;
        }
        Assert.assertTrue(isPaine);
    }


    @Test
    @DisplayName("Test delete action")
    public void testDeleteAction() throws ValidationFailedException {
        int index = 0;
        Offer offer = new Offer(configuration.offerData.get(index).customer, configuration.offerData.get(index).products);
        offerService.create(offer);
        offerService.delete(offer);

        Assert.assertTrue(!offerService.offers.contains(offer));
    }


    @Test
    @DisplayName("Test the create action")
    public void testCreateAction() throws ValidationFailedException {
        int index = 1;
        Offer offer = new Offer(configuration.offerData.get(index).customer, configuration.offerData.get(index).products);
        offerService.create(offer);

        Assert.assertTrue(offerService.offers.contains(offer));
    }


    @Test
    @DisplayName("Test to create all list of elements")
    public void testCreateAll() throws ValidationFailedException {
        for (int i = 0; i < configuration.offerData.size(); i++) {
            Offer offer = new Offer(configuration.offerData.get(i).customer, configuration.offerData.get(i).products);
            offerService.create(offer);
        }
        Assert.assertTrue(configuration.offerData.size() == offerService.offers.size());
    }


    @Test
    @DisplayName("Add new product to a user giving the data from a properties file.")
    public void testForCreateOfferPropertiesData() throws ValidationFailedException {
//        read();
        offerService.create(readTestDataFromPropFile());
    }


//    @Test
//    @DisplayName("Search for a product")
//    public void testForSearchProductXml() throws ValidationFailedException {
////      offerService.search(configuration.offerData.products.get(0).getName());
//        offerService.search(configuration.offerData.get(0).customer);
//    }


}

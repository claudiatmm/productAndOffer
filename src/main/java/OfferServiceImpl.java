import exception.ValidationFailedException;
import interfaceObject.OfferService;
import objects.Offer;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class OfferServiceImpl implements OfferService {

     public List<Offer> offers = new ArrayList<>();

    @Override
    public void create(Offer offer) throws ValidationFailedException {
        if(offer.getCustomer() != null && offer.getProducts().size() >=1){
            offers.add(offer);
        System.out.println("Here is the offer object : " + offers);
        }
        else {
            throw new ValidationFailedException("the data is not correct!");
        }
    }

    @Override
    public List<Offer> search(String searchedTerm) {
        List<objects.Offer> product = offers.stream().filter(i -> i.getCustomer().contains(searchedTerm)).collect(Collectors.toList());
        System.out.println("Here is the searchTerm: " + product);

        return offers.stream().filter(i -> i.getCustomer().contains(searchedTerm)).collect(Collectors.toList());
    }

    @Override
    public boolean delete(Offer offer) throws ValidationFailedException {
        if(!offers.contains(offer)){
            throw  new ValidationFailedException("OfferNotFoundException");
        }
        return offers.remove(offer);
    }

    @Override
    public List<Offer> findAllByProductName(String product) {
//        List<objects.Offer> offersContain = new ArrayList<>();
//        for ( objects.Offer o : offers){
//            int nr = 0;
//            for(objects.Product p : o.products){
//                if (p.getName().equals(product)){
//                    nr ++;
//                }
//            }
//            if(nr >= 1){
//                offersContain.add(o);
//            }
//        }
//        return offersContain;

        List<objects.Offer> offerRR =offers.stream().filter(offer ->
                offer.getProducts().stream().filter(product1 -> product1.getName().equals(product)).collect(Collectors.toList()).size()>=1).collect(Collectors.toList());
        System.out.println("Here is the product searched: " + offerRR);

        return offers.stream().filter(offer ->
                offer.getProducts().stream().filter(product1 -> product1.getName().equals(product)).collect(Collectors.toList()).size()>=1).collect(Collectors.toList());
    }

}

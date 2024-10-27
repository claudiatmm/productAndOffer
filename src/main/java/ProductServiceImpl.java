import exception.ValidationFailedException;
import interfaceObject.AppService;
import objects.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ProductServiceImpl implements AppService<Product> {

    ProductRepository productRepository;

    public ProductServiceImpl() {
    }

    @Override
    public void create(Product product) throws ValidationFailedException {
        //verification before to save : denumire si pret valid
        if (product.getName() != null && product.getPrice() != null && product.getPrice() > 0){
            productRepository.create(product);
        }
        throw new ValidationFailedException("exceptie neverificata !!");
    }

    @Override
    public List<Product> search(String searchedTerm) {

        List<Product> products = new ArrayList<>();
        boolean p = productRepository.products.containsKey(searchedTerm);
        if (p = true){
            return productRepository.products.values().stream().filter(i -> i.getName().contains(searchedTerm)).collect(Collectors.toList());
        }
        // in cazul in care nu intra pe if - returneaza lista goala
        return products;
    }

    @Override
    public boolean delete(Product element){
        try {
            productRepository.delete(element);
        }
        catch(Exception e) {
          e.printStackTrace();
        }
        return false;
    }
}

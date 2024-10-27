import exception.ValidationFailedException;
import objects.Product;

import java.util.HashMap;
import java.util.Map;

public class ProductRepository {

   public Map<String, Product> products;

    public ProductRepository() {
        products = new HashMap<>();
    }

    public Product create(Product product){
        products.put(product.getName(),product);
        return product;
    }

    public Boolean delete(Product product) throws ValidationFailedException {
        if(products.containsKey(product.getName())){
            products.remove(product.getName());
            return true;
        }
       throw new ValidationFailedException("The product was not found !!");
    }

}

package objects;

import java.util.List;

public class Offer extends AbstractEntity {

//    0.* - insemna mai multe

    private String customer;
    List<Product> products;

    public Offer(String customer) {
        this.customer = customer;
    }

    public Offer(String customer, List<Product> products) {
        this.customer = customer;
        this.products = products;
    }

    public Offer() {

    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Double getTotalPrice(){
        Double sum =0.0;
        for(Product product : products){
            sum = sum + product.getPrice();
        }
        return sum;
    }

    @Override
    public String toString() {
        return "Offer{" +
                "customer='" + customer + '\'' +
                ", products=" + products +
                '}';
    }
}

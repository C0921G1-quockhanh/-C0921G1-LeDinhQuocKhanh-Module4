package qk.product_management.repository;

import org.springframework.stereotype.Repository;
import qk.product_management.model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProductRepository implements IProductRepository {

    private static final Map<Integer,Product> products;

    static {
        products = new HashMap<>();

        products.put(1,new Product(1,"Co Gai Ha Lan","Milk",320000));
        products.put(2,new Product(2,"Vinamilk","Milk",280000));
        products.put(3,new Product(3,"Mi Hao Hao","Noodles",110000));
        products.put(4,new Product(4,"Macbook Pro M1","Laptop",25000000));
        products.put(5,new Product(5,"Iphone 12 Pro Max","Phone",16000000));
        products.put(6,new Product(6,"Asus Vivobook","Laptop",18000000));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public void save(Product product) {
        products.put(product.getId(),product);
    }

    @Override
    public Product findByID(int id) {
        return products.get(id);
    }

    @Override
    public void update(int id, Product product) {
        products.put(id,product);
    }

    @Override
    public void remove(int id) {
        products.remove(id);
    }

    @Override
    public List<Product> searchByName(String name) {
        List<Product> productList = this.findAll();
        List<Product> searchedList = new ArrayList<>();

        for (Product product: productList) {
            if (name.equals(product.getName())) {
                searchedList.add(product);
            }
        }

        return searchedList;
    }
}

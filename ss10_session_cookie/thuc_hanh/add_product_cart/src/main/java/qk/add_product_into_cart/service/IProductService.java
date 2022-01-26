package qk.add_product_into_cart.service;

import qk.add_product_into_cart.model.Product;
import java.util.Optional;

public interface IProductService {
    
    Iterable<Product> findAll();
    Optional<Product> findByID(Long id);
}

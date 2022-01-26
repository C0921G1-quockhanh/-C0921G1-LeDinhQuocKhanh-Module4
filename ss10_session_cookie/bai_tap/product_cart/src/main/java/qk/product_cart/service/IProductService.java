package qk.product_cart.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import qk.product_cart.model.Product;

import java.util.Optional;

public interface IProductService {
    Page<Product> findAll(Pageable pageable);

    Optional<Product> findByID(Integer id);
}

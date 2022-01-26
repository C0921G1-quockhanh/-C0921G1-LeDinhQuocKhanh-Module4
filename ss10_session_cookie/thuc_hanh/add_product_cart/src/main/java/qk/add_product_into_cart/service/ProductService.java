package qk.add_product_into_cart.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import qk.add_product_into_cart.model.Product;
import qk.add_product_into_cart.repository.IProductRepository;

import java.util.Optional;

@Service
public class ProductService implements IProductService {
    
    @Autowired
    private IProductRepository iProductRepository;


    @Override
    public Iterable<Product> findAll() {
        return this.iProductRepository.findAll();
    }

    @Override
    public Optional<Product> findByID(Long id) {
        return this.iProductRepository.findById(id);
    }
}

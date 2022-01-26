package qk.product_cart.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import qk.product_cart.model.Product;
import qk.product_cart.repository.IProductRepository;

import java.util.Optional;

@Service
public class ProductService implements IProductService {

    @Autowired
    private IProductRepository iProductRepository;


    @Override
    public Page<Product> findAll(Pageable pageable) {
        return this.iProductRepository.findAll(pageable);
    }

    @Override
    public Optional<Product> findByID(Integer id) {
        return this.iProductRepository.findById(id);
    }
}

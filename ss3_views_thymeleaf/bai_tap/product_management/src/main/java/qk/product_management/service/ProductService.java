package qk.product_management.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import qk.product_management.model.Product;
import qk.product_management.repository.IProductRepository;

import java.util.List;

@Service
public class ProductService implements IProductService {

    @Autowired
    private IProductRepository iProductRepository;

    @Override
    public List<Product> findAll() {
        return this.iProductRepository.findAll();
    }

    @Override
    public void save(Product product) {
        this.iProductRepository.save(product);
    }

    @Override
    public Product findByID(int id) {
        return this.iProductRepository.findByID(id);
    }

    @Override
    public void update(int id, Product product) {
        this.iProductRepository.update(id,product);
    }

    @Override
    public void remove(int id) {
        this.iProductRepository.remove(id);
    }

    @Override
    public List<Product> searchByName(String name) {
        return this.iProductRepository.searchByName(name);
    }
}

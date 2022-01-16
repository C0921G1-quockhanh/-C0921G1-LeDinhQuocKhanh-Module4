package qk.product_management.service;

import qk.product_management.model.Product;

import java.util.List;

public interface IProductService {

    public List<Product> findAll();

    public void save(Product product);

    public Product findByID(int id);

    public void update(int id, Product product);

    public void remove(int id);

    public List<Product> searchByName(String name);
}

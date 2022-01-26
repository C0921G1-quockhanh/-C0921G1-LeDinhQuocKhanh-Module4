package qk.product_cart.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import qk.product_cart.model.Product;

@Repository
public interface IProductRepository extends PagingAndSortingRepository<Product,Integer> {
}

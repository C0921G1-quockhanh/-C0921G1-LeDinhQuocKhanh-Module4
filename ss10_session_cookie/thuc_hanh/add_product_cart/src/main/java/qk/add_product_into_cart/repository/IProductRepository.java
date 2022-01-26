package qk.add_product_into_cart.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import qk.add_product_into_cart.model.Product;

@Repository
public interface IProductRepository extends PagingAndSortingRepository<Product,Long> {
}

package qk.customer_management.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import qk.customer_management.model.Customer;
import qk.customer_management.model.Province;

@Repository
public interface ICustomerRepository extends PagingAndSortingRepository<Customer,Long> {
    Iterable<Customer> findAllByProvince(Province province);
    
    Page<Customer> findAllByFirstNameContaining(String firstName, Pageable pageable);
}

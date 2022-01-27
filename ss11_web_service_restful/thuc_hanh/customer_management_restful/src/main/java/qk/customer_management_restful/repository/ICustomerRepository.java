package qk.customer_management_restful.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import qk.customer_management_restful.model.Customer;

@Repository
public interface ICustomerRepository extends PagingAndSortingRepository<Customer,Long> {
}

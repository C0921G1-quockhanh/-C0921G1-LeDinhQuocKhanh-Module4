package qk.furama_resort.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import qk.furama_resort.model.Customer;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer,Integer> {
}

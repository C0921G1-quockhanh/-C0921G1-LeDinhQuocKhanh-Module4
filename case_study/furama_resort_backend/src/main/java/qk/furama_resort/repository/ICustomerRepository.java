package qk.furama_resort.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import qk.furama_resort.model.Customer;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer,Integer> {

    Page<Customer> findByCustomerNameContaining(String customerName, Pageable pageable);

    Page<Customer> findByAddressContaining(String address, Pageable pageable);

    Page<Customer> findByCustomerNameContainingAndAddressContaining(String customerName, String address, Pageable pageable);

}

package qk.furama_resort.service.customer;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import qk.furama_resort.model.Customer;

import java.util.Optional;

public interface ICustomerService {

    public Iterable<Customer> findAll();

    public Page<Customer> findAll(Pageable pageable);

    public Optional<Customer> findByID(Integer id);

    public Customer save(Customer customer);

    public void remove(Integer id);

    public Page<Customer> findByCustomerNameContaining(String customerName, Pageable pageable);

    public Page<Customer> findByAddressContaining(String address, Pageable pageable);

    public Page<Customer> findByCustomerNameContainingAndAddressContaining(String customerName, String address, Pageable pageable);

}

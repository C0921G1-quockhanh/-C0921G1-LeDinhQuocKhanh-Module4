package qk.furama_resort.service.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import qk.furama_resort.model.Customer;
import qk.furama_resort.repository.ICustomerRepository;

import java.util.Optional;

@Service
public class CustomerService implements ICustomerService {

    @Autowired
    private ICustomerRepository iCustomerRepository;

    @Override
    public Iterable<Customer> findAll() {
        return this.iCustomerRepository.findAll();
    }

    @Override
    public Page<Customer> findAll(Pageable pageable) {
        return this.iCustomerRepository.findAll(pageable);
    }

    @Override
    public Optional<Customer> findByID(Integer id) {
        return this.iCustomerRepository.findById(id);
    }

    @Override
    public Customer save(Customer customer) {
        return this.iCustomerRepository.save(customer);
    }

    @Override
    public void remove(Integer id) {
        this.iCustomerRepository.deleteById(id);
    }

    @Override
    public Page<Customer> findByCustomerNameContaining(String customerName, Pageable pageable) {
        return this.iCustomerRepository.findByCustomerNameContaining(customerName,pageable);
    }

    @Override
    public Page<Customer> findByAddressContaining(String address, Pageable pageable) {
        return this.iCustomerRepository.findByAddressContaining(address,pageable);
    }

    @Override
    public Page<Customer> findByCustomerNameContainingAndAddressContaining(String customerName, String address, Pageable pageable) {
        return this.iCustomerRepository.findByCustomerNameContainingAndAddressContaining(customerName,address,pageable);
    }
}

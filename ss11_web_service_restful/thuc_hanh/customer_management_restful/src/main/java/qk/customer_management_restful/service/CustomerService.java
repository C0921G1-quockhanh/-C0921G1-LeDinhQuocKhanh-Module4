package qk.customer_management_restful.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import qk.customer_management_restful.model.Customer;
import qk.customer_management_restful.repository.ICustomerRepository;

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
    public Optional<Customer> findByID(Long id) {
        return this.iCustomerRepository.findById(id);
    }

    @Override
    public Customer save(Customer customer) {
        return this.iCustomerRepository.save(customer);
    }

    @Override
    public void remove(Long id) {
        this.iCustomerRepository.deleteById(id);
    }
}

package qk.customer_management.service;

import org.springframework.beans.factory.annotation.Autowired;
import qk.customer_management.model.Customer;
import qk.customer_management.repository.ICustomerRepository;

import java.util.List;

public class CustomerService implements ICustomerService {

    @Autowired
    private ICustomerRepository iCustomerRepository;

    @Override
    public List<Customer> findAll() {
        return this.iCustomerRepository.findAll();
    }

    @Override
    public Customer findByID(Long id) {
        return this.iCustomerRepository.findByID(id);
    }

    @Override
    public void save(Customer customer) {
        this.iCustomerRepository.save(customer);
    }

    @Override
    public void remove(Long id) {
        this.iCustomerRepository.remove(id);
    }

}

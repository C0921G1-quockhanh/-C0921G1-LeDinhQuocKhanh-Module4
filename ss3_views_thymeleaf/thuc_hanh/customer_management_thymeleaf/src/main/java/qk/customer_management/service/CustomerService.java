package qk.customer_management.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import qk.customer_management.model.Customer;
import qk.customer_management.repository.ICustomerRepository;

import java.util.List;

@Service
public class CustomerService implements ICustomerService {

    @Autowired
    private ICustomerRepository iCustomerRepository;

    @Override
    public List<Customer> findAll() {
        return this.iCustomerRepository.findAll();
    }

    @Override
    public void save(Customer customer) {
        this.iCustomerRepository.save(customer);
    }

    @Override
    public Customer findByID(int id) {
        return this.iCustomerRepository.findByID(id);
    }

    @Override
    public void update(int id, Customer customer) {
        this.iCustomerRepository.update(id,customer);
    }

    @Override
    public void remove(int id) {
        this.iCustomerRepository.remove(id);
    }
}

package qk.customer_management.repository;

import qk.customer_management.model.Customer;

import java.util.List;

public interface ICustomerRepository {
    public List<Customer> findAll();

    public void save(Customer customer);

    public Customer findByID(int id);

    public void update(int id, Customer customer);

    public void remove(int id);
}

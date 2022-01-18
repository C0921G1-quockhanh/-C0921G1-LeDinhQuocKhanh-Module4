package qk.stored_procedure.service;

import org.springframework.beans.factory.annotation.Autowired;
import qk.stored_procedure.model.Customer;
import qk.stored_procedure.repository.ICustomerRepository;

public class CustomerService implements ICustomerService {
    
    @Autowired
    private ICustomerRepository iCustomerRepository;
    
    @Override
    public boolean insertWithStoredProcedure(Customer customer) {
        return this.iCustomerRepository.insertWithStoredProcedure(customer);
    }
}

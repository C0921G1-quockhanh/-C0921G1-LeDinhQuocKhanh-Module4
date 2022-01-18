package qk.stored_procedure.service;

import qk.stored_procedure.model.Customer;

public interface ICustomerService {
    public boolean insertWithStoredProcedure(Customer customer);
}

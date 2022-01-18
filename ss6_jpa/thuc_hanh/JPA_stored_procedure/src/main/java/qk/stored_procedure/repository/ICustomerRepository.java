package qk.stored_procedure.repository;

import qk.stored_procedure.model.Customer;

public interface ICustomerRepository {
    public boolean insertWithStoredProcedure(Customer customer);
}

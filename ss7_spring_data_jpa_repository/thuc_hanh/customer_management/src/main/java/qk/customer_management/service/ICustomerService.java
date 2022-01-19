package qk.customer_management.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import qk.customer_management.model.Customer;
import qk.customer_management.model.Province;

public interface ICustomerService extends IGeneralService<Customer> {
    Iterable<Customer> findAllByProvince(Province province);

    Page<Customer> findAllByFirstNameContaining(String firstName, Pageable pageable);
}

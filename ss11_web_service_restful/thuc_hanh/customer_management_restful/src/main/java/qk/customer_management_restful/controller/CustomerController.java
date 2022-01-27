package qk.customer_management_restful.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import qk.customer_management_restful.model.Customer;
import qk.customer_management_restful.service.ICustomerService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    @Autowired
    private ICustomerService iCustomerService;

    //truy van du lieu
    @GetMapping
    public ResponseEntity<Iterable<Customer>> findAllCustomers() {
        List<Customer> customers = (List<Customer>) this.iCustomerService.findAll();
        if (customers.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(customers,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> findCustomerByID(@PathVariable Long id) {
        Optional<Customer> customerOptional = this.iCustomerService.findByID(id);

        if (!customerOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(customerOptional.get(),HttpStatus.OK);
    }

    //tao moi du lieu
    @PostMapping
    public ResponseEntity<Customer> saveCustomer(@RequestBody Customer customer) {
        return new ResponseEntity<>(this.iCustomerService.save(customer),HttpStatus.CREATED);
    }

    //cap nhat du lieu
    @PutMapping("{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable Long id,@RequestBody Customer customer) {
        Optional<Customer> customerOptional = this.iCustomerService.findByID(id);

        if (!customerOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        customer.setId(customerOptional.get().getId());
        return new ResponseEntity<>(this.iCustomerService.save(customer),HttpStatus.OK);
    }

    //xoa du lieu
    @DeleteMapping("{id}")
    public ResponseEntity<Customer> deleteCustomer(@PathVariable Long id) {
        Optional<Customer> customerOptional = this.iCustomerService.findByID(id);

        if (!customerOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        this.iCustomerService.remove(id);
        return new ResponseEntity<>(customerOptional.get(), HttpStatus.OK);
    }


}

package qk.customer_management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import qk.customer_management.model.Customer;
import qk.customer_management.model.Province;
import qk.customer_management.service.ICustomerService;
import qk.customer_management.service.IProvinceService;

import java.util.List;
import java.util.Optional;

@Controller
public class CustomerController {

    @Autowired
    private ICustomerService iCustomerService;

    @Autowired
    private IProvinceService provinceService;

    @ModelAttribute("provinces")
    public Iterable<Province> provinces() {
        return provinceService.findAll();
    }

    @GetMapping(value = "/create-customer")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/customer/create");
        modelAndView.addObject("customer",new Customer());

        return modelAndView;
    }

    @PostMapping(value = "/create-customer")
    public ModelAndView saveCustomer(@ModelAttribute(name = "customer") Customer customer) {
        this.iCustomerService.save(customer);
        ModelAndView modelAndView = new ModelAndView("/customer/create");
        modelAndView.addObject("customer",new Customer());
        modelAndView.addObject("message","New customer created successfully!");

        return modelAndView;
    }
    
    @GetMapping(value = "/customers")
    public ModelAndView listCustomers(@PageableDefault(size = 1) Pageable pageable, @RequestParam(name = "search") Optional<String> key_search) {

        Page<Customer> customers;

        if (key_search.isPresent())
            customers = this.iCustomerService.findAllByFirstNameContaining(key_search.get(),pageable);
        else
            customers = this.iCustomerService.findAll(pageable);

        ModelAndView modelAndView = new ModelAndView("/customer/list");
        modelAndView.addObject("customers",customers);
        
        return modelAndView;
    }
    
    @GetMapping(value = "/edit-customer/{id}")
    public ModelAndView showEditForm(@PathVariable Long id) {
        Optional<Customer> customer = this.iCustomerService.findByID(id);

        ModelAndView modelAndView;
        if (customer.isPresent()) {
            modelAndView = new ModelAndView("/customer/edit");
            modelAndView.addObject("customer",customer.get());
        } else {
            modelAndView = new ModelAndView("/error.404");
        }
        return modelAndView;
    }

    @PostMapping(value = "/edit-customer")
    public ModelAndView updateCustomer(@ModelAttribute(name = "customer") Customer customer) {
        this.iCustomerService.save(customer);
        ModelAndView modelAndView = new ModelAndView("/customer/edit");
        modelAndView.addObject("customer",customer);
        modelAndView.addObject("message","Customer updated successfully");

        return modelAndView;
    }
    
    @GetMapping(value = "/delete-customer/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id) {
        Optional<Customer> customer = this.iCustomerService.findByID(id);

        ModelAndView modelAndView;
        if (customer.isPresent()) {
            modelAndView = new ModelAndView("/customer/delete");
            modelAndView.addObject("customer",customer.get());
        } else {
            modelAndView = new ModelAndView("/error.404");
        }
        return modelAndView;
    }
    
    @PostMapping(value = "/delete-customer")
    public String deleteCustomer(@ModelAttribute(name = "customer") Customer customer) {
        this.iCustomerService.remove(customer.getId());
        return "redirect:/customers";
    }
}

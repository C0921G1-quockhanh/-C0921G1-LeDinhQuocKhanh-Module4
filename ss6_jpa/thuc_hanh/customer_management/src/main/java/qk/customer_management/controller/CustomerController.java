package qk.customer_management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import qk.customer_management.model.Customer;
import qk.customer_management.service.ICustomerService;

import java.util.List;

@Controller
public class CustomerController {

    @Autowired
    private ICustomerService iCustomerService;

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
    public ModelAndView listCustomers() {
        List<Customer> customers = this.iCustomerService.findAll();
        ModelAndView modelAndView = new ModelAndView("/customer/list");
        modelAndView.addObject("customers",customers);
        
        return modelAndView;
    }
    
    @GetMapping(value = "/edit-customer/{id}")
    public ModelAndView showEditForm(@PathVariable Long id) {
        Customer customer = this.iCustomerService.findByID(id);

        ModelAndView modelAndView;
        if (customer != null) {
            modelAndView = new ModelAndView("/customer/edit");
            modelAndView.addObject("customer",customer);
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
        Customer customer = this.iCustomerService.findByID(id);

        ModelAndView modelAndView;
        if (customer != null) {
            modelAndView = new ModelAndView("/customer/delete");
            modelAndView.addObject("customer",customer);
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

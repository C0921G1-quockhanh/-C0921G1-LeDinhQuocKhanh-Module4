package qk.stored_procedure.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import qk.stored_procedure.model.Customer;
import qk.stored_procedure.service.ICustomerService;

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
        this.iCustomerService.insertWithStoredProcedure(customer);
        ModelAndView modelAndView = new ModelAndView("/customer/create");
        modelAndView.addObject("customer",new Customer());
        modelAndView.addObject("message","New customer created successfully!");

        return modelAndView;
    }
}

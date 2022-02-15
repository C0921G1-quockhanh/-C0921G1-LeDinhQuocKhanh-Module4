package qk.customer_management_i18N.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import qk.customer_management_i18N.model.Customer;

@Controller
@RequestMapping("/customers")
public class CustomerController {

    @GetMapping("")
    public String getAllCustomers() {
        return "list";
    }

    @GetMapping("/create")
    public String addNewCustomer(Model model) {
        Customer customer = new Customer();
        model.addAttribute("customer",customer);
        return "create";
    }

}

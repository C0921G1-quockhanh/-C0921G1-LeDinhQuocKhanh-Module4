package qk.customer_management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import qk.customer_management.model.Customer;
import qk.customer_management.service.ICustomerService;

import java.util.List;

@Controller
@RequestMapping(value = "/customer")
public class CustomerController {
    
    @Autowired
    private ICustomerService iCustomerService;
    
    @GetMapping(value = "")
    public String index(Model model) {
        List<Customer> customers = this.iCustomerService.findAll();
        model.addAttribute("customers",customers);
        
        return "index";
    }
    
    @GetMapping(value = "/create")
    public String create(Model model) {
        model.addAttribute("customer",new Customer());
        return "create";
    }

    @PostMapping(value = "/save")
    public String save(Customer customer, RedirectAttributes redirectAttributes) {
        customer.setId((int)(Math.random()*10000));
        this.iCustomerService.save(customer);
        redirectAttributes.addFlashAttribute("success","Add new customer successfully!");

        return "redirect:/customer";
    }

    @GetMapping(value = "/{id}/edit")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("customer",this.iCustomerService.findByID(id));
        return "edit";
    }
    
    @PostMapping(value = "/update")
    public String update(Customer customer) {
        this.iCustomerService.update(customer.getId(),customer);
        return "redirect:/customer";
    }
    
    @GetMapping(value = "{id}/delete")
    public String delete(@PathVariable int id, Model model) {
        model.addAttribute("customer",this.iCustomerService.findByID(id));
        return "delete";
    }

    @PostMapping(value = "/delete")
    public String delete(Customer customer, RedirectAttributes redirectAttributes) {
        this.iCustomerService.remove(customer.getId());
        redirectAttributes.addFlashAttribute("success","Removed customer successfully!");

        return "redirect:/customer";
    }

    @GetMapping(value = "/{id}/view")
    public String view(@PathVariable int id, Model model) {
        model.addAttribute("customer",this.iCustomerService.findByID(id));
        return "view";
    }
}

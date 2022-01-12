package cg.wbd.grandemonstration.Controller;

import cg.wbd.grandemonstration.model.Customer;
import cg.wbd.grandemonstration.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class InfoController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/info")
    public String showInfo(@RequestParam long id, Model model) {
        Customer customer = customerService.findOne(id);
        model.addAttribute("customer",customer);
        return "info";
    }
}

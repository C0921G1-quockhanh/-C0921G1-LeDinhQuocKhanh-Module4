package qk.money_exchange.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MoneyExchangeController {
    
    @GetMapping("/exchange")
    public String showInputForm() {
        return "input";
    }

    @PostMapping("/exchange")
    public String calculateVND(@RequestParam double USD, @RequestParam double ratio, Model model) {
        double VND = USD * ratio;
        
        model.addAttribute("USD",USD);
        model.addAttribute("ratio",ratio);
        model.addAttribute("VND",VND);
        return "result";
    }
    
}

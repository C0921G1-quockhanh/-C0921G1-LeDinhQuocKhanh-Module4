package qk.store_email.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import qk.store_email.model.Email;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class StoreEmailController {
    
    @GetMapping(value = "/home")
    public String settingHome(Model model) {
        List<String> languageList = new ArrayList<>();
        languageList.add("English");
        languageList.add("Vietnamese");
        languageList.add("Japanese");
        languageList.add("Chinese");

        model.addAttribute("languageList",languageList);
        
        List<Integer> sizes = new ArrayList<>();
        sizes.add(5);
        sizes.add(10);
        sizes.add(15);
        sizes.add(25);
        sizes.add(50);
        sizes.add(100);
        
        model.addAttribute("sizes",sizes);
        
        Email email = new Email(new String[]{"English"}, new Integer[] {25},false,"Thor King, Asgard");
        model.addAttribute("email",email);

        return "home";
    }

    @PostMapping(value = "/update")
    public String updateEmail(@ModelAttribute(name = "email") Email email, Model model, @RequestParam(name = "confirm") String confirm) {
        
        if (confirm.equals("Update")) {
            List<String> languageList = new ArrayList<>();
            languageList.add("English");
            languageList.add("Vietnamese");
            languageList.add("Japanese");
            languageList.add("Chinese");

            model.addAttribute("languageList",languageList);

            List<Integer> sizes = new ArrayList<>();
            sizes.add(5);
            sizes.add(10);
            sizes.add(15);
            sizes.add(25);
            sizes.add(50);
            sizes.add(100);

            model.addAttribute("sizes",sizes);

            model.addAttribute("email",email);

            model.addAttribute("msgUpdate","Updated Successfully");
            
            return "update";
        }
        
        if (confirm.equals("Cancel")) {
            model.addAttribute("msgError","Updated Unsuccessfully");
            return "error";
        }
        
        return "";
    }
}

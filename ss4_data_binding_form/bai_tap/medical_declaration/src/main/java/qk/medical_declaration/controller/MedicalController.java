package qk.medical_declaration.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import qk.medical_declaration.model.MedicalDeclaration;

@Controller
public class MedicalController {

    @GetMapping(value = "/home")
    public String medicalHome(Model model) {
        MedicalDeclaration medicalDeclaration = new MedicalDeclaration();
        model.addAttribute("medicalDeclaration",medicalDeclaration);





        return "home";
    }
}

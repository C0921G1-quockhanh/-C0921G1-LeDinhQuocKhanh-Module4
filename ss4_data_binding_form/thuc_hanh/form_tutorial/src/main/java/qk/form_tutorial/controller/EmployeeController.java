package qk.form_tutorial.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import qk.form_tutorial.model.Employee;

@Controller
@RequestMapping(value = "/employee")
public class EmployeeController {

    @GetMapping(value = "/showForm")
    public String showForm(ModelMap modelMap) {
        modelMap.addAttribute("employee",new Employee());
        return "employee/create";
    }

    @PostMapping(value = "/addEmployee")
    public String submit(@ModelAttribute(name = "employee") Employee employee, ModelMap modelMap) {
        modelMap.addAttribute("id",employee.getId());
        modelMap.addAttribute("name",employee.getName());
        modelMap.addAttribute("contactNumber",employee.getContactNumber());

        return "employee/info";
    }
}

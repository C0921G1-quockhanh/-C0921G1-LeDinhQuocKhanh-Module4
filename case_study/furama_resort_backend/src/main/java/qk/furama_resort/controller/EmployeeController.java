package qk.furama_resort.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import qk.furama_resort.model.*;
import qk.furama_resort.repository.*;
import qk.furama_resort.service.employee.IEmployeeService;

@Controller
@RequestMapping(value = "/employee")
public class EmployeeController {

    @Autowired
    private IEmployeeService iEmployeeService;

    @Autowired
    private IPositionRepository iPositionRepository;

    @ModelAttribute("positions")
    public Iterable<Position> positions() {
        return this.iPositionRepository.findAll();
    }

    @Autowired
    private IQualificationRepository iQualificationRepository;

    @ModelAttribute("qualifications")
    public Iterable<Qualification> qualifications() {
        return this.iQualificationRepository.findAll();
    }

    @Autowired
    private IDepartmentRepository iDepartmentRepository;

    @ModelAttribute("departments")
    public Iterable<Department> departments() {
        return this.iDepartmentRepository.findAll();
    }

    @Autowired
    private IUserRepository iUserRepository;

    @ModelAttribute("users")
    public Iterable<User> users() {
        return this.iUserRepository.findAll();
    }

    @GetMapping(value = "")
    public String getAllEmployees(Model model, @PageableDefault(size = 4)Pageable pageable) {
        Page<Employee> employees = this.iEmployeeService.findAll(pageable);
        model.addAttribute("employees",employees);
        return "/employee/list";
    }

    @GetMapping(value = "/create")
    public String addForm(Model model) {
        model.addAttribute("employee",new Employee());
        return "/employee/create";
    }

}

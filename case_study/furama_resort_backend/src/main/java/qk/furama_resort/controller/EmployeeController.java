package qk.furama_resort.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import qk.furama_resort.Dto.EmployeeDto;
import qk.furama_resort.model.*;
import qk.furama_resort.repository.*;
import qk.furama_resort.service.employee.IEmployeeService;

import java.util.Optional;

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
        model.addAttribute("employee", new EmployeeDto());
        return "/employee/create";
    }

    @PostMapping(value = "/save")
    public String saveEmployee(@Validated @ModelAttribute(name = "employee") EmployeeDto employeeDto, BindingResult bindingResult) {
        //dua phuong thuc validate vao controller
        new EmployeeDto().validate(employeeDto,bindingResult);

        if (bindingResult.hasFieldErrors())
            return "/employee/create";
        else {
            Employee employee = new Employee();
            BeanUtils.copyProperties(employeeDto,employee);
            this.iEmployeeService.save(employee);
            return "redirect:/employee/";
        }
    }

    @GetMapping("/{id}/edit")
    public String editForm(@PathVariable Integer id, Model model) {
        Optional<Employee> employeeOptional = this.iEmployeeService.findByID(id);

        if (employeeOptional.isPresent()) {
            model.addAttribute("employee",employeeOptional.get());
            return "/employee/edit";
        } else {
            return "error.404";
        }
    }

    @PostMapping(value = "/update")
    public String editEmployee(@ModelAttribute(name = "employee") Employee employee) {
        this.iEmployeeService.save(employee);
        return "redirect:/employee/";
    }

    @GetMapping(value = "/{id}/delete")
    public String deleteForm(@PathVariable Integer id, Model model) {
        Optional<Employee> employeeOptional = this.iEmployeeService.findByID(id);

        if (employeeOptional.isPresent()) {
            model.addAttribute("employee",employeeOptional.get());
            return "/employee/delete";
        } else {
            return "error.404";
        }
    }

    @PostMapping(value = "/delete")
    public String deleteEmployee(@ModelAttribute(name = "employee") Employee employee) {
        this.iEmployeeService.remove(employee.getEmployeeID());
        return "redirect:/employee/";
    }

}

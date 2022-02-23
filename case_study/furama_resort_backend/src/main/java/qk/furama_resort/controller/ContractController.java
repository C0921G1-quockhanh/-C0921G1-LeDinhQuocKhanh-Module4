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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import qk.furama_resort.Dto.ContractDto;
import qk.furama_resort.model.Contract;
import qk.furama_resort.model.Customer;
import qk.furama_resort.model.Employee;
import qk.furama_resort.model.Service;
import qk.furama_resort.repository.IEmployeeRepository;
import qk.furama_resort.service.contract.IContractService;
import qk.furama_resort.service.customer.ICustomerService;
import qk.furama_resort.service.employee.IEmployeeService;
import qk.furama_resort.service.service.IService;

@Controller
@RequestMapping(value = "/contract")
public class ContractController {

    @Autowired
    private IContractService iContractService;

    @Autowired
    private IEmployeeService iEmployeeService;

    @ModelAttribute("employees")
    public Iterable<Employee> employees() {
        return this.iEmployeeService.findAll();
    }

    @Autowired
    private ICustomerService iCustomerService;

    @ModelAttribute("customers")
    public Iterable<Customer> customers() {
        return this.iCustomerService.findAll();
    }

    @Autowired
    private IService iService;

    @ModelAttribute("services")
    public Iterable<Service> services() {
        return this.iService.findAll();
    }

    @GetMapping(value = "")
    public String getAllContracts(Model model, @PageableDefault(size = 4)Pageable pageable) {
        Page<Contract> contracts = this.iContractService.findAll(pageable);
        model.addAttribute("contracts",contracts);
        return "/contract/list";
    }

    @GetMapping(value = "/create")
    public String addForm(Model model) {
        model.addAttribute("contract", new ContractDto());
        return "/contract/create";
    }

    @PostMapping(value = "/save")
    public String saveContract(@Validated @ModelAttribute(name = "contract") ContractDto contractDto, BindingResult bindingResult) {
        //phuong thuc validate
        new ContractDto().validate(contractDto,bindingResult);

        if (bindingResult.hasFieldErrors())
            return "/contract/create";
        else {
            Contract contract = new Contract();
            BeanUtils.copyProperties(contractDto,contract);
            this.iContractService.save(contract);
            return "redirect:/contract/";
        }
    }

}

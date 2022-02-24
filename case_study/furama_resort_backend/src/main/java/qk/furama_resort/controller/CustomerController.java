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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import qk.furama_resort.Dto.CustomerDto;
import qk.furama_resort.model.*;
import qk.furama_resort.repository.ICustomerTypeRepository;
import qk.furama_resort.repository.IDepartmentRepository;
import qk.furama_resort.repository.IPositionRepository;
import qk.furama_resort.repository.IQualificationRepository;
import qk.furama_resort.service.customer.ICustomerService;

import java.util.Optional;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private ICustomerService iCustomerService;

    @Autowired
    private ICustomerTypeRepository iCustomerTypeRepository;

    @ModelAttribute("customerTypes")
    public Iterable<CustomerType> customerTypes() {
        return this.iCustomerTypeRepository.findAll();
    }

    @GetMapping(value = "")
    public String getAllCustomers(Model model, @PageableDefault(size = 4) Pageable pageable,
                                  @RequestParam(name = "customerName") Optional<String> customerName,
                                  @RequestParam(name = "address") Optional<String> address) {

        boolean nameNotNull = customerName.isPresent() && !customerName.get().equals("");
        boolean addressNotNull = address.isPresent() && !address.get().equals("");

        if (nameNotNull)
            model.addAttribute("customerName",customerName.get());

        if (addressNotNull)
            model.addAttribute("address",address.get());

        Page<Customer> customers = null;

        if (!nameNotNull && !addressNotNull)
            customers = this.iCustomerService.findAll(pageable);

        if (nameNotNull && !addressNotNull)
            customers = this.iCustomerService.findByCustomerNameContaining(customerName.get(),pageable);

        if (!nameNotNull && addressNotNull)
            customers = this.iCustomerService.findByAddressContaining(address.get(),pageable);

        if (nameNotNull && addressNotNull)
            customers = this.iCustomerService.findByCustomerNameContainingAndAddressContaining(customerName.get(),address.get(),pageable);

        model.addAttribute("customers",customers);

        return "/customer/list";
    }

    @GetMapping(value = "/create")
    public String addForm(Model model) {
        model.addAttribute("customer", new CustomerDto());
        return "/customer/create";
    }

    @PostMapping(value = "/save")
    public String saveCustomer(@Validated @ModelAttribute(name = "customer") CustomerDto customerDto, BindingResult bindingResult) {
        //dua phuong thuc validate vao controller
        new CustomerDto().validate(customerDto,bindingResult);

        if (bindingResult.hasFieldErrors())
            return "/customer/create";
        else {
            Customer customer = new Customer();
            BeanUtils.copyProperties(customerDto,customer);
            this.iCustomerService.save(customer);
            return "redirect:/customer/";
        }
    }

    @GetMapping(value = "/{id}/edit")
    public String editForm(@PathVariable Integer id, Model model) {
        Optional<Customer> customerOptional = this.iCustomerService.findByID(id);

        if (customerOptional.isPresent()) {
            model.addAttribute("customer",customerOptional.get());
            return "/customer/edit";
        } else {
            return "error.404";
        }
    }

    @PostMapping(value = "/update")
    public String editCustomer(@ModelAttribute(name = "customer") Customer customer) {
        this.iCustomerService.save(customer);
        return "redirect:/customer/";
    }

    @GetMapping(value = "/{id}/delete")
    public String deleteForm(@PathVariable Integer id, Model model) {
        Optional<Customer> customerOptional = this.iCustomerService.findByID(id);

        if (customerOptional.isPresent()) {
            model.addAttribute("customer",customerOptional.get());
            return "/customer/delete";
        } else {
            return "error.404";
        }
    }

    @PostMapping(value = "/delete")
    public String deleteCustomer(@ModelAttribute(name = "customer") Customer customer) {
        this.iCustomerService.remove(customer.getCustomerID());
        return "redirect:/customer/";
    }


}

package qk.furama_resort.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import qk.furama_resort.model.RentalType;
import qk.furama_resort.model.Service;
import qk.furama_resort.model.ServiceType;
import qk.furama_resort.repository.IRentalTypeRepository;
import qk.furama_resort.repository.IServiceTypeRepository;
import qk.furama_resort.service.service.IService;

@Controller
@RequestMapping(value = "/service")
public class ServiceController {

    @Autowired
    private IService iService;

    @Autowired
    private IServiceTypeRepository iServiceTypeRepository;

    @ModelAttribute("serviceTypes")
    public Iterable<ServiceType> serviceTypes() {
        return this.iServiceTypeRepository.findAll();
    }

    @Autowired
    private IRentalTypeRepository iRentalTypeRepository;

    @ModelAttribute("rentalTypes")
    public Iterable<RentalType> rentalTypes() {
        return this.iRentalTypeRepository.findAll();
    }

    @GetMapping(value = "")
    public String getAllServices(Model model, @PageableDefault(size = 4)Pageable pageable) {
        Page<Service> services = this.iService.findAll(pageable);
        model.addAttribute("services",services);
        return "/service/list";
    }

    @GetMapping(value = "/create")
    public String addForm(Model model) {
        model.addAttribute("service", new Service());
        return "/service/create";
    }

    @PostMapping(value = "/save")
    public String saveService(@ModelAttribute(name = "service") Service service) {
        this.iService.save(service);
        return "redirect:/service/";
    }

}

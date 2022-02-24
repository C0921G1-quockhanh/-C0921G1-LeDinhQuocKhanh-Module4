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
import qk.furama_resort.Dto.ServiceDto;
import qk.furama_resort.model.RentalType;
import qk.furama_resort.model.Service;
import qk.furama_resort.model.ServiceType;
import qk.furama_resort.repository.IRentalTypeRepository;
import qk.furama_resort.repository.IServiceTypeRepository;
import qk.furama_resort.service.service.IService;

import java.util.Optional;

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
    public String getAllServices(Model model, @PageableDefault(size = 4)Pageable pageable,
                                 @RequestParam(name = "serviceName")Optional<String> serviceName,
                                 @RequestParam(name = "serviceTypeID") Optional<Integer> serviceTypeID) {

        boolean nameNotNull = serviceName.isPresent() && !serviceName.get().equals("");
        boolean idNotNull = serviceTypeID.isPresent();

        if (nameNotNull)
            model.addAttribute("serviceName",serviceName.get());

        if (idNotNull)
            model.addAttribute("serviceTypeID",serviceTypeID.get());

        Page<Service> services = null;

        if (!nameNotNull && !idNotNull)
            services = this.iService.findAll(pageable);

        if (nameNotNull && !idNotNull)
            services = this.iService.findByServiceNameContaining(serviceName.get(),pageable);

        if (!nameNotNull && idNotNull)
            services = this.iService.findByServiceType_ServiceTypeID(serviceTypeID.get(),pageable);

        if (nameNotNull && idNotNull)
            services = this.iService.findByServiceNameContainingAndServiceType_ServiceTypeID(serviceName.get(),serviceTypeID.get(),pageable);

        model.addAttribute("services",services);
        return "/service/list";
    }

    @GetMapping(value = "/create")
    public String addForm(Model model) {
        model.addAttribute("service", new ServiceDto());
        return "/service/create";
    }

    @PostMapping(value = "/save")
    public String saveService(@Validated @ModelAttribute(name = "service") ServiceDto serviceDto, BindingResult bindingResult) {
        //phuong thuc validate
        new ServiceDto().validate(serviceDto,bindingResult);

        if (bindingResult.hasFieldErrors())
            return "/service/create";
        else {
            Service service = new Service();
            BeanUtils.copyProperties(serviceDto,service);
            this.iService.save(service);
            return "redirect:/service/";
        }
    }

}

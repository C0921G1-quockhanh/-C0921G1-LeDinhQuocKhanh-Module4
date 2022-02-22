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
import qk.furama_resort.model.AccompaniedService;
import qk.furama_resort.model.Contract;
import qk.furama_resort.model.DetailContract;
import qk.furama_resort.repository.IAccompaniedServiceRepository;
import qk.furama_resort.service.contract.IContractService;
import qk.furama_resort.service.detail_contract.IDetailContractService;

@Controller
@RequestMapping(value = "/detail-contract")
public class DetailContractController {

    @Autowired
    private IDetailContractService iDetailContractService;

    @Autowired
    private IContractService iContractService;

    @ModelAttribute("contracts")
    public Iterable<Contract> contracts() {
        return this.iContractService.findAll();
    }

    @Autowired
    private IAccompaniedServiceRepository iAccompaniedServiceRepository;

    @ModelAttribute("accompaniedServices")
    public Iterable<AccompaniedService> accompaniedServices() {
        return this.iAccompaniedServiceRepository.findAll();
    }

    @GetMapping(value = "/create")
    public String addForm(Model model) {
        model.addAttribute("detailContract", new DetailContract());
        return "/detail_contract/create";
    }

    @PostMapping(value = "/save")
    public String saveDetailContract(@ModelAttribute(name = "detailContract") DetailContract detailContract) {
        this.iDetailContractService.save(detailContract);
        return "redirect:/contract/";
    }


}

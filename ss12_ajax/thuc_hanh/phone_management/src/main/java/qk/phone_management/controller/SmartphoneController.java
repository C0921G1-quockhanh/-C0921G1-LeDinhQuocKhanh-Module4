package qk.phone_management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import qk.phone_management.model.SmartPhone;
import qk.phone_management.service.ISmartphoneService;

import java.util.Optional;

@RestController
@RequestMapping(value = "/smartphones")
public class SmartphoneController {

    @Autowired
    private ISmartphoneService iSmartphoneService;

    @PostMapping
    public ResponseEntity<SmartPhone> createSmartphone(@RequestBody SmartPhone smartPhone) {
        return new ResponseEntity<>(this.iSmartphoneService.save(smartPhone), HttpStatus.CREATED);
    }

    @GetMapping(value = "/list")
    public ModelAndView getAllSmartPhonePage() {
        ModelAndView modelAndView = new ModelAndView("phones/list");
        modelAndView.addObject("smartphones",this.iSmartphoneService.findAll());
        return modelAndView;
    }

    @GetMapping
    public ResponseEntity<Iterable<SmartPhone>> allPhones() {
        return new ResponseEntity<>(this.iSmartphoneService.findAll(),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<SmartPhone> deleteSmartphone(@PathVariable Long id) {
        Optional<SmartPhone> smartPhoneOptional = this.iSmartphoneService.findByID(id);
        if (!smartPhoneOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        this.iSmartphoneService.remove(id);
        return new ResponseEntity<>(smartPhoneOptional.get(),HttpStatus.NO_CONTENT);
    }
}

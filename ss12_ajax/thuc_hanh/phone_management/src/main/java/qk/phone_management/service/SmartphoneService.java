package qk.phone_management.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import qk.phone_management.model.SmartPhone;
import qk.phone_management.repository.ISmartPhoneRepository;

import java.util.Optional;

@Service
public class SmartphoneService implements ISmartphoneService {

    @Autowired
    private ISmartPhoneRepository iSmartPhoneRepository;

    @Override
    public Iterable<SmartPhone> findAll() {
        return this.iSmartPhoneRepository.findAll();
    }

    @Override
    public Optional<SmartPhone> findByID(Long id) {
        return this.iSmartPhoneRepository.findById(id);
    }

    @Override
    public SmartPhone save(SmartPhone smartPhone) {
        return this.iSmartPhoneRepository.save(smartPhone);
    }

    @Override
    public void remove(Long id) {
        this.iSmartPhoneRepository.deleteById(id);
    }
}

package qk.phone_management.service;

import qk.phone_management.model.SmartPhone;

import java.util.Optional;

public interface ISmartphoneService {
    
    Iterable<SmartPhone> findAll();
    
    Optional<SmartPhone> findByID(Long id);
    
    SmartPhone save(SmartPhone smartPhone);
    
    void remove(Long id);
    
}

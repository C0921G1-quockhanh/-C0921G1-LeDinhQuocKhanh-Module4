package qk.furama_resort.service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import qk.furama_resort.repository.IServiceRepository;

import java.util.Optional;

@Service
public class CService implements IService {

    @Autowired
    private IServiceRepository iServiceRepository;

    @Override
    public Iterable<qk.furama_resort.model.Service> findAll() {
        return this.iServiceRepository.findAll();
    }

    @Override
    public Page<qk.furama_resort.model.Service> findAll(Pageable pageable) {
        return this.iServiceRepository.findAll(pageable);
    }

    @Override
    public Optional<qk.furama_resort.model.Service> findByID(Integer id) {
        return this.iServiceRepository.findById(id);
    }

    @Override
    public qk.furama_resort.model.Service save(qk.furama_resort.model.Service service) {
        return this.iServiceRepository.save(service);
    }

    @Override
    public void remove(Integer id) {
        this.iServiceRepository.deleteById(id);
    }

    @Override
    public Page<qk.furama_resort.model.Service> findByServiceNameContaining(String serviceName, Pageable pageable) {
        return this.iServiceRepository.findByServiceNameContaining(serviceName, pageable);
    }

    @Override
    public Page<qk.furama_resort.model.Service> findByServiceType_ServiceTypeID(Integer serviceTypeID, Pageable pageable) {
        return this.iServiceRepository.findByServiceType_ServiceTypeID(serviceTypeID, pageable);
    }

    @Override
    public Page<qk.furama_resort.model.Service> findByServiceNameContainingAndServiceType_ServiceTypeID(String serviceName, Integer serviceTypeID, Pageable pageable) {
        return this.iServiceRepository.findByServiceNameContainingAndServiceType_ServiceTypeID(serviceName, serviceTypeID, pageable);
    }
}

package qk.customer_management.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import qk.customer_management.model.Province;
import qk.customer_management.repository.IProvinceRepository;

import java.util.Optional;

@Service
public class ProvinceService implements IProvinceService {

    @Autowired
    private IProvinceRepository iProvinceRepository;


    @Override
    public Iterable<Province> findAll() {
        return this.iProvinceRepository.findAll();
    }

    @Override
    public Page<Province> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public Optional<Province> findByID(Long id) {
        return this.iProvinceRepository.findById(id);
    }

    @Override
    public void save(Province province) {
        this.iProvinceRepository.save(province);
    }

    @Override
    public void remove(Long id) {
        this.iProvinceRepository.deleteById(id);
    }
}

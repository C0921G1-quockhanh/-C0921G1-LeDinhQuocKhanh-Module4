package qk.furama_resort.service.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import qk.furama_resort.model.Service;

import java.util.Optional;

public interface IService {

    public Page<Service> findAll(Pageable pageable);

    public Optional<Service> findByID(Integer id);

    public Service save(Service service);

    public void remove(Integer id);

}

package qk.customer_management.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IGeneralService<T> {

    public Iterable<T> findAll();

    public Page<T> findAll(Pageable pageable);

    public Optional<T> findByID(Long id);

    public void save(T t);

    public void remove(Long id);
    
}

package qk.customer_management.service;

import java.util.List;

public interface IGeneralService<T> {
    
    public List<T> findAll();

    public T findByID(Long id);

    public void save(T t);

    public void remove(Long id);
    
}

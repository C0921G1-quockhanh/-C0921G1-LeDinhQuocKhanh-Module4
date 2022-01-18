package qk.customer_management.repository;

import java.util.List;

public interface IGeneralRepository<T> {

    public List<T> findAll();

    public T findByID(Long id);

    public void save(T t);

    public void remove(Long id);

}

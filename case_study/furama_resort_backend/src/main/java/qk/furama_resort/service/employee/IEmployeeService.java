package qk.furama_resort.service.employee;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import qk.furama_resort.model.Employee;

import java.util.Optional;

public interface IEmployeeService {

    public Page<Employee> findAll(Pageable pageable);

    public Optional<Employee> findByID(Integer id);

    public Employee save(Employee employee);

    public void remove(Integer id);

}

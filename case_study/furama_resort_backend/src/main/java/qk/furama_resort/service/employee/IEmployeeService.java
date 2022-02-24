package qk.furama_resort.service.employee;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import qk.furama_resort.model.Employee;

import java.util.Optional;

public interface IEmployeeService {

    public Iterable<Employee> findAll();

    public Page<Employee> findAll(Pageable pageable);

    public Optional<Employee> findByID(Integer id);

    public Employee save(Employee employee);

    public void remove(Integer id);

    Page<Employee> findByEmployeeNameContaining(String employeeName, Pageable pageable);

    Page<Employee> findByPosition_PositionID(Integer positionID, Pageable pageable);

    Page<Employee> findByEmployeeNameContainingAndPosition_PositionID(String employeeName, Integer positionID, Pageable pageable);

}

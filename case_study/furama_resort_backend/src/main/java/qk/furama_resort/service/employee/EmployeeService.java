package qk.furama_resort.service.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import qk.furama_resort.model.Employee;
import qk.furama_resort.repository.IEmployeeRepository;

import java.util.Optional;

@Service
public class EmployeeService implements IEmployeeService {

    @Autowired
    private IEmployeeRepository iEmployeeRepository;

    @Override
    public Page<Employee> findAll(Pageable pageable) {
        return this.iEmployeeRepository.findAll(pageable);
    }

    @Override
    public Optional<Employee> findByID(Integer id) {
        return this.iEmployeeRepository.findById(id);
    }

    @Override
    public Employee save(Employee employee) {
        return this.iEmployeeRepository.save(employee);
    }

    @Override
    public void remove(Integer id) {
        this.iEmployeeRepository.deleteById(id);
    }
}

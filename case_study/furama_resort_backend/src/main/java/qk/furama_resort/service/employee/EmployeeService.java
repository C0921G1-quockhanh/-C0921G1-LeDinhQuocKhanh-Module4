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
    public Iterable<Employee> findAll() {
        return this.iEmployeeRepository.findAll();
    }

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

    @Override
    public Page<Employee> findByEmployeeNameContaining(String employeeName, Pageable pageable) {
        return this.iEmployeeRepository.findByEmployeeNameContaining(employeeName,pageable);
    }

    @Override
    public Page<Employee> findByPosition_PositionID(Integer positionID, Pageable pageable) {
        return this.iEmployeeRepository.findByPosition_PositionID(positionID, pageable);
    }

    @Override
    public Page<Employee> findByEmployeeNameContainingAndPosition_PositionID(String employeeName, Integer positionID, Pageable pageable) {
        return this.iEmployeeRepository.findByEmployeeNameContainingAndPosition_PositionID(employeeName, positionID, pageable);
    }
}

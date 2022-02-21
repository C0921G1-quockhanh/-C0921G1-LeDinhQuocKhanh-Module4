package qk.furama_resort.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import qk.furama_resort.model.Employee;

@Repository
public interface IEmployeeRepository extends JpaRepository<Employee,Integer> {
}

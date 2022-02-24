package qk.furama_resort.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import qk.furama_resort.model.Employee;

@Repository
public interface IEmployeeRepository extends JpaRepository<Employee,Integer> {

    Page<Employee> findByEmployeeNameContaining(String employeeName, Pageable pageable);

    Page<Employee> findByPosition_PositionID(Integer positionID, Pageable pageable);

    Page<Employee> findByEmployeeNameContainingAndPosition_PositionID(String employeeName, Integer positionID, Pageable pageable);

}

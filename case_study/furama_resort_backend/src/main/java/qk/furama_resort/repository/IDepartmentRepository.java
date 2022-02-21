package qk.furama_resort.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import qk.furama_resort.model.Department;

@Repository
public interface IDepartmentRepository extends JpaRepository<Department,Integer> {
}

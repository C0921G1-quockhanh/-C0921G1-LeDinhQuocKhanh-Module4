package qk.final_exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import qk.final_exam.model.ServiceType;

@Repository
public interface IServiceTypeRepository extends JpaRepository<ServiceType,Integer> {
}

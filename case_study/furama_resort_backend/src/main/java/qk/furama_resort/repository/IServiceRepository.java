package qk.furama_resort.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import qk.furama_resort.model.Service;

@Repository
public interface IServiceRepository extends JpaRepository<Service,Integer> {
}

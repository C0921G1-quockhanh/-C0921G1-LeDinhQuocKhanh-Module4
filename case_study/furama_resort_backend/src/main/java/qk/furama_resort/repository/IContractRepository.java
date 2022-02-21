package qk.furama_resort.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import qk.furama_resort.model.Contract;

@Repository
public interface IContractRepository extends JpaRepository<Contract,Integer> {
}

package qk.final_exam.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import qk.final_exam.model.Contract;

@Repository
public interface IContractRepository extends JpaRepository<Contract,Integer> {

    Page<Contract> findByCustomer_CustomerName(String customerName, Pageable pageable);

    Page<Contract> findByServiceType_ServiceTypeId(Integer serviceTypeId, Pageable pageable);

    Page<Contract> findByCustomer_CustomerNameAndServiceType_ServiceTypeId(String customerName, Integer serviceTypeId, Pageable pageable);

}

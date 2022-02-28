package qk.final_exam.service.contract;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import qk.final_exam.model.Contract;

import java.util.Optional;

public interface IContractService {

    public Page<Contract> findAll(Pageable pageable);

    public Optional<Contract> findById(Integer id);

    public Contract save(Contract contract);

    public void remove(Integer id);

    Page<Contract> findByCustomer_CustomerName(String customerName, Pageable pageable);

    Page<Contract> findByServiceType_ServiceTypeId(Integer serviceTypeId, Pageable pageable);

    Page<Contract> findByCustomer_CustomerNameAndServiceType_ServiceTypeId(String customerName, Integer serviceTypeId, Pageable pageable);

}

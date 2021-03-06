package qk.final_exam.service.contract;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import qk.final_exam.model.Contract;
import qk.final_exam.repository.IContractRepository;

import java.util.Optional;

@Service
public class ContractService implements IContractService {

    @Autowired
    private IContractRepository iContractRepository;

    @Override
    public Page<Contract> findAll(Pageable pageable) {
        return this.iContractRepository.findAll(pageable);
    }

    @Override
    public Optional<Contract> findById(Integer id) {
        return this.iContractRepository.findById(id);
    }

    @Override
    public Contract save(Contract contract) {
        return this.iContractRepository.save(contract);
    }

    @Override
    public void remove(Integer id) {
        this.iContractRepository.deleteById(id);
    }

    @Override
    public Page<Contract> findByCustomer_CustomerName(String customerName, Pageable pageable) {
        return this.iContractRepository.findByCustomer_CustomerName(customerName, pageable);
    }

    @Override
    public Page<Contract> findByServiceType_ServiceTypeId(Integer serviceTypeId, Pageable pageable) {
        return this.iContractRepository.findByServiceType_ServiceTypeId(serviceTypeId, pageable);
    }

    @Override
    public Page<Contract> findByCustomer_CustomerNameAndServiceType_ServiceTypeId(String customerName, Integer serviceTypeId, Pageable pageable) {
        return this.iContractRepository.findByCustomer_CustomerNameAndServiceType_ServiceTypeId(customerName, serviceTypeId, pageable);
    }
}

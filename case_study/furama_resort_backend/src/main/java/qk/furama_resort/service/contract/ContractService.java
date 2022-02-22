package qk.furama_resort.service.contract;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import qk.furama_resort.model.Contract;
import qk.furama_resort.repository.IContractRepository;

import java.util.Optional;

@Service
public class ContractService implements IContractService {

    @Autowired
    private IContractRepository iContractRepository;

    @Override
    public Iterable<Contract> findAll() {
        return this.iContractRepository.findAll();
    }

    @Override
    public Page<Contract> findAll(Pageable pageable) {
        return this.iContractRepository.findAll(pageable);
    }

    @Override
    public Optional<Contract> findByID(Integer id) {
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
}

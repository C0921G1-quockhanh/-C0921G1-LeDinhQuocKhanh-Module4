package qk.furama_resort.service.contract;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import qk.furama_resort.model.Contract;

import java.util.Optional;

public interface IContractService {

    public Page<Contract> findAll(Pageable pageable);

    public Optional<Contract> findByID(Integer id);

    public Contract save(Contract contract);

    public void remove(Integer id);

}

package qk.furama_resort.service.detail_contract;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import qk.furama_resort.model.DetailContract;

import java.util.Optional;

public interface IDetailContractService {

    public Page<DetailContract> findAll(Pageable pageable);

    public Optional<DetailContract> findByID(Integer id);

    public DetailContract save(DetailContract detailContract);

    public void remove(Integer id);

}

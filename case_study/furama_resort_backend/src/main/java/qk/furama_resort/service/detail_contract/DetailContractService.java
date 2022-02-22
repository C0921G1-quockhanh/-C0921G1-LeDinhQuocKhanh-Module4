package qk.furama_resort.service.detail_contract;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import qk.furama_resort.model.DetailContract;
import qk.furama_resort.repository.IContractDetailRepository;

import java.util.Optional;

@Service
public class DetailContractService implements IDetailContractService {

    @Autowired
    private IContractDetailRepository iContractDetailRepository;

    @Override
    public Page<DetailContract> findAll(Pageable pageable) {
        return this.iContractDetailRepository.findAll(pageable);
    }

    @Override
    public Optional<DetailContract> findByID(Integer id) {
        return this.iContractDetailRepository.findById(id);
    }

    @Override
    public DetailContract save(DetailContract detailContract) {
        return this.iContractDetailRepository.save(detailContract);
    }

    @Override
    public void remove(Integer id) {
        this.iContractDetailRepository.deleteById(id);
    }
}

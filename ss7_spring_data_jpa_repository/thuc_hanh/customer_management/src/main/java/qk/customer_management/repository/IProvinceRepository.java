package qk.customer_management.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import qk.customer_management.model.Province;

@Repository
public interface IProvinceRepository extends PagingAndSortingRepository<Province,Long> {
}

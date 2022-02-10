package qk.phone_management.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import qk.phone_management.model.SmartPhone;

@Repository
public interface ISmartPhoneRepository extends PagingAndSortingRepository<SmartPhone,Long> {
}

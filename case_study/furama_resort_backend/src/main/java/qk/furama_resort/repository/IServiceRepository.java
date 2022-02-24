package qk.furama_resort.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import qk.furama_resort.model.Service;

@Repository
public interface IServiceRepository extends JpaRepository<Service,Integer> {

    Page<Service> findByServiceNameContaining(String serviceName, Pageable pageable);

    Page<Service> findByServiceType_ServiceTypeID(Integer serviceTypeID, Pageable pageable);

    Page<Service> findByServiceNameContainingAndServiceType_ServiceTypeID(String serviceName, Integer serviceTypeID, Pageable pageable);

}

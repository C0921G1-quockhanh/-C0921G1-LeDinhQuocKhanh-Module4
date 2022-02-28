package qk.final_exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import qk.final_exam.model.Customer;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer,Integer> {
}
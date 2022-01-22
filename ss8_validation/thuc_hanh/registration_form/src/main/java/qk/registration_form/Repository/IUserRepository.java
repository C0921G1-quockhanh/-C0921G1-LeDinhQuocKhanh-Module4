package qk.registration_form.Repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import qk.registration_form.Model.User;

@Repository
public interface IUserRepository extends PagingAndSortingRepository<User,Integer> {
}

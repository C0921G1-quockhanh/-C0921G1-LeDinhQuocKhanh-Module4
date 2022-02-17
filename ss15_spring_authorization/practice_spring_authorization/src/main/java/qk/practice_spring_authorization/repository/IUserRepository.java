package qk.practice_spring_authorization.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import qk.practice_spring_authorization.model.User;

@Repository
public interface IUserRepository extends JpaRepository<User,Long> {

    User findByUsername(String username);

}

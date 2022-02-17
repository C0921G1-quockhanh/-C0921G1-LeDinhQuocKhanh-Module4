package qk.practice_spring_authorization.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import qk.practice_spring_authorization.model.Blog;

@Repository
public interface IBlogRepository extends JpaRepository<Blog,Integer> {
}

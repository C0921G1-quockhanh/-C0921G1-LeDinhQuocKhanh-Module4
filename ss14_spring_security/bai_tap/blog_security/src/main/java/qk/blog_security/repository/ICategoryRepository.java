package qk.blog_security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import qk.blog_security.model.Category;

@Repository
public interface ICategoryRepository extends JpaRepository<Category,Integer> {
}

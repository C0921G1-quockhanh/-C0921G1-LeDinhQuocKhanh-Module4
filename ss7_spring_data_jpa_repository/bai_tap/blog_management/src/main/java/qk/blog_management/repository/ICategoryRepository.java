package qk.blog_management.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import qk.blog_management.model.Category;

@Repository
public interface ICategoryRepository extends PagingAndSortingRepository<Category,Integer> {
}

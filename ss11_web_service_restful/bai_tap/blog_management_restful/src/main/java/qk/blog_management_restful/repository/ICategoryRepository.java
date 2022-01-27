package qk.blog_management_restful.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import qk.blog_management_restful.model.Category;

@Repository
public interface ICategoryRepository extends PagingAndSortingRepository<Category,Integer> {
}

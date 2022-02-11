package qk.blog_ajax.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import qk.blog_ajax.model.Category;

@Repository
public interface ICategoryRepository extends PagingAndSortingRepository<Category,Integer> {

}

package qk.blog_management.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import qk.blog_management.model.Blog;

@Repository
public interface IBlogRepository extends PagingAndSortingRepository<Blog,Integer> {
}

package qk.blog_ajax.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import qk.blog_ajax.model.Blog;

@Repository
public interface IBlogRepository extends PagingAndSortingRepository<Blog,Integer> {

    Iterable<Blog> findBlogsByCategory_Id(Integer categoryID);

}

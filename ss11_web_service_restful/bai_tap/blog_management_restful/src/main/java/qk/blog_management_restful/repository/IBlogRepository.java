package qk.blog_management_restful.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import qk.blog_management_restful.model.Blog;

@Repository
public interface IBlogRepository extends PagingAndSortingRepository<Blog,Integer> {

    Iterable<Blog> findAllByCategory_Id(Integer categoryID);

}

package qk.blog_management.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import qk.blog_management.model.Blog;
import qk.blog_management.model.Category;

@Repository
public interface IBlogRepository extends PagingAndSortingRepository<Blog,Integer> {

    Page<Blog> findAllByAuthor(String author,Pageable pageable);

    Page<Blog> findAllByCategory_Id(Integer categoryID,Pageable pageable);

    Page<Blog> findAllByAuthorAndCategory_Id(String author,Integer categoryID,Pageable pageable);

}

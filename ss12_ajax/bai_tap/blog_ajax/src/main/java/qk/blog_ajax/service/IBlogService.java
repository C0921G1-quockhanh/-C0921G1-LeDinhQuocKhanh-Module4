package qk.blog_ajax.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import qk.blog_ajax.model.Blog;

import java.util.Optional;

public interface IBlogService {

    Iterable<Blog> findAll();

    Page<Blog> findAll(Pageable pageable);

    Optional<Blog> findByID(Integer id);

    Blog save(Blog blog);

    void remove(Integer id);

    Iterable<Blog> findBlogsByCategory_Id(Integer categoryID);

    Iterable<Blog> findBlogsByAuthorContaining(String name);

}

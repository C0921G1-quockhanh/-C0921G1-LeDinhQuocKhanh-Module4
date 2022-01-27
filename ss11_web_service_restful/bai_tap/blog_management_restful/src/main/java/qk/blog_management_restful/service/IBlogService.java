package qk.blog_management_restful.service;

import qk.blog_management_restful.model.Blog;

import java.util.Optional;

public interface IBlogService {

    Iterable<Blog> findAll();

    Optional<Blog> findByID(Integer id);

    Blog save(Blog blog);

    void remove(Integer id);

    Iterable<Blog> findAllByCategory_Id(Integer categoryID);

}

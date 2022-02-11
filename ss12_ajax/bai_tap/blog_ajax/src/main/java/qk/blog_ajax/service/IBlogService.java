package qk.blog_ajax.service;

import qk.blog_ajax.model.Blog;

import java.util.Optional;

public interface IBlogService {

    Iterable<Blog> findAll();

    Optional<Blog> findByID(Integer id);

    Blog save(Blog blog);

    void remove(Integer id);

}

package qk.blog_security.service;

import qk.blog_security.model.Blog;

import java.util.Optional;

public interface IBlogService {

    Iterable<Blog> findAll();

    Optional<Blog> findById(Integer id);

    Blog save(Blog blog);

    void remove(Integer id);
}

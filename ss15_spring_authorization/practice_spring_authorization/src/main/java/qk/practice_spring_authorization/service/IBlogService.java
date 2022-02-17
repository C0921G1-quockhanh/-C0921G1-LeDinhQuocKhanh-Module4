package qk.practice_spring_authorization.service;

import qk.practice_spring_authorization.model.Blog;

import java.util.Optional;

public interface IBlogService {

    Iterable<Blog> findAll();

    Optional<Blog> findById(Integer id);

    Blog save(Blog blog);

    void remove(Integer id);
}

package qk.blog_management.service;

import qk.blog_management.model.Blog;

import java.util.Optional;

public interface IBlogService {
    
    public Iterable<Blog> findAll();

    public Optional<Blog> findByID(Integer id);

    public void save(Blog blog);

    public void remove(Integer id);
    
}

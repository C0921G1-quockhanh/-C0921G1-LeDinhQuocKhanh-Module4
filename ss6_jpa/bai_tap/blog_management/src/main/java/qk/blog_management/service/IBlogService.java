package qk.blog_management.service;

import qk.blog_management.model.Blog;

import java.util.List;

public interface IBlogService {
    public List<Blog> findAll();

    public Blog findByID(Integer id);

    public void save(Blog blog);

    public void remove(Integer id);
}

package qk.blog_management.repository;

import qk.blog_management.model.Blog;

import java.util.List;

public interface IBlogRepository {
    public List<Blog> findAll();

    public Blog findByID(Integer id);

    public void save(Blog blog);

    public void remove(Integer id);
}

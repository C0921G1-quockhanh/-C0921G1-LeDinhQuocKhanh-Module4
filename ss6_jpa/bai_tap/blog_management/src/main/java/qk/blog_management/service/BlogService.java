package qk.blog_management.service;

import org.springframework.beans.factory.annotation.Autowired;
import qk.blog_management.model.Blog;
import qk.blog_management.repository.IBlogRepository;

import java.util.List;

public class BlogService implements IBlogService {
    
    @Autowired
    private IBlogRepository iBlogRepository;
    
    @Override
    public List<Blog> findAll() {
        return this.iBlogRepository.findAll();
    }

    @Override
    public Blog findByID(Integer id) {
        return this.iBlogRepository.findByID(id);
    }

    @Override
    public void save(Blog blog) {
        this.iBlogRepository.save(blog);
    }

    @Override
    public void remove(Integer id) {
        this.iBlogRepository.remove(id);
    }
}

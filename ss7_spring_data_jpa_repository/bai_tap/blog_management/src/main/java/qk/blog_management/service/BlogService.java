package qk.blog_management.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import qk.blog_management.model.Blog;
import qk.blog_management.repository.IBlogRepository;

import java.util.Optional;

@Service
public class BlogService implements IBlogService {
    
    @Autowired
    private IBlogRepository iBlogRepository;

    @Override
    public Iterable<Blog> findAll() {
        return this.iBlogRepository.findAll();
    }

    @Override
    public Optional<Blog> findByID(Integer id) {
        return this.iBlogRepository.findById(id);
    }

    @Override
    public void save(Blog blog) {
        this.iBlogRepository.save(blog);
    }

    @Override
    public void remove(Integer id) {
        this.iBlogRepository.deleteById(id);
    }
}

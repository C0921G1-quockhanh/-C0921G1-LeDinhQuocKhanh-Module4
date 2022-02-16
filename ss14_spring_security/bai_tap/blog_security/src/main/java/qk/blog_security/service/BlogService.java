package qk.blog_security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import qk.blog_security.model.Blog;
import qk.blog_security.repository.IBlogRepository;

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
    public Optional<Blog> findById(Integer id) {
        return this.iBlogRepository.findById(id);
    }

    @Override
    public Blog save(Blog blog) {
        return this.iBlogRepository.save(blog);
    }

    @Override
    public void remove(Integer id) {
        this.iBlogRepository.deleteById(id);
    }
}

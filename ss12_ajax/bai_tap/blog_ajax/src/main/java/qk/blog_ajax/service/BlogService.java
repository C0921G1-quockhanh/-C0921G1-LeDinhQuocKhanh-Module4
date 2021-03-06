package qk.blog_ajax.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import qk.blog_ajax.model.Blog;
import qk.blog_ajax.repository.IBlogRepository;

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
    public Page<Blog> findAll(Pageable pageable) {
        return this.iBlogRepository.findAll(pageable);
    }

    @Override
    public Optional<Blog> findByID(Integer id) {
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

    @Override
    public Iterable<Blog> findBlogsByCategory_Id(Integer categoryID) {
        return this.iBlogRepository.findBlogsByCategory_Id(categoryID);
    }

    @Override
    public Iterable<Blog> findBlogsByAuthorContaining(String name) {
        return this.iBlogRepository.findBlogsByAuthorContaining(name);
    }


}

package qk.blog_management.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import qk.blog_management.model.Blog;
import qk.blog_management.model.Category;
import qk.blog_management.repository.IBlogRepository;
import qk.blog_management.repository.ICategoryRepository;

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
    public void save(Blog blog) {
        this.iBlogRepository.save(blog);
    }

    @Override
    public void remove(Integer id) {
        this.iBlogRepository.deleteById(id);
    }

    @Override
    public Page<Blog> findAllByAuthor(String author, Pageable pageable) {
        return this.iBlogRepository.findAllByAuthor(author,pageable);
    }

    @Override
    public Page<Blog> findAllByCategory_Id(Integer categoryID, Pageable pageable) {
        return this.iBlogRepository.findAllByCategory_Id(categoryID,pageable);
    }

    @Override
    public Page<Blog> findAllByAuthorAndCategory_Id(String author, Integer categoryID, Pageable pageable) {
        return this.iBlogRepository.findAllByAuthorAndCategory_Id(author,categoryID,pageable);
    }
}

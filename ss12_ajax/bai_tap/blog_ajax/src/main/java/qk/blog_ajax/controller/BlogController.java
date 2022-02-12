package qk.blog_ajax.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import qk.blog_ajax.model.Blog;
import qk.blog_ajax.model.Category;
import qk.blog_ajax.repository.ICategoryRepository;
import qk.blog_ajax.service.IBlogService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class BlogController {

    @Autowired
    private IBlogService iBlogService;

    @Autowired
    private ICategoryRepository iCategoryRepository;

    //truy van du lieu
    @GetMapping("/blogs")
    public ResponseEntity<Iterable<Blog>> findAllBlogs() {
        List<Blog> blogs = (List<Blog>) this.iBlogService.findAll();

        if (blogs.isEmpty())
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        return new ResponseEntity<>(blogs,HttpStatus.OK);
    }

    @GetMapping("/blogs/{id}")
    public ResponseEntity<Blog>findBlogByID(@PathVariable Integer id) {
        Optional<Blog> blogOptional = this.iBlogService.findByID(id);

        if (!blogOptional.isPresent())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(blogOptional.get(),HttpStatus.OK);
    }

    @GetMapping("/categories")
    public ResponseEntity<Iterable<Category>> findAllCategories() {
        List<Category> categories = (List<Category>) this.iCategoryRepository.findAll();

        if (categories.isEmpty())
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        return new ResponseEntity<>(categories,HttpStatus.OK);
    }

    @GetMapping("/categories/{id}")
    public ResponseEntity<Iterable<Blog>> findBlogsByCategoryID(@PathVariable Integer id) {
        List<Blog> blogs = (List<Blog>) this.iBlogService.findBlogsByCategory_Id(id);

        if (blogs.isEmpty())
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        return new ResponseEntity<>(blogs,HttpStatus.OK);
    }

    //tao moi du lieu
    @PostMapping("/blog")
    public ResponseEntity<Blog> saveBlog(@RequestBody Blog blog) {
        return new ResponseEntity<>(this.iBlogService.save(blog),HttpStatus.CREATED);
    }


}

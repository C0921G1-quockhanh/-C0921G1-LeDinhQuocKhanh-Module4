package qk.blog_ajax.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
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

    //truy van du lieu api
    @GetMapping("/blogs")
    public ResponseEntity<Iterable<Blog>> findAllBlogs() {
        List<Blog> blogs = (List<Blog>) this.iBlogService.findAll();

        if (blogs.isEmpty())
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

//        System.out.println(blogs.get(0).getCategory().getName());

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

    @GetMapping("/{author}")
    public ResponseEntity<Iterable<Blog>> findBlogsByAuthorContaining(@PathVariable String author) {
        List<Blog> blogs = (List<Blog>) this.iBlogService.findBlogsByAuthorContaining(author);

        if (blogs.isEmpty())
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        return new ResponseEntity<>(blogs,HttpStatus.OK);
    }

    //
    @GetMapping("/list")
    public ModelAndView getAllBlogs() {
        ModelAndView modelAndView = new ModelAndView("list");
        modelAndView.addObject("blogs",this.iBlogService.findAll());
        modelAndView.addObject("categories",this.iCategoryRepository.findAll());
        return modelAndView;
    }

    //tao moi du lieu api
    @PostMapping("/blog")
    public ResponseEntity<Blog> saveBlog(@RequestBody Blog blog) {
        return new ResponseEntity<>(this.iBlogService.save(blog),HttpStatus.CREATED);
    }

    //xoa du lieu api
    @DeleteMapping("/{id}")
    public ResponseEntity<Blog> deleteBlog(@PathVariable Integer id) {
        Optional<Blog> blogOptional = this.iBlogService.findByID(id);

        if (!blogOptional.isPresent())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        this.iBlogService.remove(id);
        return new ResponseEntity<>(blogOptional.get(),HttpStatus.OK);
    }

    //cap nhat du lieu api
    @PutMapping("/{id}")
    public ResponseEntity<Blog> updateBlog(@PathVariable Integer id, @RequestBody Blog blog) {
        Optional<Blog> blogOptional = this.iBlogService.findByID(id);

        if (!blogOptional.isPresent())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        blog.setId(blogOptional.get().getId());
        return new ResponseEntity<>(this.iBlogService.save(blog),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ModelAndView getBlog(@PathVariable Integer id) {
        ModelAndView modelAndView = new ModelAndView("edit");

        Optional<Blog> blogOptional = this.iBlogService.findByID(id);

        if (blogOptional.isPresent())
            modelAndView.addObject("blog",blogOptional.get());

        modelAndView.addObject("categories",this.iCategoryRepository.findAll());

        return modelAndView;
    }


}

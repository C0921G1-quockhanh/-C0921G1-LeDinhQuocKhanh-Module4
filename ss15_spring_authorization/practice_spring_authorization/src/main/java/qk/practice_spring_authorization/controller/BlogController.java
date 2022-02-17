package qk.practice_spring_authorization.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import qk.practice_spring_authorization.model.Blog;
import qk.practice_spring_authorization.repository.ICategoryRepository;
import qk.practice_spring_authorization.service.IBlogService;

@Controller
@RequestMapping("/blog")
public class BlogController {

    @Autowired
    private IBlogService iBlogService;

    @Autowired
    private ICategoryRepository iCategoryRepository;

    @GetMapping("")
    public String getAllBlogs(Model model) {
        model.addAttribute("blogs",this.iBlogService.findAll());
        return "list";
    }

    @GetMapping("/create")
    public String createBlog(Model model) {
        Blog blog = new Blog();
        model.addAttribute("blog",blog);
        model.addAttribute("categories",this.iCategoryRepository.findAll());
        return "create";
    }

}

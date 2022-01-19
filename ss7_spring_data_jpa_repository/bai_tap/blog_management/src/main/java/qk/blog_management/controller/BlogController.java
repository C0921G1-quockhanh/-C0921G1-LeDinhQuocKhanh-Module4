package qk.blog_management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import qk.blog_management.model.Blog;
import qk.blog_management.model.Category;
import qk.blog_management.repository.ICategoryRepository;
import qk.blog_management.service.IBlogService;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(value = "/blog")
public class BlogController {

    @Autowired
    private IBlogService iBlogService;

    @Autowired
    private ICategoryRepository iCategoryRepository;

    @ModelAttribute("categories")
    public Iterable<Category> categories() {
        return this.iCategoryRepository.findAll();
    }

    @GetMapping(value = "")
    public String list(Model model) {
        Iterable<Blog> blogs = this.iBlogService.findAll();
        model.addAttribute("blogs",blogs);
        return "list";
    }

    @GetMapping(value = "/create")
    public String addNew(Model model) {
        model.addAttribute("blog",new Blog());
        return "create";
    }

    @PostMapping(value = "/save")
    public String save(@ModelAttribute(name = "blog") Blog blog, RedirectAttributes redirectAttributes) {
        this.iBlogService.save(blog);
        redirectAttributes.addFlashAttribute("msg","Add new blog successfully!");

        return "redirect:/blog";
    }

    @GetMapping(value = "/{id}/edit")
    public String edit(@PathVariable Integer id, Model model) {

        Optional<Blog> blog = this.iBlogService.findByID(id);

        if (blog.isPresent()) {
            model.addAttribute("blog",blog.get());
            return "edit";
        } else {
            return "error.404";
        }
    }

    @PostMapping(value = "/update")
    public String update(@ModelAttribute(name = "blog") Blog blog, RedirectAttributes redirectAttributes) {
        this.iBlogService.save(blog);
        redirectAttributes.addFlashAttribute("msg","Update blog successfully!");
        return "redirect:/blog";
    }

    @GetMapping(value = "/{id}/delete")
    public String delete(@PathVariable Integer id, Model model) {
        Optional<Blog> blog = this.iBlogService.findByID(id);

        if (blog.isPresent()) {
            model.addAttribute("blog",blog.get());
            return "delete";
        } else {
            return "error.404";
        }
    }

    @PostMapping(value = "/delete")
    public String delete(@ModelAttribute(name = "blog") Blog blog, RedirectAttributes redirectAttributes) {
        this.iBlogService.remove(blog.getId());
        redirectAttributes.addFlashAttribute("msg","Delete blog successfully!");

        return "redirect:/blog";
    }

    @GetMapping(value = "/{id}/view")
    public String view(@PathVariable Integer id, Model model) {
        Optional<Blog> blog = this.iBlogService.findByID(id);

        if (blog.isPresent()) {
            model.addAttribute("blog",blog.get());
            return "view";
        } else {
            return "error.404";
        }
    }
}

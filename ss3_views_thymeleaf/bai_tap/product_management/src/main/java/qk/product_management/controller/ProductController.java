package qk.product_management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import qk.product_management.model.Product;
import qk.product_management.service.IProductService;

import java.util.List;

@Controller
@RequestMapping(value = "/product")
public class ProductController {

    @Autowired
    private IProductService iProductService;

    @GetMapping(value = "")
    public String list(Model model) {
        List<Product> products = this.iProductService.findAll();
        model.addAttribute("products",products);

        return "list";
    }

    @GetMapping(value = "/create")
    public String addNew(Model model) {
        model.addAttribute("product", new Product());
        return "create";
    }

    @PostMapping(value = "/save")
    public String save(Product product, RedirectAttributes redirectAttributes) {
        product.setId(this.iProductService.findAll().size() + 1);
        this.iProductService.save(product);
        redirectAttributes.addFlashAttribute("msg","Add new product successfully!");

        return "redirect:/product";
    }

    @GetMapping(value = "/{id}/edit")
    public String edit(@PathVariable int id,Model model) {
        model.addAttribute("product",this.iProductService.findByID(id));
        return "edit";
    }

    @PostMapping(value = "/update")
    public String update(Product product, RedirectAttributes redirectAttributes) {
        this.iProductService.update(product.getId(),product);
        redirectAttributes.addFlashAttribute("msg","Update product successfully!");

        return "redirect:/product";
    }

    @GetMapping(value = "/{id}/delete")
    public String delete(@PathVariable int id, Model model) {
        model.addAttribute("product",this.iProductService.findByID(id));
        return "delete";
    }

    @PostMapping(value = "/delete")
    public String delete(Product product, RedirectAttributes redirectAttributes) {
        this.iProductService.remove(product.getId());
        redirectAttributes.addFlashAttribute("msg","Delete product successfully!");

        return "redirect:/product";
    }

    @GetMapping(value = "/{id}/view")
    public String view(@PathVariable int id, Model model) {
        model.addAttribute("product",this.iProductService.findByID(id));
        return "view";
    }

    @GetMapping(value = "/showSearchForm")
    public String searchForm() {
        return "show_search_form";
    }

    @PostMapping(value = "/search")
    public String search(@RequestParam(name = "name") String name,Model model) {
        List<Product> products = this.iProductService.searchByName(name);
        model.addAttribute("products",products);

        return "search";
    }
}

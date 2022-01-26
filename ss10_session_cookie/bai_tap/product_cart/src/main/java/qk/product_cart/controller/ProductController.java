package qk.product_cart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import qk.product_cart.model.Cart;
import qk.product_cart.model.Product;
import qk.product_cart.service.IProductService;

import java.util.Optional;

@Controller
@RequestMapping(value = "/shop")
@SessionAttributes("cart")
public class ProductController {

    @Autowired
    private IProductService iProductService;

    //Neu session cart rong thi moi thuc hien phuong thuc setUpCart
    @ModelAttribute("cart")
    public Cart setUpCart() {
        return new Cart();
    }

    @GetMapping(value = "")
    public String showShop(Model model, @PageableDefault(size = 2) Pageable pageable) {
        Page<Product> products = this.iProductService.findAll(pageable);
        model.addAttribute("products",products);
        return "list";
    }

    @GetMapping(value = "/{id}/add")
    public String addToCart(@PathVariable Integer id, @SessionAttribute("cart") Cart cart, @RequestParam("action") String action, RedirectAttributes redirectAttributes, @PageableDefault(size = 2) Pageable pageable, Model model) {
        Optional<Product> productOptional = this.iProductService.findByID(id);

        if (!productOptional.isPresent())
            return "error.404";

        if (action.equals("show")) {
            cart.addProduct(productOptional.get());
            model.addAttribute("cart",cart);
            return "shopping-cart";
        }

        cart.addProduct(productOptional.get());
        Page<Product> products = this.iProductService.findAll(pageable);
        model.addAttribute("products",products);
        model.addAttribute("msg","Add product into your cart successfully!");

        return "list";
    }

    @GetMapping(value = "/{id}/view")
    public String viewProduct(@PathVariable Integer id, Model model) {
        Optional<Product> productOptional = this.iProductService.findByID(id);

        if (productOptional.isPresent()) {
            model.addAttribute("product",productOptional.get());
            return "view";
        } else {
            return "error.404";
        }
    }

    @GetMapping(value = "/{id}/decrease")
    public String decreaseProduct(@PathVariable Integer id, @SessionAttribute("cart") Cart cart, Model model) throws Exception {
        Optional<Product> productOptional = this.iProductService.findByID(id);

        if (!productOptional.isPresent())
            return "error.404";

        cart.decreaseProduct(productOptional.get());
        model.addAttribute("cart",cart);
        return "shopping-cart";
    }


    @ExceptionHandler(value = Exception.class)
    public String cannotDecrease() {
        return "error.404";
    }

}

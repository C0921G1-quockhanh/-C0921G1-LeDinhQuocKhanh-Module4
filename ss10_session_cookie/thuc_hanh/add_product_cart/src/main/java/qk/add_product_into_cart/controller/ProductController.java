package qk.add_product_into_cart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import qk.add_product_into_cart.model.Cart;
import qk.add_product_into_cart.model.Product;
import qk.add_product_into_cart.service.IProductService;

import java.util.Optional;

@Controller
@SessionAttributes("cart")
public class ProductController {
    
    @Autowired
    private IProductService iProductService;
    
    @ModelAttribute("cart")
    public Cart setUpCart() {
        return new Cart();
    }
    
    @GetMapping(value = "/shop")
    public ModelAndView showShop() {
        ModelAndView modelAndView = new ModelAndView("/shop");
        modelAndView.addObject("products",this.iProductService.findAll());
        return modelAndView;
    }

    @GetMapping(value = "/add/{id}")
    public String addToCart(@PathVariable Long id, @ModelAttribute Cart cart, @RequestParam("action") String action) {
        Optional<Product> productOptional = this.iProductService.findByID(id);

        if (!productOptional.isPresent())
            return "/error.404";

        if (action.equals("show")) {
            cart.addProduct(productOptional.get());
            return "cart";
        }

        cart.addProduct(productOptional.get());
        return "redirect:/shop";
    }
    
}

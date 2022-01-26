package qk.add_product_into_cart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;
import qk.add_product_into_cart.model.Cart;

@Controller
public class ShoppingCartController {
    
    @ModelAttribute("cart")
    public Cart setUpCart() {
        return new Cart();
    }
    
    @GetMapping(value = "/shopping-cart")
    public ModelAndView showCart(@SessionAttribute("cart") Cart cart) {
        ModelAndView modelAndView = new ModelAndView("/cart");
        modelAndView.addObject("cart",cart);
        return modelAndView;
    }
    
}

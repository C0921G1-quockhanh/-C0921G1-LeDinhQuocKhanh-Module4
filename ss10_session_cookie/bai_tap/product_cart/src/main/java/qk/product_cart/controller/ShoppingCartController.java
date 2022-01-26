package qk.product_cart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttribute;
import qk.product_cart.model.Cart;

@Controller
public class ShoppingCartController {

    @ModelAttribute("cart")
    public Cart setUpCart() {
        return new Cart();
    }

    @GetMapping(value = "/your-cart")
    public String showCart(Model model, @SessionAttribute("cart") Cart cart) {
        model.addAttribute("cart",cart);
        return "shopping-cart";
    }
}

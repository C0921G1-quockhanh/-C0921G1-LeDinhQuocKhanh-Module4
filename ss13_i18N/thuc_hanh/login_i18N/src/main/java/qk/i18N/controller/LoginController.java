package qk.i18N.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import qk.i18N.model.User;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String loginUser(Model model) {
        User user = new User();
        model.addAttribute("user",user);
        return "login";
    }

    @GetMapping("/dashboard")
    public String dashboard() {
        return "dashboard";
    }

}

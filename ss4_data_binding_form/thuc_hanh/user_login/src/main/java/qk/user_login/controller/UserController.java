package qk.user_login.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import qk.user_login.model.Login;
import qk.user_login.model.User;
import qk.user_login.service.ILoginService;

@Controller
public class UserController {

    @Autowired
    private ILoginService iLoginService;

    @GetMapping(value = "/home")
    public ModelAndView home() {
        ModelAndView modelAndView = new ModelAndView("home","login",new Login());
        return modelAndView;
    }

    @PostMapping(value = "/login")
    public ModelAndView login(@ModelAttribute(name = "login") Login login) {
        User user = iLoginService.checkLogin(login);

        ModelAndView modelAndView;

        if (user == null) {
            modelAndView = new ModelAndView("error");
        } else {
            modelAndView = new ModelAndView("user");
            modelAndView.addObject("user",user);
        }

        return modelAndView;
    }
}

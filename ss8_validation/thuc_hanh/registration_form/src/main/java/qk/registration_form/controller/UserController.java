package qk.registration_form.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import qk.registration_form.Model.User;
import qk.registration_form.Model.UserDto;
import qk.registration_form.service.IUserService;


@Controller
public class UserController {

    @Autowired
    private IUserService iUserService;

    @GetMapping(value = "/user")
    public String showNewForm(Model model) {
        model.addAttribute("userDto",new UserDto());
        return "create";
    }
    
    @PostMapping(value = "/validateUser")
    public String create(@Validated @ModelAttribute(name = "userDto") UserDto userDto, BindingResult bindingResult, Model model) {
        if (bindingResult.hasFieldErrors()) {
            return "create";
        }
        else {
            User user = new User();
            BeanUtils.copyProperties(userDto,user);
            this.iUserService.save(user);
            return "result";
        }

    }

}

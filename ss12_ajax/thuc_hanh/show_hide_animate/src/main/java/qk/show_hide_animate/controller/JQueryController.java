package qk.show_hide_animate.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class JQueryController {

    @GetMapping(value = "/show-hide")
    public String showAndHide() {
        return "show-hide";
    }

    @GetMapping(value = "/animate")
    public String animate() {
        return "animate";
    }
}

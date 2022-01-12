package qk.sandwich_condiments.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class SandwichController {

    @GetMapping(value = "/")
    public String sandwichHome() {
        return "condiments";
    }
    
    @PostMapping(value = "/sandwich")
    public String selectedCondiments(@RequestParam(name = "lettuce", required = false) String lettuce,
                                     @RequestParam(name = "tomato", required = false) String tomato,
                                     @RequestParam(name = "mustard", required = false) String mustard,
                                     @RequestParam(name = "sprouts", required = false) String sprouts,
                                     Model model
    ) {
        List<String> condiments = new ArrayList<>();
        
        if (lettuce != null)
            condiments.add(lettuce);
//            model.addAttribute("lettuce",lettuce);
//        System.out.println(lettuce);

        if (tomato != null)
            condiments.add(tomato);
//            model.addAttribute("tomato",tomato);
//        System.out.println(tomato);

        if (mustard != null)
            condiments.add(mustard);
//            model.addAttribute("mustard",mustard);
//        System.out.println(mustard);

        if (sprouts != null)
            condiments.add(sprouts);
//            model.addAttribute("sprouts",sprouts);
//        System.out.println(sprouts);
        
        model.addAttribute("condiments",condiments);
        
        return "selectedChoice";
    }
}

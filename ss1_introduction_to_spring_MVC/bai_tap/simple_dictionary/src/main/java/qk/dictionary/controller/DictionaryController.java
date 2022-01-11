package qk.dictionary.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.LinkedHashMap;
import java.util.Map;

@Controller
public class DictionaryController {
    
    protected static Map<String,String> dictionary;
    
    static {
        dictionary = new LinkedHashMap<>();
        dictionary.put("hello","xin chao");
        dictionary.put("computer","may tinh");
        dictionary.put("store","cua hang");
        dictionary.put("school","truong hoc");
    }

    @GetMapping("/dictionary")
    public String inputWord() {
        return "input";
    }
    
    @PostMapping("/dictionary")
    public String translatedWord(@RequestParam String engWord, Model model) {
        if (dictionary.get(engWord) != null)
            model.addAttribute("vieWord",dictionary.get(engWord));
        else 
            model.addAttribute("vieWord","This word is not in dictionary! Please try other words!");
        
        model.addAttribute("engWord",engWord);
        
        return "result";
    }
}

package qk.calculator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {

    @GetMapping("/")
    public String calculatorHome() {
        return "home";
    }
    
    @PostMapping("/calculate")
    public String showResult(@RequestParam(name = "firstOperand") double firstOperand,
                             @RequestParam(name = "secondOperand") double secondOperand,
//                             @RequestParam(name = "Addition", required = false) String addition,
//                             @RequestParam(name = "Subtraction", required = false) String subtraction,
//                             @RequestParam(name = "Multiplication", required = false) String multiplication,
//                             @RequestParam(name = "Division", required = false) String division,
                             @RequestParam(name = "calculate") String calculate,
                             Model model
    ) {
        Double finalAnswer = null;

//        if (addition != null)
//            finalAnswer = this.addition(firstOperand,secondOperand);
//
//        if (subtraction != null)
//            finalAnswer = this.subtraction(firstOperand,secondOperand);
//
//        if (multiplication != null)
//            finalAnswer = this.multiplication(firstOperand,secondOperand);
//
//        if (division != null)
//            finalAnswer = this.division(firstOperand,secondOperand);

        switch (calculate) {
            case "Addition":
                finalAnswer = this.addition(firstOperand,secondOperand);
                break;

            case "Subtraction":
                finalAnswer = this.subtraction(firstOperand,secondOperand);
                break;

            case "Multiplication":
                finalAnswer = this.multiplication(firstOperand,secondOperand);
                break;

            case "Division":
                finalAnswer = this.division(firstOperand,secondOperand);
                break;
        }
        
        model.addAttribute("firstOperand",firstOperand);
        model.addAttribute("secondOperand",secondOperand);
        model.addAttribute("finalAnswer",finalAnswer);

        return "result";
    }

    private double addition(double a, double b) {
        return a + b;
    }

    private double subtraction(double a, double b) {
        return a - b;
    }

    private double multiplication(double a, double b) {
        return a * b;
    }

    private double division(double a, double b) {
        if (b == 0)
            throw new ArithmeticException();
        else {
            return a / b;
        }
    }
}

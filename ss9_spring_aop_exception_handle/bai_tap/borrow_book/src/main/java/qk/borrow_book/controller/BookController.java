package qk.borrow_book.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import qk.borrow_book.model.Book;
import qk.borrow_book.service.IBookService;

import java.util.Optional;

@Controller
@RequestMapping(value = "/book")
public class BookController {

    @Autowired
    private IBookService iBookService;

    @GetMapping(value = "")
    public String list(Model model, @PageableDefault(size = 2) Pageable pageable) {
        Page<Book> books = this.iBookService.findAll(pageable);
        model.addAttribute("books",books);
        return "list";
    }

    @GetMapping(value = "/{id}/detail")
    public String detail(@PathVariable Integer id, Model model) {

        Optional<Book> book = this.iBookService.findByID(id);

        if (book.isPresent()) {
            model.addAttribute("book",book.get());
            return "detail";
        } else {
            return "error.404";
        }

    }

    @PostMapping(value = "/updateQuantity")
    public String updateQuantity(@ModelAttribute(name = "book") Book book, RedirectAttributes redirectAttributes) throws Exception {

        Integer currentQuantity = book.getQuantity();

        if (currentQuantity <= 0)
            throw new Exception();
        else {
            book.setQuantity(currentQuantity - 1);
            this.iBookService.save(book);
            redirectAttributes.addFlashAttribute("msg","Borrow book successfully!");
            return "redirect:/book";
        }

    }

    @GetMapping(value = "/return")
    public String returnBook() {
        return "returnBook";
    }

    @PostMapping(value = "/afterReturn")
    public String afterReturn(@RequestParam(name = "id") Integer id, RedirectAttributes redirectAttributes) {
        Optional<Book> book = this.iBookService.findByID(id);

        if (book.isPresent()) {
            book.get().setQuantity(book.get().getQuantity() + 1);
            this.iBookService.save(book.get());
            redirectAttributes.addFlashAttribute("msg","Return book successfully!");

            return "redirect:/book";
        } else {
            return "error.404";
        }
    }

    @ExceptionHandler(value = Exception.class)
    public String goNoBookPage() {
        return "noBookBorrow";
    }

}

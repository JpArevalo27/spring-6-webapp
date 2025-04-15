package guru.springframework.spring6webapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import guru.springframework.spring6webapp.services.BookService;
import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class BookController {
    
    private final BookService bookService;

    @RequestMapping("/books")
    public String getBooks(Model model) {
        model.addAttribute("bookList", bookService.findAll());
        return "books-template";
    }
}

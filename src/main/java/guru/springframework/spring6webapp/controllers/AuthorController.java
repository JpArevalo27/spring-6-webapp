package guru.springframework.spring6webapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import guru.springframework.spring6webapp.services.AuthorService;
import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class AuthorController {
    
    private AuthorService authorService;

    @RequestMapping("/authors")
    public String getAuthors(Model model){
        model.addAttribute("authorList", authorService.findAll());
        return "authors-template";
    }
}

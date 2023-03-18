package ru.vasiljev.springcourse.project2springboot.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.vasiljev.springcourse.project2springboot.services.BooksService;

@Controller
@RequestMapping("/books/search")
public class BooksSearchController {
    private final BooksService booksService;

    public BooksSearchController(BooksService booksService) {
        this.booksService = booksService;
    }

    @GetMapping
    public String index(Model model, @RequestParam(value = "request", required = false) String nameToSearch) {
        model.addAttribute("books", booksService.findByName(nameToSearch));
        return "/books/search/index";
    }
}

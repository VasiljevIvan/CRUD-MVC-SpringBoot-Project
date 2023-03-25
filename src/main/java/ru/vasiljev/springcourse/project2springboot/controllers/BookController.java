package ru.vasiljev.springcourse.project2springboot.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.vasiljev.springcourse.project2springboot.models.Book;
import ru.vasiljev.springcourse.project2springboot.models.Person;
import ru.vasiljev.springcourse.project2springboot.services.BooksService;
import ru.vasiljev.springcourse.project2springboot.services.PeopleService;

import javax.validation.Valid;

@Controller
@RequestMapping("/books")
public class BookController {
    private final BooksService booksService;
    private final PeopleService peopleService;

    public BookController(BooksService booksService, PeopleService peopleService) {
        this.booksService = booksService;
        this.peopleService = peopleService;
    }

    @GetMapping
    public String index(Model model, @RequestParam(value = "page", required = false) String page,
                        @RequestParam(value = "items_per_page", required = false) String itemsPerPage,
                        @RequestParam(value = "sort_by_year", required = false) String sortByYear) {
        model.addAttribute("books", booksService.findAll(page, itemsPerPage, sortByYear));
        return "books/index";
    }

    @GetMapping("/{id}")
    public String read(@PathVariable("id") int id, Model model, @ModelAttribute("person") Person person) {
        model.addAttribute("people", peopleService.findAll());
        model.addAttribute("book", booksService.findById(id));
        return "books/show";
    }

    @GetMapping("/{id}/edit")
    public String update(@PathVariable("id") int id, Model model) {
        model.addAttribute("book", booksService.findById(id));
        return "books/edit";
    }

    @GetMapping("/new")
    public String createPerson(@ModelAttribute("book") Book book) {
        return "books/new";
    }

    @PostMapping("")
    public String create(@ModelAttribute("book") @Valid Book book, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "books/new";
        booksService.save(book);
        return "redirect:/books";
    }

    @PatchMapping("/{id}")
    public String edit(@ModelAttribute("book") @Valid Book book, BindingResult bindingResult, @PathVariable("id") int id) {
        if (bindingResult.hasErrors())
            return "books/edit";
        booksService.update(id, book);
        return "redirect:/books";
    }

    @PatchMapping("/{id}/set")
    public String setPerson(@ModelAttribute("book") Book book,
                            @PathVariable("id") int id, @ModelAttribute("person") Person person) {
        booksService.setOwner(id, person);
        return "redirect:/books/" + id;
    }

    @DeleteMapping("/{id}/set")
    public String deletePerson(@PathVariable("id") int id) {
        booksService.deleteOwner(id);
        return "redirect:/books/" + id;
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        booksService.delete(id);
        return "redirect:/books";
    }
}

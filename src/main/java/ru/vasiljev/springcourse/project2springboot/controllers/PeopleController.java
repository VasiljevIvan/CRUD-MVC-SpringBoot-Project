package ru.vasiljev.springcourse.project2springboot.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.vasiljev.springcourse.project2springboot.models.Person;
import ru.vasiljev.springcourse.project2springboot.services.BooksService;
import ru.vasiljev.springcourse.project2springboot.services.PeopleService;
import ru.vasiljev.springcourse.project2springboot.util.PersonValidator;

import javax.validation.Valid;

@Controller
@RequestMapping("/people")
public class PeopleController {
    private final PersonValidator personValidator;
    private final PeopleService peopleService;
    private final BooksService booksService;

    public PeopleController(PersonValidator personValidator, PeopleService peopleService, BooksService booksService) {
        this.personValidator = personValidator;
        this.peopleService = peopleService;
        this.booksService = booksService;
    }

    @GetMapping
    public String index(Model model) {
        model.addAttribute("people", peopleService.findAll());
        return "people/index";
    }

    @GetMapping("/{id}")
    public String read(@PathVariable("id") int id, Model model) {
        model.addAttribute("books", peopleService.findById(id).getBooks());
        model.addAttribute("person", peopleService.findById(id));
        return "people/show";
    }

    @GetMapping("/{id}/edit")
    public String update(@PathVariable("id") int id, Model model) {
        model.addAttribute("person", peopleService.findById(id));
        return "people/edit";
    }

    @GetMapping("/new")
    public String createPerson(@ModelAttribute("person") Person person) {
        return "people/new";
    }

    @PostMapping("")
    public String create(@ModelAttribute("person") @Valid Person person, BindingResult bindingResult) {
        personValidator.validate(person, bindingResult);
        if (bindingResult.hasErrors())
            return "people/new";
        peopleService.save(person);
        return "redirect:/people";
    }

    @PatchMapping("/{id}")
    public String edit(@ModelAttribute("person") @Valid Person person, BindingResult bindingResult, @PathVariable("id") int id) {
        if (bindingResult.hasErrors())
            return "people/edit";
        peopleService.update(id, person);
        return "redirect:/people";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        peopleService.delete(id);
        return "redirect:/people";
    }

    @DeleteMapping("/{id}/book")
    public String deletePerson(@PathVariable("id") int id, @RequestParam("bookId") int bookId) {
        booksService.deleteOwner(bookId);
        return "redirect:/people/" + id;
    }

    @PatchMapping("/{id}/book")
    public String setPerson(@PathVariable("id") int id, @RequestParam("bookId") int bookId) {
        booksService.setOwner(bookId,peopleService.findById(id));
        return "redirect:/people/" + id;
    }
}

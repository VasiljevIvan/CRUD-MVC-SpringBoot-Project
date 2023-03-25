package ru.vasiljev.springcourse.project2springboot.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import ru.vasiljev.springcourse.project2springboot.models.Book;
import ru.vasiljev.springcourse.project2springboot.models.Person;
import ru.vasiljev.springcourse.project2springboot.repositories.BooksRepository;

import java.time.LocalDateTime;
import java.util.List;


@Service
@Transactional(readOnly = true)
public class BooksService {
    private BooksRepository booksRepository;

    @Autowired
    public BooksService(BooksRepository booksRepository) {
        this.booksRepository = booksRepository;
    }

    public List<Book> findAll(String page, String itemsPerPage, String isSortedByYear) {
        if (page != null && itemsPerPage != null && isSortedByYear != null && isSortedByYear.equalsIgnoreCase("true"))
            return booksRepository.findAll(PageRequest.of(Integer.parseInt(page), Integer.parseInt(itemsPerPage), Sort.by("year"))).getContent();
        else if (page != null && itemsPerPage != null)
            return booksRepository.findAll(PageRequest.of(Integer.parseInt(page), Integer.parseInt(itemsPerPage))).getContent();
        else if (isSortedByYear != null && isSortedByYear.equalsIgnoreCase("true"))
            return booksRepository.findAll(Sort.by("year"));
        else
            return booksRepository.findAll();
    }

    public Book findById(int id) {
        return booksRepository.findById(id).orElse(null);
    }

    public List<Book> findByName(String nameToSearch) {
        return booksRepository.findByNameStartingWith(nameToSearch);
    }

    @Transactional
    public void save(Book book) {
        booksRepository.save(book);
    }

    @Transactional
    public void update(int id, Book book) {
        book.setId(id);
        booksRepository.save(book);
    }

    @Transactional
    public void delete(int id) {
        booksRepository.deleteById(id);
    }

    @Transactional
    public void setOwner(int id, Person person) {
        booksRepository.findById(id).ifPresent(book -> book.setOwner(person));
        booksRepository.findById(id).ifPresent(book -> book.setOwnedAt(LocalDateTime.now()));
    }

    @Transactional
    public void deleteOwner(int id) {
        booksRepository.findById(id).ifPresent(book -> book.setOwner(null));
        booksRepository.findById(id).ifPresent(book -> book.setOwnedAt(null));
    }
}

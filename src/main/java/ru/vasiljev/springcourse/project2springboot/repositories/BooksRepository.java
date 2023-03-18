package ru.vasiljev.springcourse.project2springboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.vasiljev.springcourse.project2springboot.models.Book;

import java.util.List;

@Repository
public interface BooksRepository extends JpaRepository<Book, Integer> {
    public List<Book> findByNameStartingWith(String nameToSearch);
}

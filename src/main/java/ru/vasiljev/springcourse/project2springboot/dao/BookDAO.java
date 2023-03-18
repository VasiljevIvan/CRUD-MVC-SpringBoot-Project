package ru.vasiljev.springcourse.project2springboot.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.vasiljev.springcourse.project2springboot.models.Book;

import java.util.List;

@Component
public class BookDAO {
//    private final JdbcTemplate jdbcTemplate;
//
//    @Autowired
//    public BookDAO(JdbcTemplate jdbcTemplate) {
//        this.jdbcTemplate = jdbcTemplate;
//    }
//
//    public List<Book> readAll() {
//        return jdbcTemplate.query("SELECT * FROM book", new BeanPropertyRowMapper<>(Book.class));
//    }
//
//    public Book read(int id) {
//        return jdbcTemplate.query("SELECT * FROM book WHERE id=?",
//                new Object[]{id}, new BeanPropertyRowMapper<>(Book.class)).stream().findAny().orElse(null);
//    }
//
//    public void update(Book book, int id) {
//        jdbcTemplate.update("UPDATE book SET name=?, author=?, year=? WHERE id=?",
//                book.getName(), book.getAuthor(), book.getYear(), id);
//    }
//
//    public void setOwner(int person_id, int id) {
//        jdbcTemplate.update("UPDATE book SET person_id=? WHERE id=?",
//                person_id, id);
//    }
//
//    public void deleteOwner(int id) {
//        jdbcTemplate.update("UPDATE book SET person_id=null WHERE id=?", id);
//    }
//
//    public List<Book> getOwnedBooks(int id) {
//        return jdbcTemplate.query("SELECT * FROM book WHERE person_id=?",
//                new Object[]{id}, new BeanPropertyRowMapper<>(Book.class));
//    }
//
//    public void create(Book book) {
//        jdbcTemplate.update("INSERT INTO book(name, author, year) VALUES (?, ?, ?)",
//                book.getName(), book.getAuthor(), book.getYear());
//    }
//
//    public void delete(int id) {
//        jdbcTemplate.update("DELETE FROM book WHERE id=?", id);
//    }
}

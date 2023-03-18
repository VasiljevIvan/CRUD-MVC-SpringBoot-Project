package ru.vasiljev.springcourse.project2springboot.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.vasiljev.springcourse.project2springboot.models.Person;

import java.util.List;

@Component
public class PersonDAO {
//    private final JdbcTemplate jdbcTemplate;
//
//    @Autowired
//    public PersonDAO(JdbcTemplate jdbcTemplate) {
//        this.jdbcTemplate = jdbcTemplate;
//    }
//
//    public List<Person> readAll() {
//        return jdbcTemplate.query("SELECT * FROM person", new BeanPropertyRowMapper<>(Person.class));
//    }
//
//    public Person read(String email) {
//        return jdbcTemplate.query("SELECT * FROM person WHERE name=?",
//                new Object[]{email}, new BeanPropertyRowMapper<>(Person.class)).stream().findAny().orElse(null);
//    }
//
//    public Person read(int id) {
//        return jdbcTemplate.query("SELECT * FROM person WHERE id=?",
//                new Object[]{id}, new BeanPropertyRowMapper<>(Person.class)).stream().findAny().orElse(null);
//    }
//
//    public void update(Person person, int id) {
//        jdbcTemplate.update("UPDATE person SET name=?, year_of_birth=? WHERE id=?",
//                person.getName(), person.getYearOfBirth(), id);
//    }
//
//    public void create(Person person) {
//        jdbcTemplate.update("INSERT INTO person(name, year_of_birth) VALUES (?, ?)",
//                person.getName(), person.getYearOfBirth());
//    }
//
//    public void delete(int id) {
//        jdbcTemplate.update("DELETE FROM person WHERE id=?", id);
//    }
}
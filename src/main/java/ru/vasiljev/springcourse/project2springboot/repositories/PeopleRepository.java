package ru.vasiljev.springcourse.project2springboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.vasiljev.springcourse.project2springboot.models.Person;

@Repository
public interface PeopleRepository extends JpaRepository<Person, Integer> {
    public Person findByName(String name);
}

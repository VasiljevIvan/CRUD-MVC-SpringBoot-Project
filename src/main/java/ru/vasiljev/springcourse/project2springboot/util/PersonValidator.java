package ru.vasiljev.springcourse.project2springboot.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.vasiljev.springcourse.project2springboot.dao.PersonDAO;
import ru.vasiljev.springcourse.project2springboot.models.Person;
import ru.vasiljev.springcourse.project2springboot.services.PeopleService;

@Component
public class PersonValidator implements Validator {
    private final PeopleService peopleService;

    @Autowired
    public PersonValidator(PeopleService peopleService) {
        this.peopleService = peopleService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return Person.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Person person = (Person) target;
        if(peopleService.findByName(person.getName()) != null)
            errors.rejectValue("name","","Это имя уже используется");
    }
}

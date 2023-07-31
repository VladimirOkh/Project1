package ru.okhremenko.springcourse.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.okhremenko.springcourse.dao.PersonDAO;
import ru.okhremenko.springcourse.models.Person;

@Component
public class PersonValidator implements Validator {

    private final PersonDAO personDAO;

    @Autowired
    public PersonValidator(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    @Override //С помощью этого метода надо дать понять валидатору на каком классе он работает
    public boolean supports(Class<?> aClass) {
        return Person.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Person person = (Person) o;
        //Проверить есть ли человек с таким же Name в БД
        if (personDAO.show(person.getFullName()).isPresent()) {
            errors.rejectValue("fullName", "","Человек с таким ФИО уже зарегистрирован");
        }
    }
}

package ru.okhremenko.springcourse.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.okhremenko.springcourse.models.Person;
import ru.okhremenko.springcourse.services.PeopleService;

@Component
public class PersonValidator implements Validator {

    private final PeopleService peopleService;

    @Autowired
    public PersonValidator(PeopleService peopleService) {
        this.peopleService = peopleService;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return Person.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Person person = (Person) o;
        //Проверить есть ли человек с таким же Name в БД
//        if (peopleService.findByFullName(person.getFullName())) {
//            errors.rejectValue("fullName", "","Человек с таким ФИО уже зарегистрирован");
//        }
    }
}

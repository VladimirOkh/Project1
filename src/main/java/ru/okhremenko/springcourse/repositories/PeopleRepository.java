package ru.okhremenko.springcourse.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.okhremenko.springcourse.models.Book;
import ru.okhremenko.springcourse.models.Person;

import java.util.List;
import java.util.Optional;

@Repository
public interface PeopleRepository extends JpaRepository<Person, Integer> {

    Person findByFullName(String name);

    Optional<Person> findByBooksOwnerId(int id);

}

package ru.okhremenko.springcourse.models;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "Person")
public class Person {
    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    //@NotEmpty(message = "Name should not be empty")
    @Size(min = 2, max = 150, message = "Name should be between 2 and 150 characters")
    private String fullName;

    @Min(value = 1900, message = "Year of birth should be greater than 1900")
    private int yearOfBirth;

    @OneToMany
    private List<Book> books;

    public Person() {

    }

    public Person(String fullName, int yearOfBirth) {
        this.fullName = fullName;
        this.yearOfBirth = yearOfBirth;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", yearOfBirth=" + yearOfBirth +
                ", items=" + books +
                '}';
    }
}

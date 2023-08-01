package ru.okhremenko.springcourse.models;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

public class Book {
    private int id;

    @NotEmpty
    @Size(min = 2, max = 150, message = "Название должно быть между 2 и 150 символами")
    private String name;
    @NotEmpty
    @Size(min = 2, max = 150, message = "Имя автора должно быть между 2 и 150 символами")
    private String author;
    @NotEmpty
    @Min(value = 1500, message = "Книга должна быть написана не ранее 1500 года")
    private int year;

    public Book() {
    }


    public Book(String name, String author, int year) {
        this.name = name;
        this.author = author;
        this.year = year;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}

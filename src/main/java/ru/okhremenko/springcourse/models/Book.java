package ru.okhremenko.springcourse.models;

import javax.validation.constraints.Size;

public class Book {
    private int id;

    @Size(min = 2, max = 150, message = "Name should be between 2 and 150 characters")
    private String name;

    @Size(min = 2, max = 150, message = "Author name should be between 2 and 150 characters")
    private String author;

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

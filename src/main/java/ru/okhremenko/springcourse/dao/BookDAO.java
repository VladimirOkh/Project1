package ru.okhremenko.springcourse.dao;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.okhremenko.springcourse.models.Book;
import ru.okhremenko.springcourse.models.Person;

import java.util.List;
import java.util.Optional;

@Component
public class BookDAO {

    private final JdbcTemplate jdbcTemplate;

    public BookDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Book> index() {
        return jdbcTemplate.query("SELECT * FROM Book", new BeanPropertyRowMapper<>(Book.class));
    }

    public Book show(int id) {
        return jdbcTemplate.query("SELECT * FROM Book WHERE id=?", new Object[]{id}, new BeanPropertyRowMapper<>(Book.class))
                .stream().findAny().orElse(null);
    }

    public Optional<Book> show(String name) {
        return jdbcTemplate.query("SELECT * FROM Book WHERE name=?", new Object[]{name},
                new BeanPropertyRowMapper<>(Book.class)).stream().findAny();
    }

    public void save(Book book) {
        jdbcTemplate.update("INSERT INTO Book(name, author, year) VALUES (? ,?, ?)", book.getName(), book.getAuthor(), book.getYear());
    }

    public void update(int id, Book updatedBook) {
        jdbcTemplate.update("UPDATE Book SET name=?, author=?, year=? WHERE id=?",
                updatedBook.getName(), updatedBook.getAuthor(), updatedBook.getYear(), id);
    }

    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM Book where id=?", id);
    }

    public Optional<Person> getPersonByBookId(int id) {
        return jdbcTemplate.query("select * from person join book on person.id = Book.holder_id", new Object[]{id}, new BeanPropertyRowMapper<>(Person.class))
                .stream().findAny();
    }

    public void setBookHolder(int id, Book book) {
        jdbcTemplate.update("UPDATE Book SET holder_id=? where id=?", id, book.getId());
    }

    public void release(int id) {
        jdbcTemplate.update("UPDATE Book SET holder_id=null where id=?", id);
    }

}
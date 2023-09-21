package ru.okhremenko.springcourse.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.okhremenko.springcourse.models.Book;
import ru.okhremenko.springcourse.models.Person;
import ru.okhremenko.springcourse.repositories.BooksRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class BookService {

    private final BooksRepository booksRepository;
    @Autowired
    public BookService(BooksRepository booksRepository) {
        this.booksRepository = booksRepository;
    }

    public List<Book> findAll() {
        return booksRepository.findAll();
    }

    public List<Book> findByOwnerId(int id) {
        return booksRepository.findByOwnerId(id);
    }

    public Book findOne(int id) {
        Optional<Book> foundBook = booksRepository.findById(id);
        return foundBook.orElse(null);
    }

    public Optional<Person> getOwnerByBook(Book book) {
        return Optional.ofNullable(book.getOwner());
    }

    @Transactional
    public void save(Book book) {
        booksRepository.save(book);
    }
    @Transactional
    public void update(Book updatedBook) {
        //updatedBook.setId(id);
        booksRepository.save(updatedBook);
    }

    @Transactional
    public void release(Book updatedBook) {
        updatedBook.setOwner(null);
        booksRepository.save(updatedBook);
    }

    @Transactional
    public void setOwner(Book updatedBook, Person owner) {
        updatedBook.setOwner(owner);
        booksRepository.save(updatedBook);
    }

    @Transactional
    public void delete(int id) {
        booksRepository.deleteById(id);
    }
}

package ru.okhremenko.springcourse.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.okhremenko.springcourse.dao.BookDAO;
import ru.okhremenko.springcourse.models.Book;
import ru.okhremenko.springcourse.util.PersonValidator;

import javax.validation.Valid;

@Controller
@RequestMapping("/books")
public class BooksController {

    private final BookDAO bookDAO;
    //private final PersonValidator personValidator;
    @Autowired
    public BooksController(BookDAO bookDAO, PersonValidator personValidator) {
        this.bookDAO = bookDAO;
       // this.personValidator = personValidator;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("books", bookDAO.index());

        return "books/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id,
                       Model model) {
        model.addAttribute("book", bookDAO.show(id));
        return "books/show";
    }

    @GetMapping("/new")
    public String newBook(Model model) {
        model.addAttribute("book", new Book());
        return "books/new";
    }

    @PostMapping()                                                    //Should always be right after @Valid
    public String create(@ModelAttribute("book") @Valid Book book, BindingResult bindingResult) {
       // personValidator.validate(person, bindingResult);        //В bindingResult храним ошибки со всех валидаций
        //if (bindingResult.hasErrors())
          //  return "books/new";
        bookDAO.save(book);
        return "redirect:/books";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @ModelAttribute("id") int id) {
        model.addAttribute("book", bookDAO.show(id));
        return "books/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("book") @Valid Book book, BindingResult bindingResult, @PathVariable("id") int id) {
       // personValidator.validate(person, bindingResult);
        //  if (bindingResult.hasErrors())
          //  return "books/new";
        bookDAO.update(id, book);
        return "redirect:/books";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        bookDAO.delete(id);
        return "redirect:/books";
    }
}

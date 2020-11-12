package guru.springframework.spring5webapp.controllers;

import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LibraryController {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public LibraryController(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @RequestMapping("/authors")
    public String getAuthors(Model model) {

        model.addAttribute("authors", authorRepository.findAll());

        // Timto navratovym retezcem rikame MVC, ze chceme na ziskany model aplikovat template list z adresare books
        return "authors/list";
    }

    @RequestMapping("/books")
    public String getBooks(Model model) {

        model.addAttribute("books", bookRepository.findAll());

        // Timto navratovym retezcem rikame MVC, ze chceme na ziskany model aplikovat template list z adresare books
        return "books/list";
    }
}

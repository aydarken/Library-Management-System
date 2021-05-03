package kz.lab9.controllers;

import io.swagger.annotations.Api;
import kz.lab9.models.Book;
import kz.lab9.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
@Api(value = "Book Controller class", description = "This class allows to interact with Book object")
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @GetMapping
    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    @PostMapping
    public Book createBook(@RequestBody Book book) {
        return bookRepository.save(book);
    }

    @PutMapping
    public void updateBook(@RequestBody Long id, Book newBook) {
        bookRepository.findById(id).map(
                book -> {
                    book.setTitle(newBook.getTitle());
                    book.setCourse(newBook.getCourse());
                    book.setAuthor(newBook.getAuthor());
                    return book;
                }).orElseGet(() -> {
            newBook.setId(id);
            return bookRepository.save(newBook);
        });
    }
    @DeleteMapping
    public void deleteBook(@RequestBody Long id){
        bookRepository.deleteById(id);
    }
}
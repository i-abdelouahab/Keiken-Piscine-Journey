package org.management.library.controllers;

import org.management.library.dtos.BookDto;
import org.management.library.entities.Book;
import org.management.library.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookService bookService;

    @PostMapping
    public Book addBook(@RequestBody BookDto bookDto) {
        return bookService.addBook(bookDto);
    }

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable int id) {
        return bookService.getBookById(id);
    }

    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @PutMapping("setAvailable/{id}")
    public Book modifyBook(@PathVariable int id, @RequestBody Book book) {
        return bookService.setBookAvailable(id, book);
    }
}

package org.management.library.services;

import org.management.library.dtos.BookDto;
import org.management.library.entities.Author;
import org.management.library.entities.Book;
import org.management.library.entities.Category;
import org.management.library.repositories.AuthorRepository;
import org.management.library.repositories.BookRepository;
import org.management.library.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.io.Serializable;
import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private AuthorRepository authorRepository;

    public Book addBook(BookDto bookDto) {
        Category category = new Category(bookDto.getCategoryName());
        categoryRepository.save(category);

        Author author = new Author(bookDto.getAuthorFirstName(), bookDto.getAuthorLastName(), bookDto.getAuthorBio());
        authorRepository.save(author);

        Book book = new Book(bookDto.getBookName(), bookDto.getPages(), bookDto.getWeight(), category, author, bookDto.getIsAvailable());
        return bookRepository.save(book);
    }

    public Book getBookById(int id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Book not found with id " + id));
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book setBookAvailable(int id, Book book) {
        Book existingBook = bookRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Book not found with id " + id));
        existingBook.setIsAvailable("true");
        return bookRepository.save(existingBook);
    }
}

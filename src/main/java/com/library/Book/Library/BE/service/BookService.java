package com.library.Book.Library.BE.service;

import com.library.Book.Library.BE.controller.ResourceNotFoundException;
import com.library.Book.Library.BE.entity.Book;
import com.library.Book.Library.BE.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Optional<Book> getBookById(Long id) {
        return bookRepository.findById(id);
    }

    public Book createBook(Book book) {
        return bookRepository.save(book);
    }

    public Book updateBook(Long id, Book updatedBook) {
        Optional<Book> existingBook = bookRepository.findById(id);
        if (existingBook.isPresent()) {
            updatedBook.setId(id); // Ensure the ID is set for the existing book
            return bookRepository.save(updatedBook);
        } else {
            throw new ResourceNotFoundException("Book not found with id " + id,
                    "Book not found in database",
                    null);
        }
    }

    public void deleteBook(Long id) {
        Optional<Book> book = bookRepository.findById(id);
        if (book.isPresent()) {
            bookRepository.deleteById(id);
        } else {
            throw new ResourceNotFoundException("Book not found with id " + id,
                    "Book not found in database",
                    null);
        }
    }
}

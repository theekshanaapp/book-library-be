package com.library.Book.Library.BE.service;

import com.library.Book.Library.BE.controller.ResourceNotFoundException;
import com.library.Book.Library.BE.entity.Author;
import com.library.Book.Library.BE.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    public Optional<Author> getAuthorById(Long id) {
        return authorRepository.findById(id);
    }

    public Author createAuthor(Author author) {
        return authorRepository.save(author);
    }

    public Author updateAuthor(Long id, Author updatedAuthor) {
        Optional<Author> existingAuthor = authorRepository.findById(id);
        if (existingAuthor.isPresent()) {
            updatedAuthor.setId(id); // Ensure the ID is set for the existing author
            return authorRepository.save(updatedAuthor);
        } else {
            throw new ResourceNotFoundException("Author not found with id " + id,
                    "Author not found in database",
                    null);
        }
    }

    public void deleteAuthor(Long id) {
        authorRepository.deleteById(id);
    }
}

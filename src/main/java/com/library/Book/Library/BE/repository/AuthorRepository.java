package com.library.Book.Library.BE.repository;

import com.library.Book.Library.BE.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
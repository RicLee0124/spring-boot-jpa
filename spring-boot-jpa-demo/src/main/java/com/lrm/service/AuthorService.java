package com.lrm.service;

import com.lrm.domain.Author;

import java.util.Optional;

public interface AuthorService {

    Author saveAuthor(Author author);

    Author updateAuthor(Author author);

    Optional<Author> findAuthor(Long id);

    void deleteAuthor(Long id);
}

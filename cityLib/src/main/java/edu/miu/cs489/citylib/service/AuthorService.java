package edu.miu.cs489.citylib.service;

import edu.miu.cs489.citylib.model.Author;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface AuthorService {
    Optional<Author> addNewAuthor(Author author);
}

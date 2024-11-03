package edu.miu.cs489.citylib.service.implementation;

import edu.miu.cs489.citylib.model.Author;
import edu.miu.cs489.citylib.repository.AuthorRepository;
import edu.miu.cs489.citylib.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository authorRepository;
    @Override
    public Optional<Author> addNewAuthor(Author author) {
        Author newAuthor = authorRepository.save(author);
        return Optional.of(newAuthor);
    }
}

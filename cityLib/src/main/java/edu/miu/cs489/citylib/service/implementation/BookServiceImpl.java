package edu.miu.cs489.citylib.service.implementation;

import edu.miu.cs489.citylib.model.Book;
import edu.miu.cs489.citylib.repository.BookRepository;
import edu.miu.cs489.citylib.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    @Override
    public Optional<Book> addNewBook(Book book) {
        Book newBook = bookRepository.save(book);
        return Optional.of(newBook);
    }

    @Override
    public Optional<Book> findBookByISBN(String ISBN) {
        return bookRepository.findBookByISBN(ISBN);
    }
}

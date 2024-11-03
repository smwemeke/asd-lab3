package edu.miu.cs489.citylib.service;

import edu.miu.cs489.citylib.model.Book;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface BookService {
    Optional<Book> addNewBook(Book book);
    Optional<Book> findBookByISBN(String ISBN);
}

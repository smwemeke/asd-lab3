package edu.miu.cs489.citylib.repository;

import edu.miu.cs489.citylib.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Integer> {
    Optional<Book> findBookByISBN(String ISBN);
}

package edu.miu.cs489.citylib;

import edu.miu.cs489.citylib.model.Address;
import edu.miu.cs489.citylib.model.Author;
import edu.miu.cs489.citylib.model.Book;
import edu.miu.cs489.citylib.model.Publisher;
import edu.miu.cs489.citylib.repository.PublisherRepository;
import edu.miu.cs489.citylib.service.AddressService;
import edu.miu.cs489.citylib.service.AuthorService;
import edu.miu.cs489.citylib.service.BookService;
import edu.miu.cs489.citylib.service.PublisherService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
@RequiredArgsConstructor
public class CityLibApplication {

    private final PublisherService publisherService;
    private final AuthorService authorService;
    private final BookService bookService;
    private final AddressService addressService;

    public static void main(String[] args) {
        SpringApplication.run(CityLibApplication.class, args);}

        @Bean
        CommandLineRunner commandLineRunner() {
            return args -> {

                Address address1 = new Address("146E", "Draper", "UT", 84020);
                Publisher publisher1 = new Publisher();
                publisher1.setPublisherName("Apres");
                publisher1.setPrimaryAddress(address1);
                publisherService.addNewPublisher(publisher1);

                // Create Address Object
                addressService.addNewAddress(address1);

                // 1. Create Books
                Book book1 = new Book("Java1");
                Book book2 = new Book("Microservices");
                book1.setISBN("123567");
                book2.setISBN("6979585");

                // 2. Set exisiting publisher for newly created books
                publisherService.findByPublisherName("Apres")
                        .ifPresent(
                                publisher -> {
                                    book1.setPublisher(publisher);
                                }
                        );
                publisherService.findByPublisherName("Apres")
                        .ifPresent(
                                publisher -> {
                                    book2.setPublisher(publisher);
                                }
                        );

                //3. Create a few authors
                List<Author> authors = List.of(
                        new Author("Damien", "Kato"),
                        new Author("Sue", "Mwemeke"),
                        new Author("Alvin", "Murungi"),
                        new Author("Aaron", "Ddembe")

                );
                // 4. Save Authors
                for (Author author : authors) {
                    authorService.addNewAuthor(author);
                }

                // 5. Set multiple authors for every book
                book1.setAuthors(authors);
                book2.setAuthors(authors);

               // book2.getAuthors().add(authorList.get(3));

                // 6. Save Book
                bookService.addNewBook(book1);
                bookService.addNewBook(book2);

                //7.  Print book with title, isbn, authors, publisher details
               bookService.findBookByISBN("123567").ifPresent(System.out ::println);

            };
        }
    }

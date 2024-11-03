package edu.miu.cs489.citylib;

import edu.miu.cs489.citylib.model.Address;
import edu.miu.cs489.citylib.model.Author;
import edu.miu.cs489.citylib.model.Book;
import edu.miu.cs489.citylib.model.Publisher;
import edu.miu.cs489.citylib.repository.PublisherRepository;
import edu.miu.cs489.citylib.service.AuthorService;
import edu.miu.cs489.citylib.service.BookService;
import edu.miu.cs489.citylib.service.PublisherService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@RequiredArgsConstructor
public class CityLibApplication {

    private final PublisherService publisherService;
    private final AuthorService authorService;
    private final BookService bookService;

    public static void main(String[] args) {
        SpringApplication.run(CityLibApplication.class, args);}

        @Bean
        CommandLineRunner commandLineRunner() {
            return args -> {
//                // Create Publisher Object
//                Publisher publisher = new Publisher();
//                publisher.setPublisherName("Apres");
//
//                // Create Address Object
//                Address address = new Address("146 E", "Draper", "UT", 84020);
//
//                // Set address in publisher
//                publisher.setPrimaryAddress(address);
//                Publisher savedPublisher = publisherRepository.save(publisher);
//                System.out.println(savedPublisher + "is saved");
//
//                // Find publisher by name
//                publisherRepository.findByPublisherName("Apres").ifPresent(
//                        publisher1 -> {
//                            System.out.println("Publisher " + publisher1.getPublisherName() + "is found.");
//                        }
//                );
//                // Delete Publisher
//            };
                // Create Books
                Book book1 = new Book("Java1");
                Book book2 = new Book("Microservices");
                book1.setISBN("123567");
                book2.setISBN("6979585");

                // Set exisiting publisher for newly created books
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

                // Create a few authors
                List<Author> authorList = List.of(
                        new Author("Damien", "Kato"),
                        new Author("Sue", "Mwemeke"),
                        new Author("Alvin", "Murungi"),
                        new Author("Aaron", "Ddembe")

                );
                // Save Authors
                for (Author author : authorList) {
                    authorService.addNewAuthor(author);
                }

                // Set multiple authors for every book
                book1.getAuthors().add(authorList.get(0));
                book1.getAuthors().add(authorList.get(1));

                book2.getAuthors().add(authorList.get(2));
                book2.getAuthors().add(authorList.get(3));

                // Save Book
                bookService.addNewBook(book1);
                bookService.addNewBook(book2);


                // Print book
                bookService.findBookByISBN("123567").ifPresent(System.out ::println);

            };
        }
    }

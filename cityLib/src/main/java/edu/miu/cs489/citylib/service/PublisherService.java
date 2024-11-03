package edu.miu.cs489.citylib.service;

import edu.miu.cs489.citylib.model.Address;
import edu.miu.cs489.citylib.model.Publisher;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface PublisherService {
       Optional<Publisher> addNewPublisher(Publisher publisher);
       Optional<Publisher> findByPublisherName(String publisherName);
       Optional<Publisher> modifyPublisher(String publisherName, Publisher publisher);
       void deletePublisher(Publisher publisher);

       Optional<Publisher> modifyPublisherName(String existingPublisherName, String newPublisherName);
       Optional<Publisher>modifyPublisherAddress(String existingPublisherName, Address newAdress);
}


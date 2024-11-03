package edu.miu.cs489.citylib.service.implementation;

import edu.miu.cs489.citylib.model.Address;
import edu.miu.cs489.citylib.model.Publisher;
import edu.miu.cs489.citylib.repository.PublisherRepository;
import edu.miu.cs489.citylib.service.PublisherService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PublisherServiceImpl implements PublisherService {

    private final PublisherRepository publisherRepository;

    @Override
    public Optional<Publisher> addNewPublisher(Publisher publisher) {
        Publisher newPublisher = publisherRepository.save(publisher);
        return Optional.of(newPublisher);
    }

    @Override
    public Optional<Publisher> findByPublisherName(String publisherName) {
        return publisherRepository.findByPublisherName(publisherName);
    }
    @Override
    public Optional<Publisher> modifyPublisher(String publisherName, Publisher publisher) {
        return Optional.empty();
    }
    @Override
    public void deletePublisher(Publisher publisher) {
        publisherRepository.delete(publisher);
    }
    @Override
    public Optional<Publisher> modifyPublisherName(String existingPublisherName, String newPublisherName) {
        return Optional.empty();
    }

    @Override
    public Optional<Publisher> modifyPublisherAddress(String existingPublisherName, Address newAdress) {
        return Optional.empty();
    }
}

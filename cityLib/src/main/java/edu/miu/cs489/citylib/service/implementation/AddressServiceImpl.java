package edu.miu.cs489.citylib.service.implementation;

import edu.miu.cs489.citylib.model.Address;
import edu.miu.cs489.citylib.model.Publisher;
import edu.miu.cs489.citylib.repository.AddressRepository;
import edu.miu.cs489.citylib.service.AddressService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;


    @Override
    public Optional<Address> addNewAddress(Address address) {
        Address newAddress = addressRepository.save(address);
        return Optional.of(newAddress);
    }
}

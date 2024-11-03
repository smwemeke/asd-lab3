package edu.miu.cs489.citylib.service;

import edu.miu.cs489.citylib.model.Address;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface AddressService {
    Optional<Address> addNewAddress(Address address);
}

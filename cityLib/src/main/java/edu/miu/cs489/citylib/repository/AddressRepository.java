package edu.miu.cs489.citylib.repository;

import edu.miu.cs489.citylib.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;




public interface AddressRepository  extends JpaRepository<Address, Integer> {
}

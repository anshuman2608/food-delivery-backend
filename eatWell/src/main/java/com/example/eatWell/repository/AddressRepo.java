package com.example.eatWell.repository;

import com.example.eatWell.model.Address;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AddressRepo extends MongoRepository<Address, String> {




   Address findByPhoneNumber(String mobileNumber);

    List<Address> findByPincode(Integer pincode);

    List<Address> findByCountry(String country);

    void deleteByAddressId(String id);
}

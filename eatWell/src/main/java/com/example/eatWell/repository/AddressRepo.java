package com.example.eatWell.repository;

import com.example.eatWell.model.Address;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AddressRepo extends MongoRepository<Address, String> {




   //Address findByPhoneNumber(String phoneNumber);

   List<Address> findByPhoneNumber(String phoneNumber);

    Page<Address> findByPincode(String pincode, Pageable pageable);

    List<Address> findByCountry(String country);

    void deleteByAddressId(String id);
}

package com.example.eatWell.repository;

import com.example.eatWell.model.Driver;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DriverRepo extends MongoRepository<Driver ,String> {

      //Driver findByName(String name);

      Driver findByPhoneNumber(String phoneNumber);

      List<Driver> findByName(String name);

      List<Driver>  findByLocation(String location);

}

package com.example.eatWell.repository;

import com.example.eatWell.model.Driver;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DriverRepo extends MongoRepository<Driver ,String> {

}

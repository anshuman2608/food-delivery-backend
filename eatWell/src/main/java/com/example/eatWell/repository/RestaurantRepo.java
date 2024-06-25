package com.example.eatWell.repository;

import com.example.eatWell.model.Restaurant;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantRepo extends MongoRepository<Restaurant,String> {
}

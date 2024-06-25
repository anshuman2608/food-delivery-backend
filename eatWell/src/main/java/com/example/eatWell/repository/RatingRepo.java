package com.example.eatWell.repository;

import com.example.eatWell.model.Rating;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RatingRepo extends MongoRepository<Rating,String> {
}

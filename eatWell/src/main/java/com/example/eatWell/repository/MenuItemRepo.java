package com.example.eatWell.repository;

import com.example.eatWell.model.MenuItem;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuItemRepo extends MongoRepository<MenuItem, String> {
}

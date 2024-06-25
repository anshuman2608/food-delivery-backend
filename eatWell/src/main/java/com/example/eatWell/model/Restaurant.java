package com.example.eatWell.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "Restaurants")
public class Restaurant {

    @Id
    private String restaurantId;
    private String name;
    private String address;
    private String phone;


    // Constructors, getters, setters
}

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
@Document(collection = "Payment")
public class Payment {

    @Id
    private String id;

    private Order order;
    private String paymentMethod;
    private double amount;
    private String status;

    // Constructors, getters, setters
}
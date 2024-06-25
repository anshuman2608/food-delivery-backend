package com.example.eatWell.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;



@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "Orders")
public class Order {

    @Id
    private String id;
    private User user;
    private Restaurant restaurant;
    private List<MenuItem> menuItems;
    private double orderTotal;
    private String deliveryStatus;



}

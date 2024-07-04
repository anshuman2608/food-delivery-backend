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
@Document(collection = "Drivers")
public class Driver {

    @Id
    private String id;

    private String name;
    private String phoneNumber;
    private String location;
    private long createTime;
    private long updateTime;


    public Driver(String name,String phoneNumber,String location){
        this.name=name;
        this.phoneNumber=phoneNumber;
        this.location=location;
        this.createTime=System.currentTimeMillis();
        this.updateTime=System.currentTimeMillis();

    }
}

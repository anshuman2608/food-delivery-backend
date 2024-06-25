package com.example.eatWell.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "Address")
public class Address {

    @Id
    private String addressId;
    private String phoneNumber;
    private String addressLine1;
    private String addressLine2;
    private String city;
    private String state;
    private String country;
    private Integer pincode;
    private Long createTime;
    private Long updateTime;

    public Address(String phoneNumber, String addressLine1, String addressLine2, String city,
                   String state, String country, Integer pincode) {
        this.phoneNumber = phoneNumber;
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.city = city;
        this.state = state;
        this.country = country;
        this.pincode = pincode;
        this.createTime=System.currentTimeMillis();
        this.updateTime=System.currentTimeMillis();
    }


}

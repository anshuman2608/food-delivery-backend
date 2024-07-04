package com.example.eatWell.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DriverResponse {



    private String id;
    private String name;
    private String phoneNumber;
    private String location;
    private long createTime;
    private long updateTime;

}

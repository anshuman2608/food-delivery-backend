package com.example.eatWell.service;

import com.example.eatWell.dto.request.DriverCreateRequest;
import com.example.eatWell.model.Driver;
import com.example.eatWell.repository.DriverRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;


@Service
public class DriverService {

    @Autowired
    DriverRepo driverRepo;


    public void  saveDriver(String name, String phoneNumber, String location){

        driverRepo.save(new Driver(name,phoneNumber,location));

    }


    public String saveAllDriver(List<Driver> driverList){
        driverRepo.saveAll(driverList);
        return "all driver saved successfully";
    }

}

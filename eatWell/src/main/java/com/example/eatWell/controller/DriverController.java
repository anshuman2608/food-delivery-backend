package com.example.eatWell.controller;


import com.example.eatWell.model.Driver;
import com.example.eatWell.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("driver")
public class DriverController {

    @Autowired
    DriverService driverService;

    @PostMapping("/save")
    public String saveDriver(@RequestBody Driver driver){

        driverService.saveDriver(driver);
        return "driver saved";
    }

    @PostMapping("/saveAll")
    public String saveAllDriver(@RequestBody List<Driver> driverList){

        driverService.saveAllDriver(driverList);
        return "driver saved";
    }
}

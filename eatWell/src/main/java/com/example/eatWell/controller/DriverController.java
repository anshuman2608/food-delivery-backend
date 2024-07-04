package com.example.eatWell.controller;


import com.example.eatWell.dto.request.DriverCreateRequest;
import com.example.eatWell.dto.response.ResponseDTO;
import com.example.eatWell.exception.NoAddressFoundException;
import com.example.eatWell.model.Driver;
import com.example.eatWell.service.DriverService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("driver")
public class DriverController {

    @Autowired
    DriverService driverService;

    @PostMapping("/save")
    public ResponseEntity<ResponseDTO<?>> saveDriver(@Valid @RequestBody DriverCreateRequest driverCreateRequest){
        try {
            driverService.saveDriver(driverCreateRequest.getName(),driverCreateRequest.getPhoneNumber(),driverCreateRequest.getLocation());
            return ResponseEntity.status(HttpStatus.OK).body(ResponseDTO.builder().status(HttpStatus.OK.toString())
                    .body("Driver saved successfully").build());
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(ResponseDTO.builder().status(HttpStatus.CONFLICT.toString())
                    .body(e.getMessage()).build());
        }

    }

    @PostMapping("/saveAll")
    public ResponseEntity<ResponseDTO<?>> saveAllDriver(@RequestBody List<Driver> driverList){

        try {
            return ResponseEntity.status(HttpStatus.OK).body(ResponseDTO.builder().status(HttpStatus.OK.toString())
                    .body(driverService.saveAllDriver(driverList)).build());

        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(ResponseDTO.builder().status(HttpStatus.CONFLICT.toString())
                    .body(e.getMessage()).build());
        }
    }


//    @GetMapping("/list")
//    public ResponseEntity<com.example.eatWell.dto.ResponseDTO<?>> getAllAddress(Pageable pageable){
//        try {
//            return ResponseEntity.status(HttpStatus.OK).body(com.example.eatWell.dto.ResponseDTO.builder().status(HttpStatus.OK.toString())
//                    .body(driverService.getAllAddress(pageable)).build());
//        }catch (NoAddressFoundException e){
//            return ResponseEntity.status(HttpStatus.CONFLICT).body(com.example.eatWell.dto.ResponseDTO.builder().status(HttpStatus.CONFLICT.toString())
//                    .body(e.getMessage()).build());
//        }
//    }



}

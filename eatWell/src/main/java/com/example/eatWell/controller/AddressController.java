package com.example.eatWell.controller;


import com.example.eatWell.dto.ResponseDTO;
import com.example.eatWell.dto.request.AddressCreateRequest;
import com.example.eatWell.dto.response.AddressResponse;
import com.example.eatWell.exception.NoAddressFoundException;
import com.example.eatWell.model.Address;
import com.example.eatWell.service.AddressService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressController {


    @Autowired
    AddressService addressService;


    @PostMapping("/save")
    public ResponseEntity<ResponseDTO<?>>  saveAddress(@Valid @RequestBody AddressCreateRequest addressCreateRequest){
        try {
            addressService.saveAddress(addressCreateRequest.getPhoneNumber(),addressCreateRequest.getAddressLine1()
                    ,addressCreateRequest.getAddressLine2(), addressCreateRequest.getCity(), addressCreateRequest.getState(),
                    addressCreateRequest.getCountry(),addressCreateRequest.getPincode());
            return ResponseEntity.status(HttpStatus.OK).body(ResponseDTO.builder().status(HttpStatus.OK.toString()).
                    body("Address saved successfully").build());

        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(ResponseDTO.builder().status(HttpStatus.CONFLICT.toString())
                    .body(e.getMessage()).build());
        }

    }

    @PostMapping("/saveAll")
    public ResponseEntity<ResponseDTO<?>>  saveAllAddress(@RequestBody List<Address> addressList){
        try{
            addressService.saveAllAddress(addressList);
            return ResponseEntity.status(HttpStatus.OK).body(ResponseDTO.builder().status(HttpStatus.OK.toString()).
                    body("All address saved successfully").build());

        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(ResponseDTO.builder().status(HttpStatus.CONFLICT.toString())
                    .body(e.getMessage()).build());
        }

    }

    @GetMapping("/list")
    public ResponseEntity<ResponseDTO<?>> getAllAddress(Pageable pageable){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(ResponseDTO.builder().status(HttpStatus.OK.toString())
                    .body(addressService.getAllAddress(pageable)).build());
        }catch (NoAddressFoundException e){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(ResponseDTO.builder().status(HttpStatus.CONFLICT.toString())
                    .body(e.getMessage()).build());
        }
    }

    @GetMapping("/phoneNumber")
    public ResponseEntity<ResponseDTO<?>> getAddressByMobileNumber(@RequestParam String phoneNumber){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(ResponseDTO.builder().status(HttpStatus.OK.toString())
                    .body(addressService.getAddressByPhoneNumber(phoneNumber)).build());

        } catch(NoAddressFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ResponseDTO.builder().status(HttpStatus.NOT_FOUND.toString())
                    .body(e.getMessage()).build());
        }



    }
    @GetMapping("/pincode")
    public ResponseEntity<ResponseDTO<?>>  getAddressByPincode(@RequestParam String pincode,Pageable pageable){
        try {
            //return addressService.getAddressByPindoce(pincode);
            return ResponseEntity.status(HttpStatus.OK).body(ResponseDTO.builder().status(HttpStatus.OK.toString())
                    .body(addressService.getAddressByPincode(pincode,pageable)).build());

        }catch (NoAddressFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ResponseDTO.builder().status(HttpStatus.NOT_FOUND.toString())
                    .body(e.getMessage()).build());
        }

    }


}

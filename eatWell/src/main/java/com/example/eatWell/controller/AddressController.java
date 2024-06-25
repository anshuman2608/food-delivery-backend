package com.example.eatWell.controller;


import com.example.eatWell.exception.NoAddressFoundException;
import com.example.eatWell.model.Address;
import com.example.eatWell.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public String  saveAddress(@RequestBody Address address){

        addressService.saveAddress(address);
        return "success";
        //return new ResponseEntity<>("address saved successfully", HttpStatus.OK);
    }

    @PostMapping("/saveAll")
    public String  saveAllAddress(@RequestBody List<Address> addressList){

        addressService.saveAllAddress(addressList);
        return "success";
        //return new ResponseEntity<>("address saved successfully", HttpStatus.OK);
    }
    @GetMapping("/all")
    public ResponseEntity<?> getAllAddress(){
        List<Address> addresses = addressService.getAllAddress();
        return new ResponseEntity<>(addresses,HttpStatus.OK);
    }








//    @GetMapping("/pincode")
//    public List<Address>  getAddressByPincode(int pincode){
//        try {
//
//        }catch (Exception e){
//            return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
//        }
//    }


}

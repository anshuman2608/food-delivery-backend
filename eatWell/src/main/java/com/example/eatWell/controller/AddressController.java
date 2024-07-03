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
    public String  saveAddress(@Valid @RequestBody AddressCreateRequest addressCreateRequest){

        addressService.saveAddress(addressCreateRequest.getPhoneNumber(),addressCreateRequest.getAddressLine1()
        ,addressCreateRequest.getAddressLine2(), addressCreateRequest.getCity(), addressCreateRequest.getState(),
                addressCreateRequest.getCountry(),addressCreateRequest.getPincode());
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
//    return ResponseEntity.status(HttpStatus.OK).body(ResponseDTO.builder().status(HttpStatus.OK.toString())
//            .body(merchantService.merchantList(pageable)).build());
    @GetMapping("/list")
    public ResponseEntity<ResponseDTO<?>> getAllAddress1(Pageable pageable){
        return ResponseEntity.status(HttpStatus.OK).body(ResponseDTO.builder().status(HttpStatus.OK.toString())
                .body(addressService.getAllAddress(pageable)).build());

    }

    @GetMapping("/mobileNumber")
    public AddressResponse getAddressByMobileNumber(@RequestParam String mobileNumber)throws NoAddressFoundException{
        AddressResponse addressResponse = addressService.getAddressByPhoneNumber(mobileNumber);
        if(addressResponse==null){
            throw new NoAddressFoundException();
        }

        return addressResponse;
    }








    @GetMapping("/pincode")
    public List<Address>  getAddressByPincode(@RequestParam int pincode){
        return addressService.getAddressByPindoce(pincode);
    }


}

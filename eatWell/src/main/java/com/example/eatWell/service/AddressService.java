package com.example.eatWell.service;


import com.example.eatWell.model.Address;
import com.example.eatWell.repository.AddressRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {

    @Autowired
    private MongoTemplate mongoTemplate;


    @Autowired
    private AddressRepo addressRepo;


    public void saveAddress(Address address){

        addressRepo.save(address);

    }

    public void saveAllAddress(List<Address> addressList){
        addressRepo.saveAll(addressList);

    }

    public List<Address> getAllAddress(){
        return addressRepo.findAll();
    }


    //Some uses of regix and mongo template

    public List<Address> getAddressByPindoce(int pincode){
        Query query=new Query();
        query.addCriteria(Criteria.where("pincode").is(pincode));
        return mongoTemplate.find(query,Address.class);
    }


}

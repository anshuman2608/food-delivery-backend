package com.example.eatWell.service;


import com.example.eatWell.dto.response.AddressResponse;
import com.example.eatWell.exception.NoAddressFoundException;
import com.example.eatWell.model.Address;
import com.example.eatWell.repository.AddressRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.support.PageableExecutionUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AddressService {

    @Autowired
    private MongoTemplate mongoTemplate;


    @Autowired
    private AddressRepo addressRepo;


    public void saveAddress(String phoneNumber,String addressLine1, String addressLine2,
                            String city, String state, String country, String pincode){

        addressRepo.save(new Address(phoneNumber,addressLine1,addressLine2,city,state,country,pincode));

    }

    public void saveAllAddress(List<Address> addressList){
        addressRepo.saveAll(addressList);

    }

    public Page<AddressResponse> getAllAddress(Pageable pageable){
        Sort sort=Sort.by(Sort.Direction.DESC, "Country");
        pageable=PageRequest.of(pageable.getPageNumber(),pageable.getPageSize(), sort);
        Page<Address> allAddress= addressRepo.findAll(pageable);
        List<AddressResponse> addressResponsesList= new ArrayList<>();

        allAddress.forEach(address -> {
            addressResponsesList.add(new AddressResponse(address.getAddressId(),address.getPhoneNumber(), address.getAddressLine1()
            ,address.getAddressLine2(),address.getCity(),address.getState(),address.getCountry(),address.getPincode()));
        });

        return PageableExecutionUtils.getPage(addressResponsesList,allAddress.getPageable(),allAddress::getTotalElements);
    }


    //Some uses of regix and mongo template
    public AddressResponse getAddressByPhoneNumber(String phoneNumber) throws NoAddressFoundException {
          Address address= addressRepo.findByPhoneNumber(phoneNumber);
          return new AddressResponse(address.getAddressId(),address.getPhoneNumber(),address.getAddressLine1(),
                  address.getAddressLine2(),address.getCity(),address.getState(),address.getCountry(),address.getPincode());
    }






    public List<Address> getAddressByPindoce(int pincode){
        Query query=new Query();
        query.addCriteria(Criteria.where("pincode").is(pincode));
        return mongoTemplate.find(query,Address.class);
    }


}

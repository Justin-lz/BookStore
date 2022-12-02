package org.bsm.bsm.service;


import org.bsm.bsm.entity.Address;
import org.bsm.bsm.entity.UserInfo;
import org.bsm.bsm.mapper.AddressMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceIml implements AddressService{

    @Autowired
    private AddressMapper addressMapper;

    @Override
    public List<Address> getUserAddress(UserInfo userInfo) {
        return addressMapper.getUserAddress(userInfo);
    }

    @Override
    public Integer newUserAddress(UserInfo userInfo,String Aaddress,String Areceiver,String Aphone) {
        Address address = new Address();
        address.setAaddress(Aaddress);
        address.setUid(userInfo.getUid());
        address.setAphone(Aphone);
        address.setAreceiver(Areceiver);
        return addressMapper.newUserAddress(address);
    }
}

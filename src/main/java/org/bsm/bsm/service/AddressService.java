package org.bsm.bsm.service;

import org.bsm.bsm.entity.Address;
import org.bsm.bsm.entity.UserInfo;

import java.util.List;

public interface AddressService {
    List<Address> getUserAddress(UserInfo userInfo);
    Integer newUserAddress(UserInfo userInfo,String Aaddress,String Areceiver,String Aphone);
}

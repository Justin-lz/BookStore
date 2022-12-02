package org.bsm.bsm.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.bsm.bsm.entity.Address;
import org.bsm.bsm.entity.UserInfo;

import java.util.List;

@Mapper
public interface AddressMapper {

    @Select("Select * From bsm.address where (Uid = #{Uid}) order by Aid")
    List<Address> getUserAddress(UserInfo userInfo);

    @Insert("INSERT INTO bsm.address (`Uid`, `Aaddress`, `Areceiver`, `Aphone`) VALUES (#{Uid}, #{Aaddress}, #{Areceiver}, #{Aphone});")
    Integer newUserAddress(Address address);

}

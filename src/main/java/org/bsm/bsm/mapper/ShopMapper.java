package org.bsm.bsm.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.bsm.bsm.entity.Shop;

import java.util.List;


@Mapper
public interface ShopMapper{

    @Insert("INSERT INTO bsm.shop (`Bid`, `Uid`,`Scount`) VALUES (#{Bid}, #{Uid},#{Scount});")
    public Integer newShop(Shop shop);

    @Select("Select * from bsm.shop where (Uid = #{Uid})")
    public List<Shop> allShopByUid(String Uid);

    @Select("Select * from bsm.shop where (Uid = #{Uid} and Bid = #{Bid})")
    public Shop checkUidBid(Shop shop);

    @Update("Update bsm.shop set Scount = #{Scount} where (Uid = #{Uid} and Bid = #{Bid})")
    public Integer changeShop(Shop shop);

}
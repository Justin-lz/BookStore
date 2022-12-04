package org.bsm.bsm.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.bsm.bsm.entity.Discount;

import java.util.List;

public class DiscountMapper{

    @Select("Select * from bsm.discount")
    public List<Discount> getAll();

    @Insert("INSERT INTO `bsm`.`book` (`Did`, `Dcount`, `Dprice`, `Ddis`, `Ddec`, `Dstart`, `Dend`) VALUES (#{Did}, #{Dcount}, #{Dprice},#{Ddis},#{Ddec},#{Dstart},#{Dend});")
    Integer insertDiscount(Discount discount);

}
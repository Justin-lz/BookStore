package org.bsm.bsm.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.bsm.bsm.entity.Type;

import java.util.List;
@Mapper
public interface TypeMapper {

    @Select("SELECT * FROM bsm.type;")
    public List<Type> getAllType();

    @Insert("INSERT INTO bsm.type (`Tname`, `Tresume`) VALUES (#{Tname}, #{Tresume});")
    public Integer newType(Type type);


}

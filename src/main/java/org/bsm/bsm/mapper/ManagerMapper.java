package org.bsm.bsm.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.bsm.bsm.entity.Manager;

@Mapper
public interface ManagerMapper {

    @Select("Select * from bsm.manager where Mauthority = #{Mauthority} and Mpassword = #{Mpassword}")
    Manager login(Manager manager);
}

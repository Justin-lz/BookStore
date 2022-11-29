package org.bsm.bsm.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.bsm.bsm.entity.UserInfo;

@Mapper
public interface UserInfoMapper {
    @Select("SELECT * FROM bsm.user where (Uid = #{Uid});")
    public UserInfo getUserInfo(Integer Uid);


}

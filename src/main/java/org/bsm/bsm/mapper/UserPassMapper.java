package org.bsm.bsm.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.bsm.bsm.entity.UserPass;

@Mapper
public interface UserPassMapper {
    @Select("SELECT * FROM bsm.user_log_in  where (Uname = #{Uname} and UPword = #{UPword});")
    UserPass checkUserPass(UserPass userPass);

    @Insert("INSERT INTO bsm.user_log_in (`UPword`, `Uname`) VALUES (#{UPword},#{Uname});")
    Integer registerUserPass(UserPass userPass);

    @Select("SELECT * FROM bsm.user_log_in  where (Uname = #{Uname});")
    UserPass checkUserUnique(UserPass userPass);
}

package org.bsm.bsm.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.bsm.bsm.entity.Message;

import java.util.List;

@Mapper
public interface MessageShowMapper {

    @Select("SELECT * FROM bsm.message_show where Mread = 'yes' order by Mtime desc limit 0,2;")
    public List<Message> getMessageHome();

    @Select("SELECT * FROM bsm.message_show where Mread = 'yes' order by Mtime desc limit ${page},6;")
    public List<Message> getMessagePage(@Param("page") Integer page);

    @Insert("INSERT INTO bsm.message (`Uid`, `Mword`, `Mtime`, `Mread`) VALUES (#{Uid},#{Mword},now(),'no');")
    public Integer newMessage(Message message);
}

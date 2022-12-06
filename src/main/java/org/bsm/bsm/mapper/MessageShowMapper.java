package org.bsm.bsm.mapper;

import org.apache.ibatis.annotations.*;
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

    @Select("SELECT * FROM bsm.message_show where Mread = 'no' order by Mtime desc limit ${page},6;")
    public List<Message> getMessagePageManager(@Param("page") Integer page);

    @Update("Update bsm.message set Mread = 'yes' where Mid =#{Mid}")
    public Integer checkMessageManager(Integer Mid);

    @Delete("delete from bsm.message where Mid = #{Mid}")
    public Integer deleteMessageManager(Integer Mid);
}

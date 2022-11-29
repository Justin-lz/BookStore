package org.bsm.bsm.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.bsm.bsm.entity.Message;

import java.util.List;

@Mapper
public interface MessageShowMapper {

    @Select("SELECT * FROM bsm.message_show where Mread = 'yes' order by Mtime desc limit 0,20;")
    public List<Message> getMessageHome();
}

package org.bsm.bsm.service;

import org.apache.ibatis.annotations.Param;
import org.bsm.bsm.entity.Message;

import java.util.List;

public interface MessageService {

    public List<Message> getMessageHome();
    public List<Message> getMessagePage(Integer page);
    public Integer newMessage(Integer uid,String Mword);
    public Integer checkMessageManager(Integer Mid);
    public List<Message> getMessagePageManager(@Param("page") Integer page);
    public Integer deleteMessageManager(Integer Mid);
}

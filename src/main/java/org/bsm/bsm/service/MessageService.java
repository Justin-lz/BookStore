package org.bsm.bsm.service;

import org.bsm.bsm.entity.Message;

import java.util.List;

public interface MessageService {

    public List<Message> getMessageHome();
    public List<Message> getMessagePage(Integer page);
    public Integer newMessage(Integer uid,String Mword);
}

package org.bsm.bsm.service;

import org.bsm.bsm.entity.Message;
import org.bsm.bsm.mapper.MessageShowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

@Service
public class MessageServiceIml implements MessageService{
    @Autowired
    private MessageShowMapper messageShowMapper;

    @Override
    public List<Message> getMessageHome() {
        return messageShowMapper.getMessageHome();
    }

    public List<Message> getMessagePage(Integer page){
        return messageShowMapper.getMessagePage((page-1)*6);
    }

    @Override
    public Integer newMessage(Integer uid,String Mword) {
        Message message = new Message();
        message.setUid(uid);
        message.setMword(Mword);
        return messageShowMapper.newMessage(message);
    }


}

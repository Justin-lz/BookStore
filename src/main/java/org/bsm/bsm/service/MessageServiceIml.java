package org.bsm.bsm.service;

import org.bsm.bsm.entity.Message;
import org.bsm.bsm.mapper.MessageShowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageServiceIml implements MessageService{
    @Autowired
    private MessageShowMapper messageShowMapper;

    @Override
    public List<Message> getMessageHome() {
        return messageShowMapper.getMessageHome();
    }
}

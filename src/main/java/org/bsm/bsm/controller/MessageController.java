package org.bsm.bsm.controller;

import com.google.gson.GsonBuilder;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Mapper;
import org.bsm.bsm.service.MessageService;
import org.bsm.bsm.service.MessageServiceIml;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("BSM/Message")
@Api("获取message")
public class MessageController {

    @Autowired
    private MessageServiceIml messageServiceIml;

    @GetMapping("home")
    @ApiOperation("获取主页的留言")
    public String getHome(){
        return new GsonBuilder().setDateFormat("yyyy年MM月dd日 HH:mm:ss").create().toJson(messageServiceIml.getMessageHome());
    }

}

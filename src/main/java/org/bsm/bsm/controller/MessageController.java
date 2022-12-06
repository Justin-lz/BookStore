package org.bsm.bsm.controller;

import com.google.gson.GsonBuilder;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import org.apache.ibatis.annotations.Mapper;
import org.bsm.bsm.entity.Manager;
import org.bsm.bsm.entity.UserInfo;
import org.bsm.bsm.service.MessageService;
import org.bsm.bsm.service.MessageServiceIml;
import org.bsm.bsm.util.SessionAttributeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("BSM/Message")
@Api(tags="message接口",description="message传输接口")
public class MessageController {

    @Autowired
    private MessageServiceIml messageServiceIml;

    @GetMapping("Home")
    @ApiOperation(value = "获取主页的留言",notes = "只返回两条")
    public String getHome(){
        return new GsonBuilder().setDateFormat("yyyy年MM月dd日 HH:mm:ss").create().toJson(messageServiceIml.getMessageHome());
    }

    @GetMapping("page")
    @ApiOperation(value = "根据页码获取留言板内容",notes = "一页六条留言")
    @ApiImplicitParam(name = "page", value = "第page页留言",dataTypeClass = Integer.class)
    public  String getPage(@RequestParam Integer page){

        return new GsonBuilder().setDateFormat("yyyy年MM月dd日 HH:mm:ss").create().toJson(messageServiceIml.getMessagePage(page));
    }

    @PostMapping("new")
    @ApiOperation(value = "新增留言",notes = "成功返回空值，失败返回错误原因")
    @ApiImplicitParam(name = "Mword", value = "留言内容", dataTypeClass = String.class, paramType = "query", required = true)
    public  String newMessage(@RequestParam String Mword, HttpServletRequest request) {
        UserInfo userInfo=(UserInfo) request.getSession().getAttribute(SessionAttributeUtil.getUserInfo());
        if (userInfo==null){
            return "未登录，请登录";
        }
        messageServiceIml.newMessage(userInfo.getUid(),Mword);
        return null;
    }

    @GetMapping("pageManager")
    @ApiOperation(value = "根据页码获取留言板内容",notes = "一页六条留言")
    @ApiImplicitParam(name = "page", value = "第page页留言",dataTypeClass = Integer.class)
    public String getPageManager(@RequestParam Integer page,HttpServletRequest request){
       Manager manager=(Manager) request.getSession().getAttribute(SessionAttributeUtil.getManager());
        if (manager==null){
            return "未登录，请登录";
        }
        return new GsonBuilder().setDateFormat("yyyy年MM月dd日 HH:mm:ss").create().toJson(messageServiceIml.getMessagePageManager(page));
    }

    @PostMapping("checkManager")
    @ApiOperation(value = "审核通过留言",notes = "管理员登录索引")
    public String checkMessageManager(@RequestParam Integer Mid,HttpServletRequest request){
        Manager manager=(Manager) request.getSession().getAttribute(SessionAttributeUtil.getManager());
        if (manager==null){
            return "未登录，请登录";
        }
        return new GsonBuilder().setDateFormat("yyyy年MM月dd日 HH:mm:ss").create().toJson(messageServiceIml.checkMessageManager(Mid));
    }

    @PostMapping("deleteManager")
    @ApiOperation(value = "审核删除留言",notes = "管理员登录索引")
    public String deleteMessageManager(@RequestParam Integer Mid,HttpServletRequest request){
        Manager manager=(Manager) request.getSession().getAttribute(SessionAttributeUtil.getManager());
        if (manager==null){
            return "未登录，请登录";
        }
        return new GsonBuilder().setDateFormat("yyyy年MM月dd日 HH:mm:ss").create().toJson(messageServiceIml.deleteMessageManager(Mid));
    }
}

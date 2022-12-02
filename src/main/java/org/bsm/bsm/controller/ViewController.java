package org.bsm.bsm.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.bsm.bsm.util.SessionAttributeUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@Controller
@Api(value = "页面跳转接口",description = "根据url检查")
public class ViewController {


    @RequestMapping(value = {"/","/home"},method = RequestMethod.GET)
    @ApiOperation(value = "主页跳转")
    public String home(){
        return "home.html";
    }

    @ApiOperation(value = "搜索跳转")
    @RequestMapping(value = "search",method = RequestMethod.GET)
    public String search(HttpServletRequest request){
        String str=request.getParameter("str");
        String type =request.getParameter("type");
        System.out.println("set");
        HttpSession session =request.getSession();
        session.setAttribute(SessionAttributeUtil.getSearchString(),str);
        session.setAttribute(SessionAttributeUtil.getSearchType(),type);
        System.out.println("set"+str+type);
        return "search.html";
    }

    @ApiOperation(value = "留言板跳转")
    @GetMapping(value = "message")
    public String message(){return "messageBoard.html";}

    @GetMapping(value = "login")
    @ApiOperation(value = "登录跳转")
    public String login(){return "login.html";}

    @GetMapping(value = "register")
    @ApiOperation(value = "注册跳转")
    public String register(){return "register.html";}

    @GetMapping(value = "person")
    @ApiOperation(value = "个人信息跳转",notes = "检查是否登录，未登录进行跳转登录")
    public String person(HttpServletRequest request){
        if (request.getSession().getAttribute(SessionAttributeUtil.getUserInfo())==null) {
            return "redirect:/login";
        }else
            return "person.html";
    }
}

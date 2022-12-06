package org.bsm.bsm.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.bsm.bsm.service.BookServiceIml;
import org.bsm.bsm.util.SessionAttributeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@Controller
@Api(value = "页面跳转接口",description = "根据url检查")
public class ViewController {

    @Autowired
    private BookServiceIml bookServiceIml;

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

    @GetMapping(value = "book/{bid}")
    @ApiOperation(value = "书本跳转",notes = "用/xxx表示具体是哪本书的bid,已主动判断是否存在")
    public String book(@PathVariable String bid) {
        if (bookServiceIml.queryOneBookWithType(bid)==null)
            return "error.html";
        else
            return "book.html";
    }

    @GetMapping(value = "cart")
    @ApiOperation(value = "购物车跳转",notes="检查是否登录，未登录进行跳转登录")
    public String cart(HttpServletRequest request){
        if (request.getSession().getAttribute(SessionAttributeUtil.getUserInfo())==null) {
            return "redirect:/login";
        }else
            return "cart.html";
    }

    @GetMapping(value = "history")
    @ApiOperation(value = "购物车跳转",notes="检查是否登录，未登录进行跳转登录")
    public String history(HttpServletRequest request){
        if (request.getSession().getAttribute(SessionAttributeUtil.getUserInfo())==null) {
            return "redirect:/login";
        }else
            return "history.html";
    }
}

package org.bsm.bsm.controller;


import org.bsm.bsm.util.SessionAttributeUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@Controller
public class ViewController {


    @RequestMapping(value = {"/","/home"},method = RequestMethod.GET)
    public String home(){
        return "home.html";
    }
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
    @GetMapping(value = "message")
    public String message(){return "messageBoard.html";}
}

package org.bsm.bsm.controller;

import com.google.gson.GsonBuilder;
import org.bsm.bsm.entity.Message;
import org.bsm.bsm.service.MessageServiceIml;
import org.bsm.bsm.service.TypeServiceIml;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class ViewController {


    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String home(Model model){
        return "home.html";
    }
    @RequestMapping(value = "search",method = RequestMethod.GET)
    public String search(Model model, HttpServletRequest request){
        request.getSession().setAttribute("str",request.getParameter("str"));
        request.getSession().setAttribute("type",request.getParameter("type"));
        return "search.html";
    }
}

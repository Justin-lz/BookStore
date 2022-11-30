package org.bsm.bsm.controller;

import com.google.gson.GsonBuilder;
import org.bsm.bsm.service.MessageServiceIml;
import org.bsm.bsm.service.TypeServiceIml;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ViewController {
    @Autowired
    private MessageServiceIml messageServiceIml;
    @Autowired
    private TypeServiceIml typeServiceIml;

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String home(Model model){
        List<Message> messageHome =messageServiceIml.getMessageHome()
        model.addAttribute("messageHome1", messageHome.get(0));
        model.addAttribute("messageHome2",messageHome.get(1));
        return "home.html";
    }
    @RequestMapping(value = "search",method = RequestMethod.GET)
    public String search(Model model, HttpServletRequest request){
        model.addAttribute("type",request.getParameter("type"));
        model.addAttribute("str",request.getParameter("str"));
        return "search.html";
    }
}

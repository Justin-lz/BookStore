package org.bsm.bsm.controller;

import com.google.gson.GsonBuilder;
import org.bsm.bsm.service.MessageServiceIml;
import org.bsm.bsm.service.TypeServiceIml;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ViewController {
    @Autowired
    private MessageServiceIml messageServiceIml;
    @Autowired
    private TypeServiceIml typeServiceIml;

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String home(Model model){
        model.addAttribute("messageHome",new GsonBuilder().setDateFormat("yyyy年MM月dd日 HH:mm:ss").create().toJson(messageServiceIml.getMessageHome()));
        model.addAttribute("typeHome",new  GsonBuilder().create().toJson(typeServiceIml.getAllType()));
        return "home.html";
    }
}

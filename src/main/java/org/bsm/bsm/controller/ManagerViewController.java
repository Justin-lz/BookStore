package org.bsm.bsm.controller;


import io.swagger.annotations.Api;
import org.bsm.bsm.entity.Manager;
import org.bsm.bsm.mapper.ManagerMapper;
import org.bsm.bsm.util.SessionAttributeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@Api(value = "管理员页面跳转接口",description = "根据url检查，时刻检查是否管理员登录")
@RequestMapping("/manager")
public class ManagerViewController {

    @GetMapping("login")
    public String managerLogin(){
        return "Mlogin.html";
    }

    @GetMapping("home")
    public String managerHome(HttpServletRequest request){
        Manager manager =(Manager) request.getSession().getAttribute(SessionAttributeUtil.getManager());
        if (manager!=null){
            return "Mhome.html";
        }else
            return "error.html";
    }

    @GetMapping("message")
    public String managerMessage(HttpServletRequest request){
        Manager manager =(Manager) request.getSession().getAttribute(SessionAttributeUtil.getManager());
        if (manager!=null){
            return "Mmessage.html";
        }else
            return "error.html";
    }
    @GetMapping("record")
    public String managerRecord(HttpServletRequest request){
        Manager manager =(Manager) request.getSession().getAttribute(SessionAttributeUtil.getManager());
        if (manager!=null){
            return "Mrecord.html";
        }else
            return "error.html";
    }
    @GetMapping("book")
    public String managerBook(HttpServletRequest request){
        Manager manager =(Manager) request.getSession().getAttribute(SessionAttributeUtil.getManager());
        if (manager!=null){
            return "Mbook.html";
        }else
            return "error.html";
    }

    @GetMapping("discount")
    public String managerDiscount(HttpServletRequest request){
        Manager manager =(Manager) request.getSession().getAttribute(SessionAttributeUtil.getManager());
        if (manager!=null){
            return "Mdiscount.html";
        }else
            return "error.html";
    }


}

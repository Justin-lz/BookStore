package org.bsm.bsm.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.bsm.bsm.entity.Manager;
import org.bsm.bsm.entity.UserInfo;
import org.bsm.bsm.entity.UserPass;
import org.bsm.bsm.mapper.ManagerMapper;
import org.bsm.bsm.util.SessionAttributeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class ManagerController {
    @Autowired
    private ManagerMapper managerMapper;

    @PostMapping("login")
    @ApiOperation(value = "用户登录",notes = "登录成功返回登录成功，登录失败返回用户名或密码错误")
    @ApiImplicitParams({@ApiImplicitParam(name = "Mauthority", dataTypeClass = String.class, value = "权限", required = true, paramType = "query"),
            @ApiImplicitParam(name = "Mpassword", dataTypeClass = String.class, value = "密码", required = true, paramType = "query")})
    public String login(@RequestParam("Mauthority")String Mauthority, @RequestParam("Mpassword")String Mpassword, HttpServletRequest request){
        Manager manager = new Manager();
        manager.setMauthority(Mauthority);
        manager.setMpassword(Mpassword);
        manager =managerMapper.login(manager);//获取管理员基本信息
        if (manager==null) return "用户名或密码错误";
        else {
            request.getSession().setAttribute(SessionAttributeUtil.getManager(),manager);
            return "登录成功";
        }
    }
}

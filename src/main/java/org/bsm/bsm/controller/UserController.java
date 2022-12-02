package org.bsm.bsm.controller;

import com.google.gson.GsonBuilder;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Param;
import org.bsm.bsm.entity.UserInfo;
import org.bsm.bsm.entity.UserPass;
import org.bsm.bsm.service.UserServiceIml;
import org.bsm.bsm.util.SessionAttributeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("BSM/User")
@Api(tags = "用户信息与登录注册接口",description = "用于返回基本信息，登录或注册功能的实现")
public class UserController {
    @Autowired
    private UserServiceIml userServiceIml;

    @GetMapping("getUserName")
    @ApiOperation("获取当前登录用户名")
    public String getUserName(HttpServletRequest request) {
       UserInfo userInfo =(UserInfo) request.getSession().getAttribute(SessionAttributeUtil.getUserInfo());
       if (userInfo==null){
           return "未登录";
       }else {
           return userInfo.getUname();
       }
    }

    @GetMapping("getUserInfo")
    @ApiOperation("获取用户个人信息,未登录返回false")
    public String getUserInfo(HttpServletRequest request){
        UserInfo userInfo =(UserInfo) request.getSession().getAttribute("UserInfo");
        if (userInfo==null){
            return "false";
        }else {
            return new GsonBuilder().create().toJson(userInfo);
        }
    }

    @PostMapping("login")
    @ApiOperation(value = "用户登录",notes = "登录成功返回登录成功，登录失败返回用户名或密码错误")
    @ApiImplicitParams({@ApiImplicitParam(name = "Uname", dataTypeClass = String.class, value = "用户名", required = true, paramType = "query"),
            @ApiImplicitParam(name = "UPword", dataTypeClass = String.class, value = "密码", required = true, paramType = "query")})
    public String login(@RequestParam("Uname")String Uname, @RequestParam("UPword")String UPword, HttpServletRequest request){
        UserPass userPass = new UserPass();
        userPass.setUname(Uname);
        userPass.setUPword(UPword);
        UserInfo userInfo = userServiceIml.login(userPass);//获取用户基本信息
        if (userInfo==null) return "用户名或密码错误";
        else {
            request.getSession().setAttribute(SessionAttributeUtil.getUserInfo(),userInfo);
            return "登录成功";
        }
    }

    @PostMapping("register")
    @ApiOperation(value = "用户注册", notes = "注册成功返回‘注册成功’，注册失败返回失败原因,字符串是否空以判断")
    @ApiImplicitParams({@ApiImplicitParam(name = "Uname", dataTypeClass = String.class, value = "用户名", required = true, paramType = "query"),
            @ApiImplicitParam(name = "UPword", dataTypeClass = String.class, value = "密码", required = true, paramType = "query")})
    public String register(@RequestParam("Uname")String Uname, @RequestParam("UPword")String UPword){

        if (UPword==null ||"".equals(UPword)) return "密码为空";
        if (Uname==null ||"".equals(Uname)) return "用户名为空";

        UserPass userPass = new UserPass();
        userPass.setUname(Uname);
        userPass.setUPword(UPword);
        if (userServiceIml.checkUnique(userPass)){
            if (userServiceIml.newUser(userPass)==1)
                return "注册成功";
            else
                return "未知错误，注册失败";
        }else return "用户名重复";
    }





}

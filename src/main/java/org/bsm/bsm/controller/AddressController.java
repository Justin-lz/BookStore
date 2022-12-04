package org.bsm.bsm.controller;

import com.google.gson.GsonBuilder;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.bsm.bsm.entity.UserInfo;
import org.bsm.bsm.service.AddressServiceIml;
import org.bsm.bsm.util.SessionAttributeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/BSM/address")
@Api(tags = "地址信息操作接口")
public class AddressController {

    @Autowired
    private AddressServiceIml addressServiceIml;

    @ApiOperation(value = "获取所有地址信息",notes = "未登录时会返回未登录")
    @GetMapping("getAll")
    public String getAllAddress(HttpServletRequest request){
        UserInfo userInfo =(UserInfo) request.getSession().getAttribute(SessionAttributeUtil.getUserInfo());
        if (userInfo==null) return "未登录" ;
        else {
            return new GsonBuilder().create().toJson(addressServiceIml.getUserAddress(userInfo));
        }
    }

    @PostMapping("new")
    @ApiOperation(value = "新建地址信息",notes ="未登录时会返回未登录，成功返回空值" )
    @ApiImplicitParams({@ApiImplicitParam(name = "Aaddress",value = "地址",required = true,dataTypeClass = String.class),
            @ApiImplicitParam(name = "Areceiver",value = "收件人",required = true,dataTypeClass = String.class),
            @ApiImplicitParam(name = "Aphone",value = "手机号",required = true,dataTypeClass = String.class)})
    public String newAddress(HttpServletRequest request,
                             @RequestParam(value = "Aaddress") String Aaddress,
                             @RequestParam(value = "Areceiver") String Areceiver,
                             @RequestParam(value = "Aphone") String Aphone){
        UserInfo userInfo =(UserInfo) request.getSession().getAttribute(SessionAttributeUtil.getUserInfo());
        if (userInfo==null) return "未登录" ;
        else {
            addressServiceIml.newUserAddress(userInfo,Aaddress,Areceiver,Aphone);
            return null;
        }

    }
}

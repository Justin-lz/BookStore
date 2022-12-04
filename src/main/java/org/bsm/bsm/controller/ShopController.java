package org.bsm.bsm.controller;

import com.google.gson.GsonBuilder;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.bsm.bsm.entity.UserInfo;
import org.bsm.bsm.entity.Shop;
import org.bsm.bsm.service.ShopServiceIml;
import org.bsm.bsm.util.SessionAttributeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/BSM/Shop")
@Api(tags="购物车操作结构",description="进行购物车的添加，删除，进入订单")
public class ShopController{

    @Autowired
    private ShopServiceIml shopServiceIml;

    @PostMapping("add")
    @ApiImplicitParams({@ApiImplicitParam(),
                        @ApiImplicitParam()})
    @ApiOperation(value="将书本添加入购物车", notes = "若书本一再购物车中，则会增加数量,若未登录会直接返回")
    public String addShop(@RequestParam Integer Bid,@RequestParam Integer Scount,HttpServletRequest request){
        UserInfo userInfo = request.getSession.getAttribute(SessionAttributeUtil.getUserInfo);
        if (userInfo == null){
            return "未登录";
        }
        shopServiceIml.addShop(userInfo.getUid,Bid,Scount);
        return null;
    }

}

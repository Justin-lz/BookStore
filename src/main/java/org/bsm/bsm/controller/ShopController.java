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
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/BSM/Shop")
@Api(tags="购物车操作结构",description="进行购物车的添加，删除，进入订单")
public class ShopController{

    @Autowired
    private ShopServiceIml shopServiceIml;

    @PostMapping("add")
    @ApiImplicitParams({@ApiImplicitParam(name = "Bid", value = "书本id", dataTypeClass = String.class, paramType = "query", required = true),
                        @ApiImplicitParam(name = "Scount", value = "书本数量", dataTypeClass = String.class, paramType = "query", required = true)})
    @ApiOperation(value="将书本添加入购物车", notes = "若书本以再购物车中，则会增加数量,若未登录会直接返回")
    public String addShop(@RequestParam Integer Bid,@RequestParam Integer Scount,HttpServletRequest request){
        UserInfo userInfo =(UserInfo) request.getSession().getAttribute(SessionAttributeUtil.getUserInfo());
        if (userInfo == null){
            return "未登录";
        }
        shopServiceIml.addShop(userInfo.getUid(),Bid,Scount);
        return null;
    }

    @GetMapping("get")
    @ApiOperation(value="显示当前用户购物车", notes = "若未登录会直接返回")
    public String getAllShopByUid(HttpServletRequest request){
        UserInfo userInfo =(UserInfo) request.getSession().getAttribute(SessionAttributeUtil.getUserInfo());
        if (userInfo == null){
            return "未登录";
        }
        return new GsonBuilder().create().toJson(shopServiceIml.allShopByUid(userInfo.getUid())) ;
    }

}

package org.bsm.bsm.controller;

import com.google.gson.GsonBuilder;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import org.apache.ibatis.annotations.Mapper;
import org.bsm.bsm.entity.UserInfo;
import org.bsm.bsm.service.DiscountService;
import org.bsm.bsm.service.DiscountServiceIml;
import org.bsm.bsm.util.SessionAttributeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@Api(tags="折扣接口",description="")
@RequestMapping("/BSM/Discount")
public class DiscountController{

    @Autowired
    private DiscountServiceIml discountServiceIml;

    @GetMapping("getAll")
    @ApiOperation("获取所有折扣信息")
    public String getAll(){
        return new GsonBuilder().create().toJson(discountServiceIml.getAll());
    }

    @PostMapping("newDiscount")
    @ApiOperation("新增折扣")
    public String newDiscount(@RequestParam Float Ddec,@RequestParam Float Ddis,@RequestParam Integer Dcount,@RequestParam Float Dprice, @RequestParam Date Dstart,@RequestParam Date Dend, HttpServletRequest request){
        Discount discount = new Discount();
        
        
    }

}
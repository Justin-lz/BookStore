package org.bsm.bsm.controller;

import com.google.gson.GsonBuilder;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import org.apache.ibatis.annotations.Mapper;
import org.bsm.bsm.entity.Discount;
import org.bsm.bsm.entity.Manager;
import org.bsm.bsm.entity.UserInfo;
import org.bsm.bsm.service.DiscountService;
import org.bsm.bsm.service.DiscountServiceIml;
import org.bsm.bsm.util.SessionAttributeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;

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

    @GetMapping("getUse")
    @ApiOperation("获取正在使用的折扣信息")
    public String getUse(){
        return new GsonBuilder().create().toJson(discountServiceIml.getUse());
    }

    @PostMapping("newDiscount")
    @ApiOperation(value = "新增折扣",notes = "成功返还null")
    public String newDiscount(@RequestParam Float Ddec, @RequestParam Float Ddis, @RequestParam Integer Dcount, @RequestParam Float Dprice, @RequestParam String Dstart, @RequestParam String Dend, HttpServletRequest request){
        Manager manager=(Manager) request.getSession().getAttribute(SessionAttributeUtil.getManager());
        if (manager==null){
            return "未登录，请登录";
        }
        Discount discount = new Discount();
        SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        discount.setDcount(Dcount);
        discount.setDdec(Ddec);
        discount.setDdis(Ddis);
        discount.setDprice(Dprice);
        try {
            discount.setDStart(sdf.parse(Dstart));
            discount.setDEnd(sdf.parse(Dend));
        }catch (Exception e){
            return e.toString();
        }
        discountServiceIml.insertDiscount(discount);
        return null;
    }

    @PostMapping("updateDiscount")
    @ApiOperation(value = "新增折扣",notes = "成功返还null")
    public String updateDiscount(@RequestParam Integer Did, @RequestParam Float Ddec, @RequestParam Float Ddis, @RequestParam Integer Dcount, @RequestParam Float Dprice, @RequestParam String Dstart, @RequestParam String Dend, HttpServletRequest request){
        Manager manager=(Manager) request.getSession().getAttribute(SessionAttributeUtil.getManager());
        if (manager==null){
            return "未登录，请登录";
        }
        Discount discount = new Discount();
        discount.setDid(Did);
        discount.setDcount(Dcount);
        discount.setDdec(Ddec);
        discount.setDdis(Ddis);
        discount.setDprice(Dprice);
        SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            discount.setDStart(sdf.parse(Dstart));
            discount.setDEnd(sdf.parse(Dend));
        }catch (Exception e){
            return e.toString();
        }
        discountServiceIml.updateDiscount(discount);
        return null;
    }

    @PostMapping("updateDiscount")
    @ApiOperation(value = "新增折扣",notes = "成功返还null")
    public String updateDiscount(@RequestParam Integer Did, HttpServletRequest request){
        Manager manager=(Manager) request.getSession().getAttribute(SessionAttributeUtil.getManager());
        if (manager==null){
            return "未登录，请登录";
        }
        discountServiceIml.deleteDiscount(Did);
        return null;
    }

}
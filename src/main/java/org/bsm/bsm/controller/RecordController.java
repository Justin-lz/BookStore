package org.bsm.bsm.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.bsm.bsm.entity.Record;
import org.bsm.bsm.entity.UserInfo;
import org.bsm.bsm.service.RecordServiceIml;
import org.bsm.bsm.util.SessionAttributeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@RestController
@RequestMapping("Bsm/Record")
@Api(tags = "订单相关",description = "订单相关操作")
public class RecordController {

    @Autowired
    private RecordServiceIml recordServiceIml;

    @PostMapping("new")
    @ApiOperation(value = "生成新的购物订单",notes = "如错误会返回错误信息，创建成功会返回null")
    @ApiImplicitParams({
            @ApiImplicitParam(value = "书本编号数组", name = "Bids", allowMultiple = true, dataTypeClass = Integer.class,required = true),
            @ApiImplicitParam(value = "地址编号", name = "Aid", dataTypeClass = Integer.class,required = true),
            @ApiImplicitParam(value = "总价", name = "Rprice",dataTypeClass = Float.class,required = true),
            @ApiImplicitParam(value = "折扣描述", name = "Bids", dataTypeClass = String.class,required = true)
    })
    public String newRecord(@RequestParam Integer[] Bids,
                            @RequestParam Integer Aid,
                            @RequestParam Float Rprice,
                            @RequestParam String Rdiscount,
                            HttpServletRequest request){
        try {
            UserInfo userInfo =(UserInfo) request.getSession().getAttribute(SessionAttributeUtil.getUserInfo());
            if (userInfo==null){
                return "未登录";
            }
            Record record = new Record();
            record.setAid(Aid);
            record.setUid(userInfo.getUid());
            record.setRdiscount(Rdiscount);
            record.setRprice(Rprice);
            Date date = new Date();
            record.setRtime(date);
            recordServiceIml.newRecord(Bids,record);
        }catch (Exception e){
            return e.toString();
        }
        return null;
    }

}

package org.bsm.bsm.controller;

import com.google.gson.GsonBuilder;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.bsm.bsm.entity.Manager;
import org.bsm.bsm.entity.Record;
import org.bsm.bsm.entity.UserInfo;
import org.bsm.bsm.service.RecordServiceIml;
import org.bsm.bsm.util.SessionAttributeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("getByUid")
    @ApiOperation(value = "获取用户所有订单",notes = "如未登录会返回请登录")
    public String getRecordByUid(HttpServletRequest request){
        UserInfo userInfo =(UserInfo) request.getSession().getAttribute(SessionAttributeUtil.getUserInfo());
        if (userInfo==null){
            return "未登录";
        }
        return new GsonBuilder().setDateFormat("yyyy年MM月dd日 HH:mm:ss").create().toJson(recordServiceIml.getRecordByUid(userInfo.getUid()));
    }

    @GetMapping("getByManager")
    @ApiOperation(value = "获取所有待审核发货订单",notes = "如非管理员会返回请登录")
    public String getRecordNeedCheckByManager(HttpServletRequest request){
        Manager manager = (Manager) request.getSession().getAttribute(SessionAttributeUtil.getManager());
        if (manager==null) {
            return "未登录";
        }
        return new GsonBuilder().setDateFormat("yyyy年MM月dd日 HH:mm:ss").create().toJson(recordServiceIml.getRecordNeedCheckByManager());
    }

    @PostMapping("checkByManager")
    @ApiOperation(value = "审核通过订单",notes = "如非管理员会返回请登录")
    @ApiImplicitParam(name = "Rid",value = "订单编号",required = true,dataTypeClass = Integer.class)
    public String checkRecordByManager(HttpServletRequest request,@RequestParam Integer Rid){
        Manager manager = (Manager) request.getSession().getAttribute(SessionAttributeUtil.getManager());
        if (manager==null) {
            return "未登录";
        }
        return new GsonBuilder().setDateFormat("yyyy年MM月dd日 HH:mm:ss").create().toJson(recordServiceIml.checkRecordByManager(Rid));
    }

    @PostMapping("deliverByManager")
    @ApiOperation(value = "发货订单",notes = "如非管理员会返回请登录")
    @ApiImplicitParam(name = "Rid",value = "订单编号",required = true,dataTypeClass = Integer.class)
    public String deliverRecordByManager(HttpServletRequest request,@RequestParam Integer Rid){
        Manager manager = (Manager) request.getSession().getAttribute(SessionAttributeUtil.getManager());
        if (manager==null) {
            return "未登录";
        }
        return new GsonBuilder().setDateFormat("yyyy年MM月dd日 HH:mm:ss").create().toJson(recordServiceIml.deleteRecordByManager(Rid));
    }

    @PostMapping("deleterByManager")
    @ApiOperation(value = "删除订单",notes = "如非管理员会返回请登录,会同时返回删除的历史记录数量，修改库存数量")
    @ApiImplicitParam(name = "Rid",value = "订单编号",required = true,dataTypeClass = Integer.class)
    public String deleteRecordByManager(HttpServletRequest request,@RequestParam Integer Rid){
        Manager manager = (Manager) request.getSession().getAttribute(SessionAttributeUtil.getManager());
        if (manager==null) {
            return "未登录";
        }
        return new GsonBuilder().setDateFormat("yyyy年MM月dd日 HH:mm:ss").create().toJson(recordServiceIml.deleteRecordByManager(Rid));
    }

}

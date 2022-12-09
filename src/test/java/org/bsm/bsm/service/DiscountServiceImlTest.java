package org.bsm.bsm.service;

import com.google.gson.GsonBuilder;
import org.bsm.bsm.BsmApplication;
import org.bsm.bsm.entity.Discount;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.SimpleDateFormat;

import static org.junit.jupiter.api.Assertions.*;
@RunWith(SpringRunner.class)
@SpringBootTest(classes = BsmApplication.class)
class DiscountServiceImlTest {
    @Autowired
    private DiscountServiceIml discountServiceIml;

    @Test
    void getAll() {
        System.out.println("测试getAll");
        System.out.println(new GsonBuilder().create().toJson(discountServiceIml.getAll()));
    }

    @Test
    void insertDiscount() {
        System.out.println("insertDiscount");
        System.out.println("当前"+new GsonBuilder().create().toJson(discountServiceIml.getAll()));
        Discount discount = new Discount();
        discount.setDprice((float)10.0);
        discount.setDdec((float)10.0);
        discount.setDcount(5);
        discount.setDdis((float)4);
        discount.setDdec((float)0.8);
        SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            discount.setDStart(sdf.parse("2022-12-28 15:16:47"));
            discount.setDEnd(sdf.parse("2022-12-28 15:16:48"));
        }catch (Exception e){
            e.printStackTrace();
        }

        System.out.println(discountServiceIml.insertDiscount(discount));
        System.out.println("完成后"+new GsonBuilder().create().toJson(discountServiceIml.getAll()));
    }

    @Test
    void getUse() {
        System.out.println("getUse");
        System.out.println(discountServiceIml.getUse());
    }

    @Test
    void updateDiscount() {
        System.out.println("updateDiscount");
        System.out.println("当前"+new GsonBuilder().create().toJson(discountServiceIml.getAll()));
        Discount discount = new Discount();
        discount.setDid(4);
        discount.setDprice((float)11.0);
        discount.setDdec((float)11.0);
        discount.setDcount(5);
        discount.setDdis((float)4);
        discount.setDdec((float)0.8);
        SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            discount.setDStart(sdf.parse("2022-12-28 15:16:47"));
            discount.setDEnd(sdf.parse("2022-12-28 15:16:48"));
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println(discountServiceIml.updateDiscount(discount));
        System.out.println("当前"+new GsonBuilder().create().toJson(discountServiceIml.getAll()));
    }

    @Test
    void deleteDiscount() {
        System.out.println("updateDiscount");
        System.out.println("当前"+new GsonBuilder().create().toJson(discountServiceIml.getAll()));
        Discount discount = new Discount();
        discount.setDid(4);
        discount.setDdis((float)4);
        discount.setDprice((float)11.0);
        discount.setDdec((float)11.0);
        discount.setDcount(5);
        discount.setDdec((float)0.8);
        SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            discount.setDStart(sdf.parse("2022-12-28 15:16:47"));
            discount.setDEnd(sdf.parse("2022-12-28 15:16:48"));
        }catch (Exception e){
            e.printStackTrace();
        }

        System.out.println(discountServiceIml.updateDiscount(discount));
        System.out.println("完成后"+new GsonBuilder().create().toJson(discountServiceIml.getAll()));
    }
}
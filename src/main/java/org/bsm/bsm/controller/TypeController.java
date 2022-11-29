package org.bsm.bsm.controller;

import com.google.gson.GsonBuilder;
import io.swagger.annotations.Api;
import org.bsm.bsm.service.TypeServiceIml;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("BSM/Type")
@Api(tags = "类型接口",description = "创建类型与修改该类型的接口")
public class TypeController {
    @Autowired
    private TypeServiceIml typeServiceIml;

    @GetMapping("getALl")
    public String getTypeAll(){
        return new  GsonBuilder().create().toJson(typeServiceIml.getAllType());
    }

    @PostMapping("new")
    public String newType(){
        return null;
    }

}

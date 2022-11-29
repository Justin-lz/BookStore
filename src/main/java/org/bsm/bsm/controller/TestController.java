package org.bsm.bsm.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("BSM/testing")
@Api(tags = {"后端自己的测试类，无需在意，可检查是否成功运行"})
public class TestController {
    @RequestMapping(value = "/",method = RequestMethod.GET)
    @ApiOperation("测试一下")
    public String test() {return "测试成功";}
}

package org.bsm.bsm.controller;


import com.google.gson.GsonBuilder;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.bsm.bsm.entity.Book;
import org.bsm.bsm.service.BookServiceIml;

import org.bsm.bsm.util.SessionAttributeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("BSM/Book")
@Api(tags="书本接口",description="获取书本信息的接口")
public class BookController {

    @Autowired
    private BookServiceIml bookServiceIml;

    @GetMapping("search")
    @ApiOperation("返回搜索图书")
    public String getBookSearch(@RequestParam Integer page, HttpServletRequest request){
        HttpSession session = request.getSession();
        String str =(String) session.getAttribute(SessionAttributeUtil.getSearchString());
        String type =(String) session.getAttribute(SessionAttributeUtil.getSearchType());
        System.out.println("get"+str+type);
        session.removeAttribute(SessionAttributeUtil.getSearchString());
        session.removeAttribute(SessionAttributeUtil.getSearchType());
        return new GsonBuilder().create().toJson(bookServiceIml.queryBook(page, str,type));


    }

    @PostMapping("insert")
    @ApiOperation("插入图书")
    public String newBook(Book book){ return bookServiceIml.insertBook(book).toString(); }


    @GetMapping("home")
    @ApiOperation("返回主页图书")
    public String getBookHome(){ return new GsonBuilder().create().toJson(bookServiceIml.queryHomeBook()); }


}

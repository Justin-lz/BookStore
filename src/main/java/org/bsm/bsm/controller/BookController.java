package org.bsm.bsm.controller;


import com.google.gson.GsonBuilder;
import org.bsm.bsm.entity.Book;
import org.bsm.bsm.service.BookServiceIml;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("BSM/Book")
@Api(tag="书本接口",description="获取书本信息的接口")
public class BookController {

    @Autowired
    private BookServiceIml bookServiceIml;

    @GetMapping("all")
    @ApiOperation("返回所有图书")
    public String getBookAll(){ return new GsonBuilder().create().toJson(bookServiceIml.queryAllBook()); }

    @GetMapping("insert")
    @ApiOperation("插入图书")
    public String newBook(Book book){ return bookServiceIml.insertBook(book).toString(); }

}

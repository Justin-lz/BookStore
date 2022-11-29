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
public class BookController {

    @Autowired
    private BookServiceIml bookServiceIml;

    @GetMapping("all")
    public String all(){ return new GsonBuilder().setDateFormat("yyyy年MM月dd日 HH:mm:ss").create().toJson(bookServiceIml.queryAllBook()); }

    @GetMapping("insert")
    public String insert(Book book){ return bookServiceIml.insertBook(book).toString(); }

}

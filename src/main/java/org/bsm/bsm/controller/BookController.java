package org.bsm.bsm.controller;


import com.google.gson.GsonBuilder;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.bsm.bsm.entity.Book;
import org.bsm.bsm.entity.Manager;
import org.bsm.bsm.service.BookServiceIml;

import org.bsm.bsm.util.SessionAttributeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

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
    public String newBook(Book book, HttpServletRequest request){
        Manager manager=(Manager) request.getSession().getAttribute(SessionAttributeUtil.getManager());
        if (manager==null){
            return "未登录，请登录";
        }
        return bookServiceIml.insertBook(book).toString();
    }

    @PostMapping("update")
    @ApiOperation("修改图书")
    public String updateBook(Book book, HttpServletRequest request){
        Manager manager=(Manager) request.getSession().getAttribute(SessionAttributeUtil.getManager());
        if (manager==null){
            return "未登录，请登录";
        }
        return bookServiceIml.updateBook(book).toString();
    }
    @PostMapping("delete")
    @ApiOperation("删除图书")
    public String deleteBook(Integer Bid, HttpServletRequest request){
        Manager manager=(Manager) request.getSession().getAttribute(SessionAttributeUtil.getManager());
        if (manager==null){
            return "未登录，请登录";
        }
        return bookServiceIml.deleteBook(Bid).toString();
    }

    @PostMapping("upImg")
    @ApiOperation(value = "上传书本图片", consumes = "multipart/form-data",notes = "成功返回路径，失败返回原因，格式强制要求jpg")
    public String upBookImg( @RequestPart("file") MultipartFile file, @RequestParam Integer Bid, HttpServletRequest request){
        Manager manager=(Manager) request.getSession().getAttribute(SessionAttributeUtil.getManager());
        if (manager==null){
            return "未登录，请登录";
        }

        try {
            //获取文件名
            String fileName = file.getOriginalFilename();
            //获取文件后缀名。也可以在这里添加判断语句，规定特定格式的图片才能上传，否则拒绝保存。
            String suffixName = fileName.substring(fileName.lastIndexOf("."));
            if (!suffixName.equals(".jpg"))
                return "请上传jpg格式图片";
            //为了避免发生图片替换，这里使用了文件名重新生成
            fileName = Bid.toString()+suffixName;

            String path = ResourceUtils.getURL("classpath:").getPath()+"static/img/book/";
            file.transferTo(new File(path+fileName));
            return "http://localhost:8080/img/book"+fileName;
        }catch (IOException e){
            e.printStackTrace();
            return e.toString();
        }
    }


    @GetMapping("home")
    @ApiOperation("返回主页图书")
    public String getBookHome(){ return new GsonBuilder().create().toJson(bookServiceIml.queryHomeBook()); }

    @GetMapping("book")
    @ApiOperation("返回具体页面图书")
    @ApiImplicitParam(name = "Bid",value = "书籍编号",dataTypeClass = String.class,required = true)
    public String getBookHome(@RequestParam("Bid")String Bid){ return new GsonBuilder().create().toJson(bookServiceIml.queryOneBookWithType(Bid)); }



}

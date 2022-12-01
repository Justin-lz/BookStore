package org.bsm.bsm.service;

import org.bsm.bsm.entity.Book;
import org.bsm.bsm.mapper.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class BookServiceIml implements BookService{

    @Autowired
    private BookMapper bookMapper;

    @Override
    public List<Book> queryBook(Integer page, String str, String type) {
        if (str==null&&type==null)
            return bookMapper.queryAllBook((page-1)*16);
        if (str==null)
            return bookMapper.queryTypeBook((page-1)*16,type);
        if (type==null)
            return bookMapper.queryStrBook((page-1)*16,str);
        return bookMapper.queryTypeStrBook((page-1)*16,type,str);


    }

    @Override
    public Integer insertBook(Book book) {
        return bookMapper.insertBook(book);
    }

    @Override
    public List<Book> queryHomeBook() {
        return bookMapper.queryHomeBook();
    }
}

package org.bsm.bsm.service;

import org.bsm.bsm.entity.Book;
import org.bsm.bsm.mapper.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceIml implements BookService{

    @Autowired
    private BookMapper bookMapper;

    @Override
    public List<Book> queryAllBook() {
        return bookMapper.queryAllBook();
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

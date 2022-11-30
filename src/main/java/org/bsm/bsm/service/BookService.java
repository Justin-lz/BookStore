package org.bsm.bsm.service;

import org.bsm.bsm.entity.Book;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface BookService {
    List<Book> queryBook(Integer page, String str, String type);
    List<Book> queryHomeBook();
    Integer insertBook(Book book);
}

package org.bsm.bsm.service;

import org.bsm.bsm.entity.Book;

import java.util.List;

public interface BookService {
    List<Book> queryAllBook();
    Integer insertBook(Book book);
}

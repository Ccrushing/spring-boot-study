package com.crush.book.service;

import com.crush.book.entity.Book;

import java.util.List;

public interface BookService {
    /**
     * 新增book
     *
     * @param book
     * @return
     */
    Book save(Book book);

    /**
     * 查询所有book
     * @return 图书集合
     */

    List<Book> getAll();
}

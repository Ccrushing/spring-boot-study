package com.crush.book.service.impl;

import com.crush.book.entity.Book;
import com.crush.book.repository.BookRepository;
import com.crush.book.service.BookService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Crush
 * @date 2021/3/18
 * @dercsiption BookServiceImpl
 */
@Service
@Transactional(rollbackFor = {RuntimeException.class})
public class BookServiceImpl implements BookService {
    @Resource
    private BookRepository bookRepository;

    @Override
    public Book save(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public List<Book> getAll() {
        return bookRepository.findAll();
    }
}

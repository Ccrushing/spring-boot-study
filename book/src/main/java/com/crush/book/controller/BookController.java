package com.crush.book.controller;

import com.crush.book.entity.Book;
import com.crush.book.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Crush
 * @date 2021/3/18
 * @dercsiption BookController
 */
@Controller
@RequestMapping(value = "/")
public class BookController {
    @Resource
    private BookService bookService;

    @GetMapping()
    public String bookPage(Model model) {
        model.addAttribute("message","Hello SpringBoot");
        List<Book> bookList = bookService.getAll();
        model.addAttribute("bookList",bookList);
        return "book";

    }
}

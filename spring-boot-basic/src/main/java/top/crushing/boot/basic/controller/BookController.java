package top.crushing.boot.basic.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import top.crushing.boot.basic.controller.dto.AjaxResponse;
import top.crushing.boot.basic.controller.dto.Param;
import top.crushing.boot.basic.entity.Book;
import top.crushing.boot.basic.entity.BookReader;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @author Crush
 * @date 2021/3/4
 * @dercsiption BookController
 */
@RestController
@RequestMapping(value = "/api/v1/books")
@Slf4j
public class BookController {

    @GetMapping("all")
    public AjaxResponse selectBooks() {
        BookReader[] readers = {
                BookReader.builder().
                        name("aaa").
                        age(20).
                        build(),
                BookReader.
                        builder().
                        name("bbb").age(19).
                        build(),
        };
        List<BookReader> readerList = Arrays.asList(readers);
        Book book1 = Book.builder()
                .id(123)
                .author("crush")
                .title("SpringBoot")
                .content("SpringBoot从入门到精通")
                .createTime(new Date())
                .readers(readerList)
                .build();

        Book book2 = Book.builder()
                .id(456)
                .author("crush")
                .title("Vue.js")
                .content("Vue.js从入门到精通")
                .createTime(new Date())
                .readers(readerList)
                .build();
        Book[] books = {book1,book2};
        List<Book> bookList = Arrays.asList(books);
        return AjaxResponse.success(bookList);
        }

        @GetMapping("{id}")
    public AjaxResponse getBook(@PathVariable int id) {
            Book book = Book.builder()
                    .id(id)
                    .author("crush")
                    .title("Java")
                    .content("Java从入门到精通")
                    .createTime(new Date())
                    .build();
        return AjaxResponse.success(book);
        }

    @PostMapping()
    public AjaxResponse saveBook(@RequestBody Book book) {
        log.info("saveBook:" + book);
        return AjaxResponse.success(book);
    }

    @PutMapping()
    public AjaxResponse updateBook(@RequestBody Book book) {
        Book book1 = Book.builder()
                .id(111)
                .author("crush")
                .title("Java")
                .content("Java从入门到精通")
                .createTime(new Date())
                .build();
        log.info("book:" + book1);

        book1.setId(book.getId());
        book1.setTitle(book.getTitle());

        log.info("book:" + book1);
        return AjaxResponse.success(book1);

    }
//    @DeleteMapping("{id }")
//    public AjaxResponse deleteBook(@PathVariable int id) {
//        log.info("id" + id);
//        return AjaxResponse.success();
//
//    }

//    @DeleteMapping()
//    public AjaxResponse deleteBook(@RequestParam Integer id,@RequestParam String title) {
//        log.info("id" + id);
//        log.info("title:" + title);
//        return AjaxResponse.success();
//    }

    @DeleteMapping()
    public  AjaxResponse deleteBook(@RequestBody Param param) {
        log.info("id:" + param.getId());
        log.info("title:" + param.getTitle());
        return AjaxResponse.success(param);
    }

}




package top.crushing.boot.basic.service;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import top.crushing.boot.basic.entity.Book;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class BookServiceTest {

    @Resource
    private BookService bookService;

    @Test
    void postBook() {
        Book book = Book.builder()
                .title("test")
                .content("test")
                .author("crush")
                .build();
        log.info("book:" + book);
        boolean flag = bookService.postBook(book);
        log.info("flag:" + flag);
        assertTrue(flag);
    }
    @Test
    void getById() {
        Book book = bookService.getById(1);
        log.info("book:" + book);
        assertEquals("crush",book.getAuthor());
    }

    @Test
    void findAll() {
        List<Book> all = bookService.getAll();
        log.info("all:" + all);
        assertEquals(2,all.size());
    }

    @Test
    void update() {
        Book book = bookService.getById(1);
        book.setAuthor("crush");
        bookService.updateBook(book);
        assertEquals("crush",book.getAuthor());
    }

    @Test
    void delete() {
        boolean flag = bookService.deleteBook(2);
        assertTrue(flag);
    }


}
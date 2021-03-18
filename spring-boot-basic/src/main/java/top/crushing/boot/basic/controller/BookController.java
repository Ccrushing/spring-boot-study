package top.crushing.boot.basic.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import top.crushing.boot.basic.controller.dto.AjaxResponse;
import top.crushing.boot.basic.controller.dto.Param;
import top.crushing.boot.basic.entity.Book;
import top.crushing.boot.basic.entity.BookReader;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * @author Crush
 * @date 2021/3/
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

    @PostMapping("body")
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
    @DeleteMapping("{id}")
    public AjaxResponse deleteBook(@PathVariable int id) {
        log.info("id" + id);
        return AjaxResponse.success();

    }

//    @DeleteMapping()
//    public AjaxResponse deleteBook(@RequestParam Integer id,@RequestParam String title) {
//        log.info("id" + id);
//        log.info("title:" + title);
//        return AjaxResponse.success();
//    }

//    @DeleteMapping()
//    public  AjaxResponse deleteBook(@RequestBody Param param) {
//        log.info("id:" + param.getId());
//        log.info("title:" + param.getTitle());
//        return AjaxResponse.success(param);
//    }

    @PostMapping("upload")
    public AjaxResponse handleUpload(MultipartFile file, HttpServletRequest request) {
        //创建文件在服务器的存放路径
        String path = request.getServletContext().getRealPath("/upload");
        log.info(path);
        File fileDir = new File(path);
        if (!fileDir.exists()) {
//            fileDir.mkdirs();
            boolean flag = fileDir.mkdirs();
            log.info("flag" + flag);
        }
        //生成文件在服务器端存放的名字
        String prefixName = UUID.randomUUID().toString();
        //取得原文件名
        String originalFilename = file.getOriginalFilename();
        //从原文件m名中分离出扩展名（后缀） 111.jpg -> jpg
        assert originalFilename != null;
        String suffixName = originalFilename.substring(originalFilename.lastIndexOf("."));
        //拼接新的文件名
        String fileName = prefixName + suffixName;
        log.info(fileName);
        //创建上传的文件对象
        File saveFile = new File(path + "/" +fileName);
        //上传文件
        try {
            file.transferTo(saveFile);
        } catch (IOException e) {
            log.info(e.getMessage());
            AjaxResponse.failure("文件上传失败");
        }
        return AjaxResponse.success(fileName);
    }
}




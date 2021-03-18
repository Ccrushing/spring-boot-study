package com.crush.book.repository;

import com.crush.book.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface BookRepository extends JpaRepository<Book,Integer> {

    /**
     * 根据书名查找并按id排序
     * @return List<Book>
     */
//    List<Book> findBookByNameAndOrderById();


}

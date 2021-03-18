package top.crushing.boot.basic.service;

import top.crushing.boot.basic.entity.Book;

import java.util.List;

/**
 * @author Crush
 * @date 2021/3/16
 * @dercsiption BookService
 */
public interface BookService {
    /**
     * 发布文章
     *
     @param book
     @return boolean
     */
    boolean postBook(Book book);
    /**
     * 根据id删除文章
     *
     * @param id 文章id
     * @return 删除是否成功
     */
    boolean deleteBook(int id);


    /**
     * 更新文章
     *
     * @param book  文章对象
     * @return 更新是否成功
     */
    boolean updateBook(Book book);


    /**
     *根据id查询文章
     *
     * @param id id
     * @return 查询到的文章对象
     */
    Book getById(int id);


    /**
     *根据id查询文章
     *
     *
     * @return 所有文章列表
     */
    List<Book> getAll();
}

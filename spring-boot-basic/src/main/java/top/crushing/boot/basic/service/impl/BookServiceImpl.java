package top.crushing.boot.basic.service.impl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.crushing.boot.basic.controller.dao.BookDAO;
import top.crushing.boot.basic.entity.Book;
import top.crushing.boot.basic.service.BookService;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Crush
 * @date 2021/3/16
 * @dercsiption BookServiceImpl
 */
@Service
public class BookServiceImpl implements BookService {
    @Resource
    private BookDAO bookDAO;

    @Transactional
    @Override
    public boolean postBook(Book book){
        Book saveBook = bookDAO.save(book);
//        int a = 3 / 0; //模拟可能出现的异常
        if(saveBook != null) {
            return true;
        }else {
            return false;
        }
   }

    /**
     * 根据id删除文章
     *
     * @param id 文章id
     * @return 删除是否成功
     */
    @Override
    public boolean deleteBook(int id) {
        int row = bookDAO.deletById(id);
        return row != 0;
    }
    /**
     * 更新文章
     *
     * @param book 文章对象
     * @return 更新是否成功
     */
    @Override
    public boolean updateBook(Book book) {
        int row = bookDAO.update(book);
        return row != 0;
    }
    /**
     * 根据id查询文章
     *
     * @param id id
     * @return 查询到的文章对象
     */
    @Override
    public Book getById(int id) {
        return bookDAO.findById(id);
    }

    /**
     * 根据id查询文章
     *
     * @return 所有文章列表
     */
    @Override
    public List<Book> getAll() {
        return bookDAO.findAll();
    }
}



package top.crushing.boot.basic.controller.dao;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import top.crushing.boot.basic.entity.Book;

import javax.annotation.Resource;
import java.util.List;


/**
 * @author Crush
 * @date 2021/3/16
 * @dercsiption BookDAO
 */
@Repository
public class BookDAO {
    @Resource
    private JdbcTemplate jdbcTemplate;

    //保存文章
    /**
     *
     * @param
     * @return
     */
    public Book save(Book book) {
        String sql = "INSERT INTO t_book (author,title,content) VALUES (?,?,?) ";
        Object[] args = {book.getAuthor(),book.getTitle(),book.getContent()};
        int count = jdbcTemplate.update(sql,args);
        if(count == 1 ) {
            return book;
        }else {
            return null;
        }
    }
    //根据id删除文章
    /**
     *
     * @param id id
     * @return int
     */
    public int deletById(Integer id) {

        return  jdbcTemplate.update("DELETE FROM t_book WHERE id = ?", id);
    }

//
    //更新文章
    /**
     *
     * @param book book
     * @return int
     */
    public int update(Book book) {
        return  jdbcTemplate.update("UPDATE t_book SET author = ?, title = ?, content = ?, createTime = ? WHERE id = ?",
                book.getAuthor(),
                book.getTitle(),
                book.getContent(),
                book.getCreateTime(),
                book.getId());
    }

//
    //根据id查找文章
    /**
     *
     * @param id id
     * @return book
     */
    public Book findById(Integer id) {
        List<Book> books = jdbcTemplate.query("SELECT * FROM t_book WHERE id = ? ",
                new Object[]{id}, new BeanPropertyRowMapper<>(Book.class));
        return  books.get(0);
    }
//
    //查询所有文章
    /**
     *
     * @return List<book>
     */
    public List<Book> findAll() {
        return  jdbcTemplate.query("SELECT * FROM t_book ",
                new BeanPropertyRowMapper<>(Book.class));
    }
}


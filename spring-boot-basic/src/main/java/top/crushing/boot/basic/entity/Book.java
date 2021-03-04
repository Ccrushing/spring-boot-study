package top.crushing.boot.basic.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

/**
 * @author Crush
 * @date 2021/3/4
 * @dercsiption Book
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Book {
    private Integer id;
    private String author;
    private  String title;
    private String content;
    private Date createTime;
    private List<BookReader> readers;
}

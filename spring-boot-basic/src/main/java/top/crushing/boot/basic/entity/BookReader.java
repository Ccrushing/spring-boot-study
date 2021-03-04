package top.crushing.boot.basic.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Crush
 * @date 2021/3/4
 * @dercsiption BookReader
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class BookReader  {
    private String name;
    private Integer  age;
}

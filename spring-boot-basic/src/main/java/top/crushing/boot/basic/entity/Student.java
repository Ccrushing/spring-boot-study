package top.crushing.boot.basic.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Crush
 * @date 2021/3/11
 * @dercsiption Student
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private Integer id;
    private String name;
}

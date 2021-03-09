package top.crushing.boot.basic.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Crush
 * @date 2021/3/9
 * @dercsiption Friend
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Friend {
    private String hobby;
    private String gender;
}

package top.crushing.boot.basic.entity;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author Crush
 * @date 2021/3/9
 * @dercsiption Father
 */
@Data
@Component
public class Father {
    @Value("${family.father.name}")
    private String name;
    @Value("${family.father.age}")
    private Integer age;
}

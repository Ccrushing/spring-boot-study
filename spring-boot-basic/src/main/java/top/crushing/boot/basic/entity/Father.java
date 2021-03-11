package top.crushing.boot.basic.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.validation.constraints.Min;

/**
 * @author Crush
 * @date 2021/3/9
 * @dercsiption Father
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Component
public class Father {

    private String name;
    @Min(20)

    private Integer age;
}

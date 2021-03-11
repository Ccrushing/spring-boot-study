package top.crushing.boot.basic.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Crush
 * @date 2021/3/9
 * @dercsiption Mother
 */
@AllArgsConstructor
@NoArgsConstructor
@Component
@Data
@Builder

public class Mother {
    private  List<String> alias;
}

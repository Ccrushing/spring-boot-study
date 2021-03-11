package top.crushing.boot.basic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@ImportResource(locations = {"classpath:beans.xml"})
@SpringBootApplication
public class SpringBootBasicApplication {

    public static void main(String[] args) {

        SpringApplication.run(SpringBootBasicApplication.class, args);
    }

}

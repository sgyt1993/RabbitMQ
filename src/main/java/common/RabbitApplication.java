package common;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * @Author:sgyt
 * @Description:
 * @Date:2018/11/27 10:34
 */
@SpringBootApplication
public class RabbitApplication extends SpringBootServletInitializer {
    public static void main(String[] args) {
        SpringApplication.run(RabbitApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(RabbitApplication.class);
    }
}

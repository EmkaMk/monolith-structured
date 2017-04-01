package com.seavus.bookstore.application;

import com.seavus.SpringBootApplicationConfig;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Import;

@Import(SpringBootApplicationConfig.class)
public class Application {

    public static void main(String[] args) {
        new SpringApplicationBuilder(Application.class).run(args);
    }
}

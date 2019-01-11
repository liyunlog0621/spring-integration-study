package com.lyl.springintegrationjdbc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("spring-integration-context.xml")
public class SpringIntegrationJdbcApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringIntegrationJdbcApplication.class, args);
    }

}


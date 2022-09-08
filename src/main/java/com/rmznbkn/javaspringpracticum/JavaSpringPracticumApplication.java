package com.rmznbkn.javaspringpracticum;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = {"com.rmznbkn.javaspringpracticum.repository"})
public class JavaSpringPracticumApplication {

    public static void main(String[] args) {
        SpringApplication.run(JavaSpringPracticumApplication.class, args);
    }

}

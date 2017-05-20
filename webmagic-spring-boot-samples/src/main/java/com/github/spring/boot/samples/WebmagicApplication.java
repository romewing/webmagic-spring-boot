package com.github.spring.boot.samples;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2017/4/26.
 */
@SpringBootApplication
@Component
public class WebmagicApplication {
    public static void main(String[] args) {
        SpringApplication.run(WebmagicApplication.class);
        System.out.println("AA");

    }

}

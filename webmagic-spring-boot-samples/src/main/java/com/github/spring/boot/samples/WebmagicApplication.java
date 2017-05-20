package com.github.spring.boot.samples;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.processor.SimplePageProcessor;

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

   /* @Bean
    public PageProcessor pageProcessor() {
        return new SimplePageProcessor("aa","aa");
    }*/

}

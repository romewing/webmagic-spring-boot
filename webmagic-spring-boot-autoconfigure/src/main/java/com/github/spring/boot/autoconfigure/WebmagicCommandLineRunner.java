package com.github.spring.boot.autoconfigure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.context.ApplicationListener;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.util.StringUtils;
import us.codecraft.webmagic.Spider;

/**
 * Created by Administrator on 2017/5/20.
 */
public class WebmagicCommandLineRunner implements CommandLineRunner, ApplicationEventPublisherAware {

    private ApplicationEventPublisher publisher;

    @Autowired
    private TaskScheduler taskScheduler;
    @Autowired
    private Spider spider;

    @Autowired
    private WebmagicProperties properties;

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.publisher = applicationEventPublisher;

    }


    @Override
    public void run(String... args) throws Exception {
        String cron = properties.getCron();
        if (StringUtils.hasText(cron)) {
            taskScheduler.schedule(spider, new CronTrigger(properties.getCron()));
        }
        int fixedRate = properties.getFixedRate();
        if(fixedRate > 0) {
            taskScheduler.scheduleAtFixedRate(spider, fixedRate);
        }
        int fixedDelay = properties.getFixedDelay();
        if(fixedDelay > 0) {
            taskScheduler.scheduleWithFixedDelay(spider, fixedDelay);
        }
    }
}

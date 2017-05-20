
package com.github.spring.boot.autoconfigure;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.Pipeline;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.processor.SimplePageProcessor;
import us.codecraft.webmagic.processor.example.GithubRepoPageProcessor;
import us.codecraft.webmagic.scheduler.Scheduler;

import java.util.List;
import java.util.Map;


/**
 * {@link org.springframework.boot.autoconfigure.EnableAutoConfiguration Auto-configuration} for WebMagic}.
 *
 * @author ZHANG Yi
 */
@Configuration
@ConditionalOnClass(Spider.class)
@EnableConfigurationProperties(WebmagicProperties.class)
@EnableScheduling
@ImportResource("classpath:applicationContext.xml")
public class WebmagicAutoConfiguration{



    private final WebmagicProperties properties;

    private final ConfigurableListableBeanFactory beanFactory;

    public WebmagicAutoConfiguration(WebmagicProperties properties,  ConfigurableListableBeanFactory beanFactory) {
        this.properties = properties;
        this.beanFactory = beanFactory;
    }


    @Bean
    @ConditionalOnProperty(prefix = "webmagic.spider", value = {"page-processor","urls"})
    public Spider spider() {
        Class<? extends PageProcessor> pageProcessor = properties.getPageProcessor();
        Spider spider = Spider.create(BeanUtils.instantiate(pageProcessor)).addUrl(properties.getUrls());
        List<Class<? extends Pipeline>> pipeLines = properties.getPipeLines();
        if (pipeLines != null) {
            for (Class<? extends Pipeline> pipeline : pipeLines) {
                spider.addPipeline(BeanUtils.instantiate(pipeline));
            }
        }
        Class<? extends Scheduler> scheduler = properties.getScheduler();
        if (scheduler != null) {
            spider.setScheduler(BeanUtils.instantiateClass(scheduler));
        }
        /*
        TaskScheduler taskScheduler = beanFactory.getBean(TaskScheduler.class);
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
        */
        return spider;
    }

    @Bean
    @ConditionalOnMissingBean
    @ConditionalOnProperty(prefix = "webmagic.spider", name = "auto", havingValue = "true", matchIfMissing = true)
   public SpiderCommandLineRunner spiderCommandLineRunner() {
        SpiderCommandLineRunner commandLineRunner = new SpiderCommandLineRunner();
        return commandLineRunner;
   }


}


package org.github.spring.boot.autoconfigure;

import org.aopalliance.intercept.Interceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ResourceLoader;
import org.springframework.scheduling.annotation.EnableScheduling;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.processor.SimplePageProcessor;

/**
 * Created by gh on 2017/4/26.
 */
@Configuration
@ConditionalOnClass(Spider.class)
@EnableConfigurationProperties(WebmagicProperties.class)
@EnableScheduling
public class WebmagicAutoConfiguration {

    public static final Logger logger = LoggerFactory.getLogger(WebmagicAutoConfiguration.class);

    private final Interceptor[] interceptors;

    private final ResourceLoader resourceLoader;

    private final WebmagicProperties properties;

    public WebmagicAutoConfiguration(WebmagicProperties properties, ObjectProvider<Interceptor[]> interceptorsProvider,
                                     ResourceLoader resourceLoader)  {
        this.properties = properties;
        this.interceptors = interceptorsProvider.getIfAvailable();
        this.resourceLoader = resourceLoader;
    }

   /* @Bean
    @ConditionalOnMissingBean(Spider.class)
    @ConditionalOnProperty(name = "webmagic.pageProcessor")
    public Spider spider(PageProcessor pageProcessor) {
       // Spider spider = Spider.create(pageProcessor).addUrl(properties.getUrls()).setUUID(properties.getUuid()).thread(properties.getThreadNum());
        if(properties.isStart()) {
            spider.start();
        }
        return spider;
    }*/

    @Bean
    @ConditionalOnMissingBean
    public PageProcessor pageProcessor() {
        PageProcessor pageProcessor = new SimplePageProcessor("","");
        return pageProcessor;
    }




}


package org.github.spring.boot.autoconfigure;

import org.aopalliance.intercept.Interceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ResourceLoader;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.downloader.Downloader;
import us.codecraft.webmagic.downloader.HttpClientDownloader;
import us.codecraft.webmagic.scheduler.QueueScheduler;
import us.codecraft.webmagic.scheduler.Scheduler;

/**
 * Created by gh on 2017/4/26.
 */
@Configuration
@ConditionalOnClass(Spider.class)
@EnableConfigurationProperties(WebmagicProperties.class)
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

    @Bean
    @ConditionalOnMissingBean
    public Scheduler scheduler() {
        return new QueueScheduler();
    }

    @Bean
    @ConditionalOnMissingBean
    public Downloader downloader() {
       return new HttpClientDownloader();
    }
}
